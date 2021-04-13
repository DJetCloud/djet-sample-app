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

@Api(value = "OrganizationRoles", tags = ["OrganizationRoles"], description = "the OrganizationRoles API")
interface OrganizationRolesApi {

    @ApiOperation(value = "CreateOrganizationRole", nickname = "organizationRolesCreateOrganizationRole", notes = "Create new organization role. Validate organization role not exist for this organization yet.", tags=["OrganizationRoles"],)
    @ApiResponses(
        ApiResponse(code = 201, message = "Create operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 401, message = "Organization Role is already exist.")
    )
    @PostMapping("/organizations/{organizationId}/organizationroles")
    fun organizationRolesCreateOrganizationRole(
			@PathVariable("organizationId") organizationId: String,
			@RequestBody organizationRole: OrganizationRole): ResponseEntity<OrganizationRole> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "DeleteOrganizationRole", nickname = "organizationRolesDeleteOrganizationRole", notes = "Delete organization role if it exists", tags=["OrganizationRoles"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization Role is not found")
    )
    @DeleteMapping("/organizations/{organizationId}/organizationroles/{organizationRoleId}")
    fun organizationRolesDeleteOrganizationRole(
			@PathVariable("organizationId") organizationId: String,
			@PathVariable("organizationRoleId") organizationRoleId: String): ResponseEntity<OrganizationRole> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetOrganizationRole", nickname = "organizationRolesGetOrganizationRole", notes = "Get organization role or list of employ roles from service.", tags=["OrganizationRoles"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization Role is not found")
    )
    @GetMapping("/organizations/{organizationId}/organizationroles/{organizationRoleId}")
    fun organizationRolesGetOrganizationRole(
			@PathVariable("organizationId") organizationId: String,
			@PathVariable("organizationRoleId") organizationRoleId: String): ResponseEntity<OrganizationRole> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetOrganizationRoleList", nickname = "organizationRolesGetOrganizationRoleList", notes = "Get organization role or list of employ roles from service.", tags=["OrganizationRoles"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization Role is not found")
    )
    @GetMapping("/organizations/{organizationId}/organizationroles")
    fun organizationRolesGetOrganizationRoleList(
			@PathVariable("organizationId") organizationId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<OrganizationRole>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyOrganizationRole", nickname = "organizationRolesModifyOrganizationRole", notes = "Change organization role properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["OrganizationRoles"],)
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization Role is not found")
    )
    @PatchMapping("/organizations/{organizationId}/organizationroles/{organizationRoleId}")
    fun organizationRolesModifyOrganizationRole(
			@PathVariable("organizationId") organizationId: String,
			@PathVariable("organizationRoleId") organizationRoleId: String,
			@RequestBody organizationRole: OrganizationRole): ResponseEntity<OrganizationRole> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateOrganizationRole", nickname = "organizationRolesUpdateOrganizationRole", notes = "Change organization role specification. Organization role will be created if not exist.", tags=["OrganizationRoles"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Organization Role is not found")
    )
    @PutMapping("/organizations/{organizationId}/organizationroles/{organizationRoleId}")
    fun organizationRolesUpdateOrganizationRole(
			@PathVariable("organizationId") organizationId: String,
			@PathVariable("organizationRoleId") organizationRoleId: String,
			@RequestBody organizationRole: OrganizationRole): ResponseEntity<OrganizationRole> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
