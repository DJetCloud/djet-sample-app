package com.client.party.controller.api

import com.client.party.domain.Account
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

@Api(value = "PartyAccounts", tags = ["PartyAccounts"], description = "the PartyAccounts API")
interface PartyAccountsApi {

    @ApiOperation(value = "CreateAccount", nickname = "partyAccountsCreateAccount", notes = "Create new account. Validate account not exist for this party yet.", tags=["PartyAccounts"])
    @ApiResponses(
        ApiResponse(code = 201, message = "Create operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 401, message = "Account is already exist.")
    )
    @PostMapping("/parties/{partyId}/accounts")
    fun partyAccountsCreateAccount(
			@PathVariable("partyId") partyId: String,
			@RequestBody account: Account): ResponseEntity<Account> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "DeleteAccount", nickname = "partyAccountsDeleteAccount", notes = "Delete the account of party if the account is exists", tags=["PartyAccounts"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Account is not found")
    )
    @DeleteMapping("/parties/{partyId}/accounts/{accountId}")
    fun partyAccountsDeleteAccount(
			@PathVariable("partyId") partyId: String,
			@PathVariable("accountId") accountId: String): ResponseEntity<Account> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetAccount", nickname = "partyAccountsGetAccount", notes = "Get account or list of accounts from service.", tags=["PartyAccounts"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Account is not found")
    )
    @GetMapping("/parties/{partyId}/accounts/{accountId}")
    fun partyAccountsGetAccount(
			@PathVariable("partyId") partyId: String,
			@PathVariable("accountId") accountId: String): ResponseEntity<Account> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetAccountList", nickname = "partyAccountsGetAccountList", notes = "Get account or list of accounts from service.", tags=["PartyAccounts"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Object is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Account is not found")
    )
    @GetMapping("/parties/{partyId}/accounts")
    fun partyAccountsGetAccountList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Account>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyAccount", nickname = "partyAccountsModifyAccount", notes = "Change account properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["PartyAccounts"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Account is not found")
    )
    @PatchMapping("/parties/{partyId}/accounts/{accountId}")
    fun partyAccountsModifyAccount(
			@PathVariable("partyId") partyId: String,
			@PathVariable("accountId") accountId: String,
			@RequestBody account: Account): ResponseEntity<Account> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateAccount", nickname = "partyAccountsUpdateAccount", notes = "Change account specification. Account will be created if not exist.", tags=["PartyAccounts"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully without object returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Account is not found")
    )
    @PutMapping("/parties/{partyId}/accounts/{accountId}")
    fun partyAccountsUpdateAccount(
			@PathVariable("partyId") partyId: String,
			@PathVariable("accountId") accountId: String,
			@RequestBody account: Account): ResponseEntity<Account> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
