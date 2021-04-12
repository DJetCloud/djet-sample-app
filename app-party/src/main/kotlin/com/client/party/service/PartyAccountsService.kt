package com.client.party.service

import com.client.party.domain.Account
import com.client.party.repository.PartyAccountsRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PartyAccountsService(
    repository: PartyAccountsRepository
) : AbstractService<Account, PartyAccountsRepository>(repository)
