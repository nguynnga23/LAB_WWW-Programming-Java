package com.example.services;

import com.example.entities.Thuoc;
import java.util.List;
public interface ThuocService {
    public List<Thuoc> getAllThuoc();
    public List<Thuoc> getAllThuocByLoaiThuoc(int maLoaiThuoc);
    public Thuoc getThuocById(int id);
    public boolean addThuoc(Thuoc thuoc);
    public boolean updateThuoc(Thuoc thuoc);
    public boolean deleteThuoc(int id);
    public List<Thuoc> getAllThuocByTenThuoc(String tenThuoc);
    public List<Thuoc> getAllThuocByGia(double gia);
}
