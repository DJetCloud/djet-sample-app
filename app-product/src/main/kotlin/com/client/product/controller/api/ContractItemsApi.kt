package com.client.product.controller.api

import com.client.product.domain.ContractItem
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

@Api(value = "ContractItems", tags = ["ContractItems"], description = "the ContractItems API")
interface ContractItemsApi {

    @ApiOperation(value = "CreateContractItem", nickname = "contractItemsCreateContractItem", notes = "Create a new ContractItem. Validate ContractItem not yet exist.", tags=["ContractItems"])
    @ApiResponses(
        ApiResponse(code = 201, message = "Object created successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 401, message = "Contact is already exist.")
    )
    @PostMapping("/contracts/{contractId}/contractitems")
    fun contractItemsCreateContractItem(
			@PathVariable("contractId") contractId: String,
			@RequestBody contractItem: ContractItem): ResponseEntity<ContractItem> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "DeleteContractItem", nickname = "contractItemsDeleteContractItem", notes = "Soft delete of the contractItem by id.", tags=["ContractItems"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @DeleteMapping("/contracts/{contractId}/contractitems/{contractItemId}")
    fun contractItemsDeleteContractItem(
			@PathVariable("contractId") contractId: String,
			@PathVariable("contractItemId") contractItemId: String): ResponseEntity<ContractItem> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetContractItem", nickname = "contractItemsGetContractItem", notes = "Get a contractItem or list of contractItems from the service. ", tags=["ContractItems"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Contact is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/contracts/{contractId}/contractitems/{contractItemId}")
    fun contractItemsGetContractItem(
			@PathVariable("contractId") contractId: String,
			@PathVariable("contractItemId") contractItemId: String): ResponseEntity<ContractItem> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetContractItemList", nickname = "contractItemsGetContractItemList", notes = "Get a contractItem or list of contractItems from the service. ", tags=["ContractItems"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Contact is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/contracts/{contractId}/contractitems")
    fun contractItemsGetContractItemList(
			@PathVariable("contractId") contractId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<ContractItem>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyContractItem", nickname = "contractItemsModifyContractItem", notes = "Change ContractItem properties to values specified in the request. Property not specified will remain the same. No element of any collection will be deleted.", tags=["ContractItems"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @PatchMapping("/contracts/{contractId}/contractitems/{contractItemId}")
    fun contractItemsModifyContractItem(
			@PathVariable("contractId") contractId: String,
			@PathVariable("contractItemId") contractItemId: String,
			@RequestBody contractItem: ContractItem): ResponseEntity<ContractItem> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateContractItem", nickname = "contractItemsUpdateContractItem", notes = "Change the contractItem specification.", tags=["ContractItems"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @PutMapping("/contracts/{contractId}/contractitems/{contractItemId}")
    fun contractItemsUpdateContractItem(
			@PathVariable("contractId") contractId: String,
			@PathVariable("contractItemId") contractItemId: String,
			@RequestBody contractItem: ContractItem): ResponseEntity<ContractItem> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
