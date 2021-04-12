package com.client.party.service

import com.client.party.domain.Party
import com.client.party.repository.PartiesRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PartiesService(
    repository: PartiesRepository
) : AbstractService<Party, PartiesRepository>(repository)
