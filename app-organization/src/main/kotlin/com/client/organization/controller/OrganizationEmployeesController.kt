package com.client.organization.controller

import com.client.organization.domain.Employee
import com.client.organization.service.OrganizationEmployeesService
import com.client.organization.controller.api.OrganizationEmployeesApi
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
class OrganizationEmployeesController(service: OrganizationEmployeesService)
    : AbstractController<Employee, OrganizationEmployeesService>(service), OrganizationEmployeesApi {


    override fun organizationEmployeesCreateEmployee(
			@PathVariable("organizationId") organizationId: String,
			@RequestBody employee: Employee): ResponseEntity<Employee> {
		return super.create(organizationId, employee)
    }

    override fun organizationEmployeesDeleteEmployee(
			@PathVariable("employeeId") employeeId: String,
			@PathVariable("organizationId") organizationId: String): ResponseEntity<Employee> {
		return super.delete(organizationId, employeeId)
    }

    override fun organizationEmployeesGetEmployee(
			@PathVariable("employeeId") employeeId: String,
			@PathVariable("organizationId") organizationId: String): ResponseEntity<Employee> {
		return super.getById(organizationId, employeeId)
    }

    override fun organizationEmployeesGetEmployeeList(
			@PathVariable("organizationId") organizationId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Employee>> {
		return getAll(organizationId, search, page)
    }

    override fun organizationEmployeesModifyEmployee(
			@PathVariable("employeeId") employeeId: String,
			@PathVariable("organizationId") organizationId: String,
			@RequestBody employee: Employee): ResponseEntity<Employee> {
		return super.modify(organizationId, employeeId, employee)
    }

    override fun organizationEmployeesUpdateEmployee(
			@PathVariable("employeeId") employeeId: String,
			@PathVariable("organizationId") organizationId: String,
			@RequestBody employee: Employee): ResponseEntity<Employee> {
		return super.update(organizationId, employeeId, employee)
    }

}
