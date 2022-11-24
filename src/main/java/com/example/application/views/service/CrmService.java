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
            return null;
        } else{
            return null;
        }
    }
}
