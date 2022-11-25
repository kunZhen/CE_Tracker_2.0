package com.example.application.views.service;

import com.example.application.views.entity.Center;
import com.example.application.views.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;


public class CenterService {

    @Autowired
    private CenterRepository centerRepository;

    public LinkedList<Center> getAllCenters() {
        return (LinkedList<Center>) centerRepository.findAll();
    }

    public void addCenter(Center newCenter){
        centerRepository.save(newCenter);
    }

}
