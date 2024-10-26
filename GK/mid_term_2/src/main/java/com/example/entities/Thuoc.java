package com.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Thuoc")
@NamedQueries({
        @NamedQuery(name = "Thuoc.findAll", query = "select t from Thuoc t"),
        @NamedQuery(name = "Thuoc.findByLoaiThuoc_MaLoai", query = "select t from Thuoc t where t.loaiThuoc.maLoai = :maLoai"),
        @NamedQuery(name = "Thuoc.findByGia", query = "select t from Thuoc t where t.gia = :gia"),
        @NamedQuery(name = "Thuoc.findByTenThuoc", query = "select t from Thuoc t where t.tenThuoc like :tenThuoc"),
})
public class Thuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maThuoc;
    private String tenThuoc;
    private double gia;
    private int nameSX;
    @ManyToOne
    @JoinColumn(name = "maLoai")
    private LoaiThuoc loaiThuoc;

    public Thuoc() {
    }

    public Thuoc(int maThuoc, String tenThuoc, double gia, int nameSX, LoaiThuoc loaiThuoc) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.nameSX = nameSX;
        this.loaiThuoc = loaiThuoc;
    }

    public Thuoc(String tenThuoc, double gia, int nameSX, LoaiThuoc loaiThuoc) {
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.nameSX = nameSX;
        this.loaiThuoc = loaiThuoc;
    }

    public LoaiThuoc getLoaiThuoc() {
        return loaiThuoc;
    }

    public void setLoaiThuoc(LoaiThuoc loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }

    public int getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(int maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getNameSX() {
        return nameSX;
    }

    public void setNameSX(int nameSX) {
        this.nameSX = nameSX;
    }

    @Override
    public String toString() {
        return "Thuoc{" +
                "maThuoc=" + maThuoc +
                ", tenThuoc='" + tenThuoc + '\'' +
                ", gia=" + gia +
                ", nameSX=" + nameSX +
                '}';
    }
}
