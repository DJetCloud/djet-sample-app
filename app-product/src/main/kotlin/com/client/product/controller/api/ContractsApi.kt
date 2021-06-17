package com.client.product.controller.api

import com.client.product.domain.Contract
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

@Api(value = "Contracts", tags = ["Contracts"], description = "the Contracts API")
interface ContractsApi {

    @ApiOperation(value = "CreateContract", nickname = "contractsCreateContract", notes = "Create a new Contract. Validate Contract not yet exist.", tags=["Contracts"])
    @ApiResponses(
        ApiResponse(code = 201, message = "Object created successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 401, message = "Contact is already exist.")
    )
    @PostMapping("/contracts")
    fun contractsCreateContract(
			@RequestBody contract: Contract): ResponseEntity<Contract> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "DeleteContract", nickname = "contractsDeleteContract", notes = "Soft delete of the contract by id.", tags=["Contracts"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @DeleteMapping("/contracts/{contractId}")
    fun contractsDeleteContract(
			@PathVariable("contractId") contractId: String): ResponseEntity<Contract> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetContract", nickname = "contractsGetContract", notes = "Get a contract or list of contracts from the service. ", tags=["Contracts"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Contact is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/contracts/{contractId}")
    fun contractsGetContract(
			@PathVariable("contractId") contractId: String): ResponseEntity<Contract> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetContractList", nickname = "contractsGetContractList", notes = "Get a contract or list of contracts from the service. ", tags=["Contracts"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Contact is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/contracts")
    fun contractsGetContractList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Contract>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyContract", nickname = "contractsModifyContract", notes = "Change Contract properties to values specified in the request. Property not specified will remain the same. No element of any collection will be deleted.", tags=["Contracts"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @PatchMapping("/contracts/{contractId}")
    fun contractsModifyContract(
			@PathVariable("contractId") contractId: String,
			@RequestBody contract: Contract): ResponseEntity<Contract> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateContract", nickname = "contractsUpdateContract", notes = "Change the contract specification.", tags=["Contracts"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @PutMapping("/contracts/{contractId}")
    fun contractsUpdateContract(
			@PathVariable("contractId") contractId: String,
			@RequestBody contract: Contract): ResponseEntity<Contract> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
