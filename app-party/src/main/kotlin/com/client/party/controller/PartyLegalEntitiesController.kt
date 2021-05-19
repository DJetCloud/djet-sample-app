package com.client.party.controller

import com.client.party.domain.LegalEntity
import com.client.party.service.PartyLegalEntitiesService
import com.client.party.controller.api.PartyLegalEntitiesApi
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
class PartyLegalEntitiesController(service: PartyLegalEntitiesService)
    : AbstractController<LegalEntity, PartyLegalEntitiesService>(service), PartyLegalEntitiesApi {


    override fun partyLegalEntitiesCreateLegalEntity(
			@PathVariable("partyId") partyId: String,
			@RequestBody legalEntity: LegalEntity): ResponseEntity<LegalEntity> {
		return super.create(partyId, legalEntity)
    }

    override fun partyLegalEntitiesDeleteLegalEntity(
			@PathVariable("partyId") partyId: String,
			@PathVariable("legalentityId") legalentityId: String): ResponseEntity<LegalEntity> {
		return super.delete(partyId, legalentityId)
    }

    override fun partyLegalEntitiesGetLegalEntity(
			@PathVariable("partyId") partyId: String,
			@PathVariable("legalentityId") legalentityId: String): ResponseEntity<LegalEntity> {
		return super.getById(partyId, legalentityId)
    }

    override fun partyLegalEntitiesGetLegalEntityList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<LegalEntity>> {
		return getAll(partyId, search, page)
    }

    override fun partyLegalEntitiesModifyLegalEntity(
			@PathVariable("partyId") partyId: String,
			@PathVariable("legalentityId") legalentityId: String,
			@RequestBody legalEntity: LegalEntity): ResponseEntity<LegalEntity> {
		return super.modify(partyId, legalentityId, legalEntity)
    }

    override fun partyLegalEntitiesUpdateLegalEntity(
			@PathVariable("partyId") partyId: String,
			@PathVariable("legalentityId") legalentityId: String,
			@RequestBody legalEntity: LegalEntity): ResponseEntity<LegalEntity> {
		return super.update(partyId, legalentityId, legalEntity)
    }

}
