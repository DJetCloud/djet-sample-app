package com.client.organization.controller

import com.client.organization.domain.OrganizationRole
import com.client.organization.service.OrganizationRolesService
import com.client.organization.controller.api.OrganizationRolesApi
import com.client.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class OrganizationRolesController(service: OrganizationRolesService)
    : AbstractController<OrganizationRole, OrganizationRolesService>(service), OrganizationRolesApi {


    override fun organizationRolesCreateOrganizationRole(
			@PathVariable("organizationId") organizationId: String,
			@RequestBody organizationRole: OrganizationRole): ResponseEntity<OrganizationRole> {
        return super.create(organizationId, organizationRole)
    }

    override fun organizationRolesDeleteOrganizationRole(
			@PathVariable("organizationId") organizationId: String,
			@PathVariable("organizationRoleId") organizationRoleId: String): ResponseEntity<OrganizationRole> {
        return super.delete(organizationId, organizationRoleId)
    }

    override fun organizationRolesGetOrganizationRole(
			@PathVariable("organizationId") organizationId: String,
			@PathVariable("organizationRoleId") organizationRoleId: String): ResponseEntity<OrganizationRole> {
        return super.getById(organizationId, organizationRoleId)
    }

    override fun organizationRolesGetOrganizationRoleList(
			@PathVariable("organizationId") organizationId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<OrganizationRole>> {
        return getAll(organizationId, search, page)
    }

    override fun organizationRolesModifyOrganizationRole(
			@PathVariable("organizationId") organizationId: String,
			@PathVariable("organizationRoleId") organizationRoleId: String,
			@RequestBody organizationRole: OrganizationRole): ResponseEntity<OrganizationRole> {
        return super.modify(organizationId, organizationRoleId, organizationRole)
    }

    override fun organizationRolesUpdateOrganizationRole(
			@PathVariable("organizationId") organizationId: String,
			@PathVariable("organizationRoleId") organizationRoleId: String,
			@RequestBody organizationRole: OrganizationRole): ResponseEntity<OrganizationRole> {
        return super.update(organizationId, organizationRoleId, organizationRole)
    }

}
