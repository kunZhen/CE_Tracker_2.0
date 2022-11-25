package com.example.application.views.service;

import com.example.application.views.entity.Package;
import com.example.application.views.repository.PackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public List<Package> findAllPackages(String filterText){
        return packageRepository.findAll();
    }
}
