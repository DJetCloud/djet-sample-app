package com.client.organization.controller.api

import com.client.organization.domain.OrganizationRole
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

@Api(value = "OrganizationRolesReadOnly", tags = ["OrganizationRolesReadOnly"], description = "the OrganizationRolesReadOnly API")
interface OrganizationRolesReadOnlyApi {

    @ApiOperation(value = "GetOrganizationRole", nickname = "organizationRolesReadOnlyGetOrganizationRole", notes = "Get organization role or list of employ roles from service.", tags=["OrganizationRolesReadOnly"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization Role is not found")
    )
    @GetMapping("/organizationroles/{organizationRoleId}")
    fun organizationRolesReadOnlyGetOrganizationRole(
			@PathVariable("organizationRoleId") organizationRoleId: String): ResponseEntity<OrganizationRole> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetOrganizationRoleList", nickname = "organizationRolesReadOnlyGetOrganizationRoleList", notes = "Get organization role or list of employ roles from service.", tags=["OrganizationRolesReadOnly"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization Role is not found")
    )
    @GetMapping("/organizationroles")
    fun organizationRolesReadOnlyGetOrganizationRoleList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<OrganizationRole>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
