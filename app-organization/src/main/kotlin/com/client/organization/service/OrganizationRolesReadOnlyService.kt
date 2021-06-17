package com.client.organization.service

import com.client.organization.domain.OrganizationRole
import com.client.organization.repository.OrganizationRolesReadOnlyRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class OrganizationRolesReadOnlyService(
    repository: OrganizationRolesReadOnlyRepository
) : AbstractService<OrganizationRole, OrganizationRolesReadOnlyRepository>(repository)
