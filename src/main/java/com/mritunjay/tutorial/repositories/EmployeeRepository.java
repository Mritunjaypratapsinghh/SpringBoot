package com.mritunjay.tutorial.repositories;

import com.mritunjay.tutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this interface as a Spring-managed repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
