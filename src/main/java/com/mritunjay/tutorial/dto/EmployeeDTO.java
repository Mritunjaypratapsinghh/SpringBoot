package com.mritunjay.tutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data // Lombok annotation to generate getters, setters, equals, hashCode, and toString
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
public class EmployeeDTO {

    private Long id; // Employee ID

    private String name; // Employee name

    private LocalDate dateOfJoining; // Employee's date of joining

    @JsonProperty("isActive") // Ensures JSON uses "isActive" instead of "active"
    private Boolean isActive;
}
