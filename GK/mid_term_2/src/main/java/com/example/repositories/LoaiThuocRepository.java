package com.example.repositories;

import com.example.entities.LoaiThuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuocRepository {
    private EntityManager em;
    public LoaiThuocRepository() {
        em = Persistence.createEntityManagerFactory("midterm2").createEntityManager();
    }

    public List<LoaiThuoc> getAll() {
        try {
            return em.createNamedQuery("LoaiThuoc.findAll", LoaiThuoc.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (em != null) {
                em.close(); // Đảm bảo EntityManager được đóng
            }
        }
    }

    public LoaiThuoc getById(int id) {
        return em.find(LoaiThuoc.class, id);
    }

    public boolean save(LoaiThuoc loaiThuoc) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(loaiThuoc);
            tx.commit();
            return true;
        }catch(Exception e){
            tx.rollback();
            return false;
        }finally {
            em.close();
        }
    }

    public boolean update(LoaiThuoc loaiThuoc) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.merge(loaiThuoc);
            tx.commit();
            return true;
        }catch(Exception e){
            tx.rollback();
            return false;
        }finally {
            em.close();
        }
    }

    public boolean delete(int maLoai) {
        return em.createNamedQuery("LoaiThuoc.deleteByMaLoai").setParameter("maLoai", maLoai).getResultList().size()>0;
    }

    public static void main(String[] args) {
        LoaiThuocRepository repo = new LoaiThuocRepository();
        LoaiThuoc loaiThuoc1 = new LoaiThuoc("Thuoc khang sinh");
        LoaiThuoc loaiThuoc2 = new LoaiThuoc("Thuoc giam dau");
        LoaiThuoc loaiThuoc3 = new LoaiThuoc("Thuoc chong di ung");
//        System.out.println( repo.save(loaiThuoc1));
//        System.out.println( repo.save(loaiThuoc2));
//        System.out.println( repo.save(loaiThuoc3));
        List<LoaiThuoc> loaiThuocs = repo.getAll();
        for (LoaiThuoc loaiThuoc : loaiThuocs) {
            System.out.println(loaiThuoc);
        }
    }
}
