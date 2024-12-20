package com.example.services.impl;

import com.example.entities.LoaiThuoc;
import com.example.repositories.LoaiThuocRepository;
import com.example.repositories.ThuocRepository;
import com.example.services.LoaiThuocService;

import java.util.List;

public class LoaiThuocServiceImpl implements LoaiThuocService {
    private LoaiThuocRepository loaiThuocRepository;
    public LoaiThuocServiceImpl() {
        loaiThuocRepository = new LoaiThuocRepository();
    }
    @Override
    public List<LoaiThuoc> getAllLoaiThuoc() {
        return loaiThuocRepository.getAll();
    }

    @Override
    public LoaiThuoc getLoaiThuocById(int id) {
        return loaiThuocRepository.getById(id);
    }

    @Override
    public boolean addLoaiThuoc(LoaiThuoc loaiThuoc) {
        return loaiThuocRepository.save(loaiThuoc);
    }

    @Override
    public boolean deleteLoaiThuoc(int id) {
        return loaiThuocRepository.delete(id);
    }

    @Override
    public boolean updateLoaiThuoc(LoaiThuoc loaiThuoc) {
        return loaiThuocRepository.update(loaiThuoc);
    }
}
