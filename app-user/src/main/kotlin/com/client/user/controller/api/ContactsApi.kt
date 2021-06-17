package com.client.user.controller.api

import com.client.user.domain.Contact
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

@Api(value = "Contacts", tags = ["Contacts"], description = "the Contacts API")
interface ContactsApi {

    @ApiOperation(value = "CreateContact", nickname = "contactsCreateContact", notes = "Create new Contact. Validate Contact not yet exist.", tags=["Contacts"])
    @ApiResponses(
        ApiResponse(code = 201, message = "Object created successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 401, message = "Contact is already exist.")
    )
    @PostMapping("/contacts")
    fun contactsCreateContact(
			@RequestBody contact: Contact): ResponseEntity<Contact> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "DeleteContact", nickname = "contactsDeleteContact", notes = "Delete contact if it exist", tags=["Contacts"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Contact is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @DeleteMapping("/contacts/{contactId}")
    fun contactsDeleteContact(
			@PathVariable("contactId") contactId: String): ResponseEntity<Contact> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetContact", nickname = "contactsGetContact", notes = "Get contact or list of contacts from service.", tags=["Contacts"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Contact is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/contacts/{contactId}")
    fun contactsGetContact(
			@PathVariable("contactId") contactId: String): ResponseEntity<Contact> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetContactList", nickname = "contactsGetContactList", notes = "Get contact or list of contacts from service.", tags=["Contacts"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Contact is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/contacts")
    fun contactsGetContactList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Contact>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyContact", nickname = "contactsModifyContact", notes = "Change Contact properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["Contacts"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @PatchMapping("/contacts/{contactId}")
    fun contactsModifyContact(
			@PathVariable("contactId") contactId: String,
			@RequestBody contact: Contact): ResponseEntity<Contact> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateContact", nickname = "contactsUpdateContact", notes = "Change contact specification. Contact will be created if not exist.", tags=["Contacts"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
    )
    @PutMapping("/contacts/{contactId}")
    fun contactsUpdateContact(
			@PathVariable("contactId") contactId: String,
			@RequestBody contact: Contact): ResponseEntity<Contact> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
