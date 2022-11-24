package com.example.application.views.service;

import com.example.application.views.entity.Center;
import com.example.application.views.entity.Package;
import com.example.application.views.repository.CenterRepository;
import com.example.application.views.repository.PackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class CrmService {
    private final CenterRepository centerRepository;
    private final PackageRepository packageRepository;


    public CrmService(CenterRepository centerRepository, PackageRepository packageRepository){
        this.centerRepository = centerRepository;
        this.packageRepository = packageRepository;
    }

    public List<Package> finAllPackages(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return packageRepository.findAll();
        } else{
            return packageRepository.search(filterText);
        }
    }

    public long countPackages() {
        return packageRepository.count();
    }

    public void deletePackage(Package packageDeleted) {
        packageRepository.delete(packageDeleted);
    }

    public void savePackage(Package packageToSave) {
        if (packageToSave == null) {
            System.err.println("Package is null");
            return;
        }

        packageRepository.save(packageToSave);
    }

    public List<Center> findAllCenters() {
        return centerRepository.findAll();
    }

}
