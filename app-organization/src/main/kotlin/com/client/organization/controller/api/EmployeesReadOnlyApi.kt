package com.client.organization.controller.api

import com.client.organization.domain.Employee
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Api(value = "EmployeesReadOnly", tags = ["EmployeesReadOnly"], description = "the EmployeesReadOnly API")
interface EmployeesReadOnlyApi {

    @ApiOperation(value = "GetEmployee", nickname = "employeesReadOnlyGetEmployee", notes = "Get employee or list of employees from service.", tags=["EmployeesReadOnly"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Employee is not found")
    )
    @GetMapping("/employees/{employeeId}")
    fun employeesReadOnlyGetEmployee(
			@PathVariable("employeeId") employeeId: String): ResponseEntity<Employee> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetEmployeeList", nickname = "employeesReadOnlyGetEmployeeList", notes = "Get employee or list of employees from service.", tags=["EmployeesReadOnly"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Employee is not found")
    )
    @GetMapping("/employees")
    fun employeesReadOnlyGetEmployeeList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Employee>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
