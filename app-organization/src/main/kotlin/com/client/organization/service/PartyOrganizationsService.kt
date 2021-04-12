package com.client.organization.service

import com.client.organization.domain.Organization
import com.client.organization.repository.PartyOrganizationsRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PartyOrganizationsService(
    repository: PartyOrganizationsRepository
) : AbstractService<Organization, PartyOrganizationsRepository>(repository)
