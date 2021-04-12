package com.client.user.service

import com.client.user.domain.Person
import com.client.user.repository.PersonsRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PersonsService(
    repository: PersonsRepository
) : AbstractService<Person, PersonsRepository>(repository)
