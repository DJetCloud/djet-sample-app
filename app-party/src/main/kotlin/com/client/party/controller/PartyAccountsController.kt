package com.client.party.controller

import com.client.party.domain.Account
import com.client.party.service.PartyAccountsService
import com.client.party.controller.api.PartyAccountsApi
import com.client.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class PartyAccountsController(service: PartyAccountsService)
    : AbstractController<Account, PartyAccountsService>(service), PartyAccountsApi {


    override fun partyAccountsCreateAccount(
			@PathVariable("partyId") partyId: String,
			@RequestBody account: Account): ResponseEntity<Account> {
        return super.create(partyId, account)
    }

    override fun partyAccountsGetAccount(
			@PathVariable("partyId") partyId: String,
			@PathVariable("accountId") accountId: String): ResponseEntity<Account> {
        return super.getById(partyId, accountId)
    }

    override fun partyAccountsGetAccountList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Account>> {
        return getAll(partyId, search, page)
    }

    override fun partyAccountsModifyAccount(
			@PathVariable("partyId") partyId: String,
			@PathVariable("accountId") accountId: String,
			@RequestBody account: Account): ResponseEntity<Account> {
        return super.modify(partyId, accountId, account)
    }

    override fun partyAccountsUpdateAccount(
			@PathVariable("partyId") partyId: String,
			@PathVariable("accountId") accountId: String,
			@RequestBody account: Account): ResponseEntity<Account> {
        return super.update(partyId, accountId, account)
    }

}
