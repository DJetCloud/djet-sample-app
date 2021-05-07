package com.client.product.controller

import com.client.product.domain.ContractItem
import com.client.product.service.ContractItemsService
import com.client.product.controller.api.ContractItemsApi
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
class ContractItemsController(service: ContractItemsService)
    : AbstractController<ContractItem, ContractItemsService>(service), ContractItemsApi {


    override fun contractItemsCreateContractItem(
			@PathVariable("contractId") contractId: String,
			@RequestBody contractItem: ContractItem): ResponseEntity<ContractItem> {
        return super.create(contractId, contractItem)
    }

    override fun contractItemsDeleteContractItem(
			@PathVariable("contractId") contractId: String,
			@PathVariable("contractItemId") contractItemId: String): ResponseEntity<ContractItem> {
        return super.delete(contractId, contractItemId)
    }

    override fun contractItemsGetContractItem(
			@PathVariable("contractId") contractId: String,
			@PathVariable("contractItemId") contractItemId: String): ResponseEntity<ContractItem> {
        return super.getById(contractId, contractItemId)
    }

    override fun contractItemsGetContractItemList(
			@PathVariable("contractId") contractId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<ContractItem>> {
        return getAll(contractId, search, page)
    }

    override fun contractItemsModifyContractItem(
			@PathVariable("contractId") contractId: String,
			@PathVariable("contractItemId") contractItemId: String,
			@RequestBody contractItem: ContractItem): ResponseEntity<ContractItem> {
        return super.modify(contractId, contractItemId, contractItem)
    }

    override fun contractItemsUpdateContractItem(
			@PathVariable("contractId") contractId: String,
			@PathVariable("contractItemId") contractItemId: String,
			@RequestBody contractItem: ContractItem): ResponseEntity<ContractItem> {
        return super.update(contractId, contractItemId, contractItem)
    }

}
