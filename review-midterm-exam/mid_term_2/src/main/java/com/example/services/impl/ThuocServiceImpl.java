package com.example.services.impl;

import com.example.entities.Thuoc;
import com.example.repositories.ThuocRepository;
import com.example.services.ThuocService;

import java.util.List;

public class ThuocServiceImpl implements ThuocService {
    private ThuocRepository thuocRepository;
    public ThuocServiceImpl() {
        thuocRepository = new ThuocRepository();
    }
    @Override
    public List<Thuoc> getAllThuoc() {
        return thuocRepository.findAll();
    }

    @Override
    public List<Thuoc> getAllThuocByLoaiThuoc(int maLoaiThuoc) {
        return thuocRepository.findByMaLoaiThuoc(maLoaiThuoc);
    }

    @Override
    public Thuoc getThuocById(int id) {
        return thuocRepository.findById(id);
    }

    @Override
    public boolean addThuoc(Thuoc thuoc) {
        return thuocRepository.save(thuoc);
    }

    @Override
    public boolean updateThuoc(Thuoc thuoc) {
        return thuocRepository.save(thuoc);
    }

    @Override
    public boolean deleteThuoc(int id) {
        return thuocRepository.delete(id);
    }

    @Override
    public List<Thuoc> getAllThuocByTenThuoc(String tenThuoc) {
        return thuocRepository.findByTenThuoc(tenThuoc);
    }

    @Override
    public List<Thuoc> getAllThuocByGia(double gia) {
        return List.of();
    }
}
