package com.client.user.service

import com.client.user.domain.Contact
import com.client.user.repository.ContactsRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class ContactsService(
    repository: ContactsRepository
) : AbstractService<Contact, ContactsRepository>(repository)
