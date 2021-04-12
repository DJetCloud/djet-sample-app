package com.client.party.service

import com.client.party.domain.LegalEntity
import com.client.party.repository.PartyLegalEntitiesRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PartyLegalEntitiesService(
    repository: PartyLegalEntitiesRepository
) : AbstractService<LegalEntity, PartyLegalEntitiesRepository>(repository)
