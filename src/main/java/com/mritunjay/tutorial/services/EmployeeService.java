package com.mritunjay.tutorial.services;

import com.mritunjay.tutorial.dto.EmployeeDTO;
import com.mritunjay.tutorial.entities.EmployeeEntity;
import com.mritunjay.tutorial.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    // Constructor Injection (Best Practice)
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Retrieves an employee by ID.
     *
     * @param id The employee ID.
     * @return EmployeeDTO of the found employee.
     * @throws EntityNotFoundException if employee not found.
     */
    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    /**
     * Creates a new employee.
     *
     * @param employeeDTO Employee data transfer object.
     * @return EmployeeDTO of the created employee.
     */
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    /**
     * Retrieves all employees.
     *
     * @return List of EmployeeDTOs.
     */
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Deletes an employee by ID.
     *
     * @param id The employee ID.
     * @return true if deletion is successful, false otherwise.
     * @throws EntityNotFoundException if employee not found.
     */
    public boolean deleteEmployeeById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
        return true;
    }

    /**
     * Updates an Employee by ID.
     *
     * @param id The employee ID. @EmployeeDTO employee data transfer object
     * @return Employee DTO of updated employee
     */
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee Not Found"));

        //Update all fields (PUT behaviour)
        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setDateOfJoining(employeeDTO.getDateOfJoining());
        existingEmployee.setIsActive(employeeDTO.getIsActive());

        return modelMapper.map(employeeRepository.save(existingEmployee),EmployeeDTO.class);
    }

    public EmployeeDTO partialUpdateEmployee(Long id, EmployeeDTO employeeDTO){
        EmployeeEntity existingEmployee = employeeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Employee Not Found"));

        //Only Update Provided Field
        if(employeeDTO.getName()!=null){
            existingEmployee.setName(employeeDTO.getName());
        }
        if(employeeDTO.getDateOfJoining()!=null){
            existingEmployee.setDateOfJoining(employeeDTO.getDateOfJoining());
        }

        if(employeeDTO.getIsActive()!=null){
            existingEmployee.setIsActive(employeeDTO.getIsActive());
        }

        return modelMapper.map(employeeRepository.save(existingEmployee),EmployeeDTO.class);






    }


}
