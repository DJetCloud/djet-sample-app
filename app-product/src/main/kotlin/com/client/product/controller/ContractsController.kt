package com.client.product.controller

import com.client.product.domain.Contract
import com.client.product.service.ContractsService
import com.client.product.controller.api.ContractsApi
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
class ContractsController(service: ContractsService)
    : AbstractController<Contract, ContractsService>(service), ContractsApi {


    override fun contractsCreateContract(
			@RequestBody contract: Contract): ResponseEntity<Contract> {
        return super.create(contract)
    }

    override fun contractsDeleteContract(
			@PathVariable("contractId") contractId: String): ResponseEntity<Contract> {
        return super.delete(contractId)
    }

    override fun contractsGetContract(
			@PathVariable("contractId") contractId: String): ResponseEntity<Contract> {
        return super.getById(contractId)
    }

    override fun contractsGetContractList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Contract>> {
        return getAll(search, page)
    }

    override fun contractsModifyContract(
			@PathVariable("contractId") contractId: String,
			@RequestBody contract: Contract): ResponseEntity<Contract> {
        return super.modify(contractId, contract)
    }

    override fun contractsUpdateContract(
			@PathVariable("contractId") contractId: String,
			@RequestBody contract: Contract): ResponseEntity<Contract> {
        return super.update(contractId, contract)
    }

}
