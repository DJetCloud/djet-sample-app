package com.client.organization.service

import com.client.organization.domain.OrganizationRole
import com.client.organization.repository.OrganizationRolesRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class OrganizationRolesService(
    repository: OrganizationRolesRepository
) : AbstractService<OrganizationRole, OrganizationRolesRepository>(repository)
