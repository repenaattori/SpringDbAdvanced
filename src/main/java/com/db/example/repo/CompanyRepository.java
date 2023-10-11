package com.db.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.example.data.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

    //Transactional and modifying annotations required when modifying database
    @Transactional
    @Modifying
    @Query(value="INSERT INTO company (name) VALUES (:cname)", nativeQuery = true)
    void addCompany(String cname);
}

