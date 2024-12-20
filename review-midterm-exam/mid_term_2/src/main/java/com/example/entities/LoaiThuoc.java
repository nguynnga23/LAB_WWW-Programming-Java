package com.example.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "LoaiThuoc")
@NamedQueries({
        @NamedQuery(name = "LoaiThuoc.findAll", query = "select l from LoaiThuoc l"),
        @NamedQuery(name = "LoaiThuoc.updateTenLoaiBy", query = "update LoaiThuoc l set l.tenLoai = :tenLoai"),
        @NamedQuery(name = "LoaiThuoc.deleteByMaLoai", query = "delete from LoaiThuoc l where l.maLoai = :maLoai"),
        @NamedQuery(name = "LoaiThuoc.existsByMaLoai", query = "select (count(l) > 0) from LoaiThuoc l where l.maLoai = :maLoai")
})
public class LoaiThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLoai;
    private String tenLoai;

    @OneToMany(mappedBy = "loaiThuoc", fetch = FetchType.LAZY)
    private Set<Thuoc> thuocSet;

    public LoaiThuoc() {
    }

    public LoaiThuoc(int maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public LoaiThuoc(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public LoaiThuoc(int maLoai) {
        this.maLoai = maLoai;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "LoaiThuoc{" +
                "maLoai=" + maLoai +
                ", tenLoai='" + tenLoai + '\'' +
                '}';
    }
}
