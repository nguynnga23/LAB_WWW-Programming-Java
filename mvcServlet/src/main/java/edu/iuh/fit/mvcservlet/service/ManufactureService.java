package edu.iuh.fit.mvcservlet.service;

import edu.iuh.fit.mvcservlet.model.Manufacturer;
import edu.iuh.fit.mvcservlet.repositories.GeneralRepository;

import java.util.List;

public class ManufactureService {
    private GeneralRepository<Manufacturer,Long> repository;

    public ManufactureService(){
        repository = new GeneralRepository<>("Manufacturer");
    }

    public List<Manufacturer> findAll(){
       return repository.findAll();
    }

    //Kaiwin

    public Manufacturer findById(Manufacturer manufacturer, int id) {
        return repository.findByEntity(manufacturer, (long) id);
    }

    public Manufacturer deleteManu(Manufacturer manufacturer, int id) {
        return repository.delete(manufacturer, (long) id);
    }

    public Manufacturer saveM(Manufacturer manufacturer) {
        return repository.saveM(manufacturer);
    }
//
    public Manufacturer updateManu(Manufacturer manufacturer) {
        return repository.update(manufacturer);
    }
}
