package com.client.organization.controller

import com.client.organization.domain.Employee
import com.client.organization.service.EmployeesReadOnlyService
import com.client.organization.controller.api.EmployeesReadOnlyApi
import io.swagger.annotations.ApiParam
import com.client.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class EmployeesReadOnlyController(service: EmployeesReadOnlyService)
    : AbstractController<Employee, EmployeesReadOnlyService>(service), EmployeesReadOnlyApi {


    override fun employeesReadOnlyGetEmployee(
			@PathVariable("employeeId") employeeId: String): ResponseEntity<Employee> {
        return super.getById(employeeId)
    }

    override fun employeesReadOnlyGetEmployeeList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Employee>> {
        return getAll(search, page)
    }

}
