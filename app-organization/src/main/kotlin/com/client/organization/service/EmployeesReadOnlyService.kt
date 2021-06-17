package com.client.organization.service

import com.client.organization.domain.Employee
import com.client.organization.repository.EmployeesReadOnlyRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class EmployeesReadOnlyService(
    repository: EmployeesReadOnlyRepository
) : AbstractService<Employee, EmployeesReadOnlyRepository>(repository)
