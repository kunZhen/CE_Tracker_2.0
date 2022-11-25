package com.example.application.views.service;

import com.example.application.views.entity.Center;
import com.example.application.views.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

public class CenterService {
    private final CenterRepository centerRepository;


    public CenterService(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public List<Center> finAllPackages(String filterText){
        if (filterText == null || filterText.isEmpty()) {
            return centerRepository.findAll();
        } else {
            return centerRepository.search(filterText);
        }
    }
}
