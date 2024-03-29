package com.db.example.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.example.data.Employee;
import com.db.example.data.EmployeeInfoDto;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //JPA kustom queryjä voidaan tehdä find metodeilla. Alla olevat esim. mapataan suoraan sql-kyselyiksi.
    //By-sanan jälkeen tulee etsittävä kenttä esim. findByName --> name
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories

    //Etsii name-jäsenmuuttujan perusteella
    List<Employee> findByName(String name);

    //Etsii jos name-jäsenmuuttuja sisältää
    List<Employee> findByNameContains(String keyword);

    //Etsii työntekijät joiden id pienempi kuin limit
    List<Employee> findByIdLessThan(Integer limit);


    //JPQL-formaatilla voidaan tehdä SQL-tyylisiä kyselyjä käyttäen olioita ja parametreja
    
    //Palautustyyppi vastaa haetun sarakkeen tietotyyppiä (e.name --> String)
    @Query("SELECT e.name FROM Employee e")
    List<String> getEmployeeNames();

    //Parametri kaksoispisteellä kyselyyn
    @Query("SELECT e.name FROM Employee e WHERE e.name LIKE %:keyword%")
    List<String> getEmployeeNamesByKeyword(String keyword);


    //Voidaan myös tehdä täysin natiiveja SQL-kyselyjä. Haetaan kaikkien työntekijöiden yrityksen id
    @Query(value="SELECT company_id FROM employee", nativeQuery = true)
    List<Integer> getCompanyIds();

    //Natiivikyselyjen tuloksia voidaan myös käsitellä mappauksena.
    //Yksi mappaus on yksi rivi. Key on sarakkeen nimi, value vastaava arvo.
    @Query(value="SELECT employee.name ename, company.name cname  FROM employee JOIN company ON company.id=employee.company_id", nativeQuery = true)
    List<Map<String, Object>> getCustomEmployeeInfo();

    //Useampi sarake talletetaan kustomoituun DTO-olioon.
    //Aliaksilla erotellaan nimet DTO:hon  ename-->getEname  cname-->getCname
    @Query(value="SELECT e.name ename, c.name cname FROM employee e JOIN company c ON e.company_id=c.id", nativeQuery = true)
    List<EmployeeInfoDto> getNativeDTO();
    
}
