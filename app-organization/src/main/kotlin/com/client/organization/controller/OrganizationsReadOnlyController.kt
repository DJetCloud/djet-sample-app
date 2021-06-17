package com.client.organization.controller

import com.client.organization.domain.Organization
import com.client.organization.service.OrganizationsReadOnlyService
import com.client.organization.controller.api.OrganizationsReadOnlyApi
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
class OrganizationsReadOnlyController(service: OrganizationsReadOnlyService)
    : AbstractController<Organization, OrganizationsReadOnlyService>(service), OrganizationsReadOnlyApi {


    override fun organizationsReadOnlyGetOrganization(
			@PathVariable("organizationtId") organizationtId: String): ResponseEntity<Organization> {
        return super.getById(organizationtId)
    }

    override fun organizationsReadOnlyGetOrganizationList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Organization>> {
        return getAll(search, page)
    }

}
