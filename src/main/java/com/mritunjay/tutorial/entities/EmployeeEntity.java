package com.mritunjay.tutorial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity // Marks this class as a JPA entity (mapped to a database table)
@Table(name = "employees") // Specifies the table name in the database
@Data // Lombok annotation for getters, setters, equals, hashCode, and toString
@AllArgsConstructor // Lombok annotation for a constructor with all fields
@NoArgsConstructor // Lombok annotation for a no-args constructor
public class EmployeeEntity {

    @Id // Marks 'id' as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Uses database auto-increment
    private Long id;

    @Column(nullable = false, length = 100) // Name cannot be null, max length 100
    private String name; // Employee name

    private LocalDate dateOfJoining; // Stores the date when the employee joined

    @Column(name = "is_active", nullable = false) // Maps explicitly to "is_active" in DB
    private Boolean isActive; // Indicates whether the employee is currently active
}
