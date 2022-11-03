package com.db.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.example.data.Employee;
import com.db.example.data.EmployeeInfoDto;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //JPA kustom queryjä voidaan tehdä find metodeilla. Alla olevat esim. mapataan suoraan sql-kyselyiksi.
    //By-sanan jälkeen tulee etsittävä kenttä esim. findByName --> name
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories

    //Etsii name-jäsenmuuttujan perusteella
    List<Employee> findByName(String name);

    //Etsii jos name-jäsenmuuttuja sisältää
    List<Employee> findByNameContains(String keyword);

    //Etsii työntekijät joiden id pienempi kuin limit
    List<Employee> findByIdLessThan(Long limit);


    //JPQL-formaatilla voidaan tehdä SQL-tyylisiä kyselyjä käyttäen olioita ja parametreja
    
    //Palautustyyppi vastaa haetun sarakkeen tietotyyppiä (e.name --> String)
    @Query("SELECT e.name FROM Employee e")
    List<String> getEmployeeNames();

    //Parametri kaksoispisteellä kyselyyn
    @Query("SELECT e.name FROM Employee e WHERE e.name LIKE %:keyword%")
    List<String> getEmployeeNamesByKeyword(String keyword);

    //Useampi sarake talletetaan kustomoituun DTO-olioon.
    //Aliaksilla erotellaan nimet DTO:hon  ename-->getEname  cname-->getCname
    @Query("SELECT e.name as ename, c.name as cname FROM Employee e JOIN Company c ON e.companyId=c.id")
    List<EmployeeInfoDto> getEmpoyeeInfos();

    //Voidaan myös tehdä täysin natiiveja SQL-kyselyjä. Haetaan kaikkien työntekijöiden yrityksen id
    @Query(value="SELECT company_id FROM employee", nativeQuery = true)
    List<Long> getCompanyIds();


    
}
