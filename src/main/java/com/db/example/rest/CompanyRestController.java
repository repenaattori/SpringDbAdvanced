package com.db.example.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.db.example.data.EmployeeInfoDto;
import com.db.example.service.CompanyService;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CompanyRestController {

    CompanyService compService;

    public CompanyRestController(CompanyService compService){
        this.compService = compService;
    }


    @GetMapping("/search")
    public List<String> getNamesByText(@RequestParam String keyword){
        return compService.searchNamesByKeyword(keyword);
    }

    @GetMapping("/employeeinfos")
    public List<EmployeeInfoDto> getEmployeeInfos(){
        return compService.getEmployeeInfos();
    }

    @GetMapping("/customemployees")
    public List<Map<String, Object>> getCustoEmployeeInfo(){
        return compService.getCustom();
    }
}
