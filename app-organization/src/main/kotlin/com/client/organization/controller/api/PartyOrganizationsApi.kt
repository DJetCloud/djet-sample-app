package com.client.organization.controller.api

import com.client.organization.domain.Organization
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

@Api(value = "PartyOrganizations", tags = ["PartyOrganizations"], description = "the PartyOrganizations API")
interface PartyOrganizationsApi {

    @ApiOperation(value = "CreateOrganization", nickname = "partyOrganizationsCreateOrganization", notes = "Create new organization. Validate organization not exist for this party yet.", tags=["PartyOrganizations"],)
    @ApiResponses(
        ApiResponse(code = 201, message = "Create operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 401, message = "Organization is already exist.")
    )
    @PostMapping("/parties/{partyId}/organizations")
    fun partyOrganizationsCreateOrganization(
			@PathVariable("partyId") partyId: String,
			@RequestBody organization: Organization): ResponseEntity<Organization> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "DeleteOrganization", nickname = "partyOrganizationsDeleteOrganization", notes = "Delete organization of party", tags=["PartyOrganizations"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization is not found")
    )
    @DeleteMapping("/parties/{partyId}/organizations/{organizationtId}")
    fun partyOrganizationsDeleteOrganization(
			@PathVariable("partyId") partyId: String,
			@PathVariable("organizationtId") organizationtId: String): ResponseEntity<Organization> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetOrganization", nickname = "partyOrganizationsGetOrganization", notes = "Get organization or list of organizations from service.", tags=["PartyOrganizations"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization is not found")
    )
    @GetMapping("/parties/{partyId}/organizations/{organizationtId}")
    fun partyOrganizationsGetOrganization(
			@PathVariable("partyId") partyId: String,
			@PathVariable("organizationtId") organizationtId: String): ResponseEntity<Organization> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetOrganizationList", nickname = "partyOrganizationsGetOrganizationList", notes = "Get organization or list of organizations from service.", tags=["PartyOrganizations"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization is not found")
    )
    @GetMapping("/parties/{partyId}/organizations")
    fun partyOrganizationsGetOrganizationList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Organization>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyOrganization", nickname = "partyOrganizationsModifyOrganization", notes = "Change organization properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["PartyOrganizations"],)
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization is not found")
    )
    @PatchMapping("/parties/{partyId}/organizations/{organizationtId}")
    fun partyOrganizationsModifyOrganization(
			@PathVariable("partyId") partyId: String,
			@PathVariable("organizationtId") organizationtId: String,
			@RequestBody organization: Organization): ResponseEntity<Organization> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateOrganization", nickname = "partyOrganizationsUpdateOrganization", notes = "Change organization specification. Organization will be created if not exist.", tags=["PartyOrganizations"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization is not found")
    )
    @PutMapping("/parties/{partyId}/organizations/{organizationtId}")
    fun partyOrganizationsUpdateOrganization(
			@PathVariable("partyId") partyId: String,
			@PathVariable("organizationtId") organizationtId: String,
			@RequestBody organization: Organization): ResponseEntity<Organization> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
