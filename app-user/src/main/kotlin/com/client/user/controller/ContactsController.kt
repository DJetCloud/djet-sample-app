package com.client.user.controller

import com.client.user.domain.Contact
import com.client.user.service.ContactsService
import com.client.user.controller.api.ContactsApi
import com.client.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class ContactsController(service: ContactsService)
    : AbstractController<Contact, ContactsService>(service), ContactsApi {


    override fun contactsCreateContact(
			@RequestBody contact: Contact): ResponseEntity<Contact> {
        return super.create(contact)
    }

    override fun contactsDeleteContact(
			@PathVariable("contactId") contactId: String): ResponseEntity<Contact> {
        return super.delete(contactId)
    }

    override fun contactsGetContact(
			@PathVariable("contactId") contactId: String): ResponseEntity<Contact> {
        return super.getById(contactId)
    }

    override fun contactsGetContactList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Contact>> {
        return getAll(search, page)
    }

    override fun contactsModifyContact(
			@PathVariable("contactId") contactId: String,
			@RequestBody contact: Contact): ResponseEntity<Contact> {
        return super.modify(contactId, contact)
    }

    override fun contactsUpdateContact(
			@PathVariable("contactId") contactId: String,
			@RequestBody contact: Contact): ResponseEntity<Contact> {
        return super.update(contactId, contact)
    }

}
