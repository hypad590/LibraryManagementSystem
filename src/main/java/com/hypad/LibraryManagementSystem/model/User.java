package com.hypad.LibraryManagementSystem.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private String surName;
    private String patronymic; //Отчество
    private String id;
}
