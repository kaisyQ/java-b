package com.book.test.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Book {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name = "title", nullable = false)
    private String title;

}
