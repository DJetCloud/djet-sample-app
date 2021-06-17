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

@Api(value = "OrganizationsReadOnly", tags = ["OrganizationsReadOnly"], description = "the OrganizationsReadOnly API")
interface OrganizationsReadOnlyApi {

    @ApiOperation(value = "GetOrganization", nickname = "organizationsReadOnlyGetOrganization", notes = "Get organization or list of organizations from service.", tags=["OrganizationsReadOnly"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization is not found")
    )
    @GetMapping("/organizations/{organizationtId}")
    fun organizationsReadOnlyGetOrganization(
			@PathVariable("organizationtId") organizationtId: String): ResponseEntity<Organization> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetOrganizationList", nickname = "organizationsReadOnlyGetOrganizationList", notes = "Get organization or list of organizations from service.", tags=["OrganizationsReadOnly"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization is not found")
    )
    @GetMapping("/organizations")
    fun organizationsReadOnlyGetOrganizationList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Organization>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
