package com.tutorial.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tutorial.springrest.dao.EmployeeManagementDAO;
import com.tutorial.springrest.model.Employee;

@RestController
public class EmployeeManagementController {

	@Autowired
	private EmployeeManagementDAO employeeManagementDAO;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeManagementDAO.list();
	}
	
	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable("id") int id) {
		Employee employee = employeeManagementDAO.get(id);
		if(employee == null) {
			return new ResponseEntity<String>("No employee data exist for this ID, Please try another.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PostMapping(value = "/employees/insertar")
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		employeeManagementDAO.save(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	/*Pongo el método Post en Postman y la peticion http: localhost:8080/employees/insertar
		También, le doy a Body y dentro de body a raw y escribo en el hueco
	{
        "id": 502,
        "name": "Test 5",
        "email": "test5@gmail.com",
        "address": "",
        "telephone": "121-232-3435"
    }
    */

	@DeleteMapping(value = "/employees/borrar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if(employeeManagementDAO.delete(id) <= 0) {
			return new ResponseEntity<String>("No employee data exist for this ID, Please try another.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}
}