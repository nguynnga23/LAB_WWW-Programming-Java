package com.example.services;

import com.example.entities.LoaiThuoc;

import java.util.List;

public interface LoaiThuocService {
    public List<LoaiThuoc> getAllLoaiThuoc();
    public LoaiThuoc getLoaiThuocById(int id);
    public boolean addLoaiThuoc(LoaiThuoc loaiThuoc);
    public boolean deleteLoaiThuoc(int id);
    public boolean updateLoaiThuoc(LoaiThuoc loaiThuoc);
}
