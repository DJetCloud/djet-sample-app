package com.client.organization.controller

import com.client.organization.domain.OrganizationRole
import com.client.organization.service.OrganizationRolesReadOnlyService
import com.client.organization.controller.api.OrganizationRolesReadOnlyApi
import io.swagger.annotations.ApiParam
import com.client.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class OrganizationRolesReadOnlyController(service: OrganizationRolesReadOnlyService)
    : AbstractController<OrganizationRole, OrganizationRolesReadOnlyService>(service), OrganizationRolesReadOnlyApi {


    override fun organizationRolesReadOnlyGetOrganizationRole(
			@PathVariable("organizationRoleId") organizationRoleId: String): ResponseEntity<OrganizationRole> {
        return super.getById(organizationRoleId)
    }

    override fun organizationRolesReadOnlyGetOrganizationRoleList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<OrganizationRole>> {
        return getAll(search, page)
    }

}
