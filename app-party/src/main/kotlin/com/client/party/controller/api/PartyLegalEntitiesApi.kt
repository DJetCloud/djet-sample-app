package com.client.party.controller.api

import com.client.party.domain.LegalEntity
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

@Api(value = "PartyLegalEntities", tags = ["PartyLegalEntities"], description = "the PartyLegalEntities API")
interface PartyLegalEntitiesApi {

    @ApiOperation(value = "CreateLegalEntity", nickname = "partyLegalEntitiesCreateLegalEntity", notes = "Create new legal entity. Validate legal entity not exist for this client", tags=["PartyLegalEntities"])
    @ApiResponses(
        ApiResponse(code = 201, message = "Create operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 401, message = "Legal Entity is already exist.")
    )
    @PostMapping("/parties/{partyId}/legalentities")
    fun partyLegalEntitiesCreateLegalEntity(
			@PathVariable("partyId") partyId: String,
			@RequestBody legalEntity: LegalEntity): ResponseEntity<LegalEntity> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "DeleteLegalEntity", nickname = "partyLegalEntitiesDeleteLegalEntity", notes = "Delete legal entity of the party if the legal entity exists", tags=["PartyLegalEntities"])
    @ApiResponses(
        ApiResponse(code = 200, message = "LegalEntity is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Legal Entity is not found")
    )
    @DeleteMapping("/parties/{partyId}/legalentities/{legalentityId}")
    fun partyLegalEntitiesDeleteLegalEntity(
			@PathVariable("partyId") partyId: String,
			@PathVariable("legalentityId") legalentityId: String): ResponseEntity<LegalEntity> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetLegalEntity", nickname = "partyLegalEntitiesGetLegalEntity", notes = "Get legal entity or list of legal entities from service.", tags=["PartyLegalEntities"])
    @ApiResponses(
        ApiResponse(code = 200, message = "LegalEntity is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Legal Entity is not found")
    )
    @GetMapping("/parties/{partyId}/legalentities/{legalentityId}")
    fun partyLegalEntitiesGetLegalEntity(
			@PathVariable("partyId") partyId: String,
			@PathVariable("legalentityId") legalentityId: String): ResponseEntity<LegalEntity> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetLegalEntityList", nickname = "partyLegalEntitiesGetLegalEntityList", notes = "Get legal entity or list of legal entities from service.", tags=["PartyLegalEntities"])
    @ApiResponses(
        ApiResponse(code = 200, message = "LegalEntity is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Legal Entity is not found")
    )
    @GetMapping("/parties/{partyId}/legalentities")
    fun partyLegalEntitiesGetLegalEntityList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<LegalEntity>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyLegalEntity", nickname = "partyLegalEntitiesModifyLegalEntity", notes = "Change legal entity properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["PartyLegalEntities"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Legal Entity is not found")
    )
    @PatchMapping("/parties/{partyId}/legalentities/{legalentityId}")
    fun partyLegalEntitiesModifyLegalEntity(
			@PathVariable("partyId") partyId: String,
			@PathVariable("legalentityId") legalentityId: String,
			@RequestBody legalEntity: LegalEntity): ResponseEntity<LegalEntity> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateLegalEntity", nickname = "partyLegalEntitiesUpdateLegalEntity", notes = "Change legal entity specification. Legal entity will be created if not exist. ", tags=["PartyLegalEntities"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Legal Entity is not found")
    )
    @PutMapping("/parties/{partyId}/legalentities/{legalentityId}")
    fun partyLegalEntitiesUpdateLegalEntity(
			@PathVariable("partyId") partyId: String,
			@PathVariable("legalentityId") legalentityId: String,
			@RequestBody legalEntity: LegalEntity): ResponseEntity<LegalEntity> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
