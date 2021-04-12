package com.client.organization.service

import com.client.organization.domain.Employee
import com.client.organization.repository.OrganizationEmployeesRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class OrganizationEmployeesService(
    repository: OrganizationEmployeesRepository
) : AbstractService<Employee, OrganizationEmployeesRepository>(repository)
