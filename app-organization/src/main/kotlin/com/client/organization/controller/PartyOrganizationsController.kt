package com.client.organization.controller

import com.client.organization.domain.Organization
import com.client.organization.service.PartyOrganizationsService
import com.client.organization.controller.api.PartyOrganizationsApi
import com.client.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class PartyOrganizationsController(service: PartyOrganizationsService)
    : AbstractController<Organization, PartyOrganizationsService>(service), PartyOrganizationsApi {


    override fun partyOrganizationsCreateOrganization(
			@PathVariable("partyId") partyId: String,
			@RequestBody organization: Organization): ResponseEntity<Organization> {
        return super.create(partyId, organization)
    }

    override fun partyOrganizationsGetOrganization(
			@PathVariable("partyId") partyId: String,
			@PathVariable("organizationtId") organizationtId: String): ResponseEntity<Organization> {
        return super.getById(partyId, organizationtId)
    }

    override fun partyOrganizationsGetOrganizationList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Organization>> {
        return getAll(partyId, search, page)
    }

    override fun partyOrganizationsModifyOrganization(
			@PathVariable("partyId") partyId: String,
			@PathVariable("organizationtId") organizationtId: String,
			@RequestBody organization: Organization): ResponseEntity<Organization> {
        return super.modify(partyId, organizationtId, organization)
    }

    override fun partyOrganizationsUpdateOrganization(
			@PathVariable("partyId") partyId: String,
			@PathVariable("organizationtId") organizationtId: String,
			@RequestBody organization: Organization): ResponseEntity<Organization> {
        return super.update(partyId, organizationtId, organization)
    }

}
