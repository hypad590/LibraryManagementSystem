package com.hypad.LibraryManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String surName;
    private String patronymic; //Отчество
    private String id;
}
