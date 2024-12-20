package com.example.repositories;

import com.example.entities.LoaiThuoc;
import com.example.entities.Thuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class ThuocRepository {
    private EntityManager em;
    private LoaiThuocRepository loaiThuocRepository;
    public ThuocRepository() {
        em = Persistence.createEntityManagerFactory("midterm2").createEntityManager();
    }

    public List<Thuoc> findAll() {
       return em.createNamedQuery("Thuoc.findAll").getResultList();
    }

    public List<Thuoc> findByMaLoaiThuoc(int maLoaiThuoc) {
        return em.createNamedQuery("Thuoc.findByLoaiThuoc_MaLoai").setParameter("maLoai", maLoaiThuoc).getResultList();
    }

    public List<Thuoc> findByTenThuoc(String tenThuoc) {
        return em.createNamedQuery("Thuoc.findByTenThuoc").setParameter("tenThuoc", "%" + tenThuoc + "%").getResultList();
    }
    public List<Thuoc> findByGia(double gia) {
        return em.createNamedQuery("Thuoc.findByGia").setParameter("gia", gia).getResultList();
    }
    public Thuoc findById(int id) {
        return em.find(Thuoc.class, id);
    }

    public boolean save(Thuoc thuoc) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(thuoc);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            return false;
        }
    }

    public boolean update(Thuoc thuoc) {
        loaiThuocRepository = new LoaiThuocRepository();
        if(loaiThuocRepository.getById(thuoc.getLoaiThuoc().getMaLoai()) != null){
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();
                em.merge(thuoc);
                tx.commit();
                return true;
            }catch (Exception e){
                tx.rollback();
                return false;
            }
        }
        else{
                return false;
            }
    }

    public boolean delete(int id) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Thuoc thuoc = em.find(Thuoc.class, id);
            em.remove(thuoc);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            return false;
        }
    }
    public static void main(String[] args) {
        ThuocRepository repo = new ThuocRepository();
        LoaiThuoc loaiThuoc = new LoaiThuoc(3);
        Thuoc thuoc = new Thuoc("Cetirizine", 10000f, 2012, loaiThuoc);
        System.out.println(repo.save(thuoc));
        System.out.println(repo.delete(11));
    }
}
