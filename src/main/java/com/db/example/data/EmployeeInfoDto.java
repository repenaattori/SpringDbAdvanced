package com.db.example.data;

//Tätä rajapintaa voidaan käyttää palauttamaan reposorysta kustomoidun olion
//Tietokanhaussa haettuja kenttiä vastaa getterit kuten ename -> getEname
public interface EmployeeInfoDto {
    String getEname();
    String getCname();
}
