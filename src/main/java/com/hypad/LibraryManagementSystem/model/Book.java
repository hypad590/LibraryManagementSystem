package com.hypad.LibraryManagementSystem.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String name;
    private String bookInfo;
    private int id;
}
