package com.example.application.views.repository;

import com.example.application.views.entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CenterRepository extends JpaRepository<Center, Integer> {

    @Query("select c from Package c" +
            "where lower(c.name) like lower(concat('%', :searchTerm, '%')) ")
    List<Center> search(@Param("searchTerm") String searchTerm);

}
