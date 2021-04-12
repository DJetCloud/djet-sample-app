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

@Api(value = "OrganizationEmployees", tags = ["OrganizationEmployees"], description = "the OrganizationEmployees API")
interface OrganizationEmployeesApi {

    @ApiOperation(value = "CreateEmployee", nickname = "organizationEmployeesCreateEmployee", notes = "Create new employee. Validate employee not exist for this party yet.", tags=["OrganizationEmployees"],)
    @ApiResponses(
        ApiResponse(code = 201, message = "Create operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 401, message = "Employee is already exist.")
    )
    @PostMapping("/organizations/{organizationId}/employees")
    fun organizationEmployeesCreateEmployee(
			@PathVariable("organizationId") organizationId: String,
			@RequestBody employee: Employee): ResponseEntity<Employee> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetEmployee", nickname = "organizationEmployeesGetEmployee", notes = "Get employee or list of employees from service.", tags=["OrganizationEmployees"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Employee is not found")
    )
    @GetMapping("/organizations/{organizationId}/employees/{employeeId}")
    fun organizationEmployeesGetEmployee(
			@PathVariable("employeeId") employeeId: String,
			@PathVariable("organizationId") organizationId: String): ResponseEntity<Employee> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetEmployeeList", nickname = "organizationEmployeesGetEmployeeList", notes = "Get employee or list of employees from service.", tags=["OrganizationEmployees"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Employee is not found")
    )
    @GetMapping("/organizations/{organizationId}/employees")
    fun organizationEmployeesGetEmployeeList(
			@PathVariable("organizationId") organizationId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Employee>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyEmployee", nickname = "organizationEmployeesModifyEmployee", notes = "Change employee properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["OrganizationEmployees"],)
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Employee is not found")
    )
    @PatchMapping("/organizations/{organizationId}/employees/{employeeId}")
    fun organizationEmployeesModifyEmployee(
			@PathVariable("employeeId") employeeId: String,
			@PathVariable("organizationId") organizationId: String,
			@RequestBody employee: Employee): ResponseEntity<Employee> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateEmployee", nickname = "organizationEmployeesUpdateEmployee", notes = "Change employee specification. Employee will be created if not exist.", tags=["OrganizationEmployees"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Employee is not found")
    )
    @PutMapping("/organizations/{organizationId}/employees/{employeeId}")
    fun organizationEmployeesUpdateEmployee(
			@PathVariable("employeeId") employeeId: String,
			@PathVariable("organizationId") organizationId: String,
			@RequestBody employee: Employee): ResponseEntity<Employee> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
