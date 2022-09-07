package com.example.edu.miu.restphase1.entity;

import lombok.Data;

@Data
public class Course {

    private int id;
    private String name;
    private String code;

    private boolean deleted;
}
