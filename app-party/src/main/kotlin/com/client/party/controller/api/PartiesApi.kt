package com.client.party.controller.api

import com.client.party.domain.Party
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

@Api(value = "Parties", tags = ["Parties"], description = "the Parties API")
interface PartiesApi {

    @ApiOperation(value = "CreateParty", nickname = "partiesCreateParty", notes = "Create new party. Validate party not exist yet.", tags=["Parties"],)
    @ApiResponses(
        ApiResponse(code = 201, message = "Create operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 401, message = "Party is already exist.")
    )
    @PostMapping("/parties")
    fun partiesCreateParty(
			@RequestBody party: Party): ResponseEntity<Party> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetParty", nickname = "partiesGetParty", notes = "Get party or list of parties from service.", tags=["Parties"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Party is found and returned."),
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Party is not found")
    )
    @GetMapping("/parties/{partyId}")
    fun partiesGetParty(
			@PathVariable("partyId") partyId: String): ResponseEntity<Party> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetPartyList", nickname = "partiesGetPartyList", notes = "Get party or list of parties from service.", tags=["Parties"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Party is found and returned."),
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Party is not found")
    )
    @GetMapping("/parties")
    fun partiesGetPartyList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Party>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyParty", nickname = "partiesModifyParty", notes = "Change party properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["Parties"],)
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Party is not found")
    )
    @PatchMapping("/parties/{partyId}")
    fun partiesModifyParty(
			@PathVariable("partyId") partyId: String,
			@RequestBody party: Party): ResponseEntity<Party> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateParty", nickname = "partiesUpdateParty", notes = "Change party specification. Party will be created if not exist.", tags=["Parties"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Party is not found")
    )
    @PutMapping("/parties/{partyId}")
    fun partiesUpdateParty(
			@PathVariable("partyId") partyId: String,
			@RequestBody party: Party): ResponseEntity<Party> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
