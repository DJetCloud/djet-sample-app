package com.client.user.controller.api

import com.client.user.domain.Person
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Api(value = "Persons", tags = ["Persons"], description = "the Persons API")
interface PersonsApi {

    @ApiOperation(value = "CreatePerson", nickname = "personsCreatePerson", notes = "Create new Person. Validate Person not yet exist.", tags=["Persons"],)
    @ApiResponses(
        ApiResponse(code = 201, message = "Object created successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 401, message = "Object is already exist.")
    )
    @PostMapping("/persons")
    fun personsCreatePerson(
			@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetPerson", nickname = "personsGetPerson", notes = "Get person or list of persons from service.", tags=["Persons"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Person is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Object is not found")
    )
    @GetMapping("/persons/{personId}")
    fun personsGetPerson(
			@PathVariable("personId") personId: String): ResponseEntity<Person> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetPersonList", nickname = "personsGetPersonList", notes = "Get person or list of persons from service.", tags=["Persons"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Person is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Object is not found")
    )
    @GetMapping("/persons")
    fun personsGetPersonList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Person>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyPerson", nickname = "personsModifyPerson", notes = "Change Person properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["Persons"],)
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Object is not found")
    )
    @PatchMapping("/persons/{personId}")
    fun personsModifyPerson(
			@PathVariable("personId") personId: String,
			@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdatePerson", nickname = "personsUpdatePerson", notes = "Change person specification. Person will be created if not exist.", tags=["Persons"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
    )
    @PutMapping("/persons/{personId}")
    fun personsUpdatePerson(
			@PathVariable("personId") personId: String,
			@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
