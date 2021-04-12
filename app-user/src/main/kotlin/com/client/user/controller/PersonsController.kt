package com.client.user.controller

import com.client.user.domain.Person
import com.client.user.service.PersonsService
import com.client.user.controller.api.PersonsApi
import com.client.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class PersonsController(service: PersonsService)
    : AbstractController<Person, PersonsService>(service), PersonsApi {


    override fun personsCreatePerson(
			@RequestBody person: Person): ResponseEntity<Person> {
        return super.create(person)
    }

    override fun personsGetPerson(
			@PathVariable("personId") personId: String): ResponseEntity<Person> {
        return super.getById(personId)
    }

    override fun personsGetPersonList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Person>> {
        return getAll(search, page)
    }

    override fun personsModifyPerson(
			@PathVariable("personId") personId: String,
			@RequestBody person: Person): ResponseEntity<Person> {
        return super.modify(personId, person)
    }

    override fun personsUpdatePerson(
			@PathVariable("personId") personId: String,
			@RequestBody person: Person): ResponseEntity<Person> {
        return super.update(personId, person)
    }

}
