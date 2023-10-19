package com.db.example.data;


//This interface may be user to get customized object from the database
//The repository query fields are mapped to methodnames e.g. ename => getEname()
public interface EmployeeInfoDto {
    String getEname();
    String getCname();
}
