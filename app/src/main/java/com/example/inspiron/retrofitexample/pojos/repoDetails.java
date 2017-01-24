package com.example.inspiron.retrofitexample.pojos;

import java.io.Serializable;

/**
 * Created by INSPIRON on 24-Jan-17.
 */

public class repoDetails implements Serializable {

    private Integer id;
    private String name;
    private String fullName;

    public repoDetails (Integer id, String name, String fullName){
        this.id = id;
        this.name = name;
        this.fullName = fullName;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }





}
