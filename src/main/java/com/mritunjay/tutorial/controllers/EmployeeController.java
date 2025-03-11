package com.mritunjay.tutorial.controllers;

import com.mritunjay.tutorial.dto.EmployeeDTO;
import com.mritunjay.tutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Marks this class as a RESTful controller in Spring
@RequestMapping(path = "/employees")  // Base URL for all endpoints in this controller
public class EmployeeController {

    private final EmployeeService employeeService;

    // Constructor-based Dependency Injection of EmployeeService
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Retrieves an employee by their ID.
     * HTTP Method: GET
     * URL: /employees/{id}
     * @param employeeId The ID of the employee to retrieve.
     * @return EmployeeDTO representing the employee data.
     */
    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    /**
     * Creates a new employee.
     * HTTP Method: POST
     * URL: /employees
     * @param employeeDTO Employee data in request body.
     * @return The created EmployeeDTO.
     */
    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    /**
     * Retrieves all employees.
     * HTTP Method: GET
     * URL: /employees
     * @return A list of EmployeeDTOs.
     */
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * Deletes an employee by their ID.
     * HTTP Method: DELETE
     * URL: /employees/{id}
     * @param id The ID of the employee to delete.
     * @return true if deletion was successful, false otherwise.
     */
    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id) {
        return employeeService.deleteEmployeeById(id);
    }

    /**
     * Updates an employee record by their ID.
     * HTTP Method: PUT
     * URL: /employees/{id}
     * @param id The ID of the employee to update. @param employeeDTO Employee data in request body.
     * @return the updated EmployeeDTO
     */
    @PutMapping(path = "/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(id,employeeDTO);
    }

    /**
     * Partial Updates an employee record by their ID.
     * HTTP Method: Patch
     * URL: /employees/{id}
     * @param id The ID of the employee to update. @param employeeDTO Employee data in request body.
     * @return the partial updated EmployeeDTO
     */
    @PatchMapping(path = "/{id}")
    public EmployeeDTO partialUpdateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.partialUpdateEmployee(id,employeeDTO);
    }


}
