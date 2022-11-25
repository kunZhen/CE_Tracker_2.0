package com.example.application.views.repository;

import com.example.application.views.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PackageRepository extends JpaRepository<Package, String>{
    @Query("select p from Package p" +
            "where lower(p.hexCode) like lower(concat('%', :searchTerm, '%')) ")
    List<Package> search(@Param("searchTerm") String searchTerm);
}
