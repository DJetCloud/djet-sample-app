package com.client.product.controller.api

import com.client.product.domain.ProductLine
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

@Api(value = "ProductLines", tags = ["ProductLines"], description = "the ProductLines API")
interface ProductLinesApi {

    @ApiOperation(value = "CreateProductLine", nickname = "productLinesCreateProductLine", notes = "Create a new ProductLine. Validate ProductLine not yet exist.", tags=["ProductLines"])
    @ApiResponses(
        ApiResponse(code = 201, message = "Object created successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 401, message = "Contact is already exist.")
    )
    @PostMapping("/parties/{partyId}/productlines")
    fun productLinesCreateProductLine(
			@PathVariable("partyId") partyId: String,
			@RequestBody productLine: ProductLine): ResponseEntity<ProductLine> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "DeleteProductLine", nickname = "productLinesDeleteProductLine", notes = "Soft delete of the productLine by id.", tags=["ProductLines"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @DeleteMapping("/parties/{partyId}/productlines/{productLineId}")
    fun productLinesDeleteProductLine(
			@PathVariable("partyId") partyId: String,
			@PathVariable("productLineId") productLineId: String): ResponseEntity<ProductLine> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetProductLine", nickname = "productLinesGetProductLine", notes = "Get a productLine or list of productLines from the service. ", tags=["ProductLines"])
    @ApiResponses(
        ApiResponse(code = 200, message = "ProductLine is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/parties/{partyId}/productlines/{productLineId}")
    fun productLinesGetProductLine(
			@PathVariable("partyId") partyId: String,
			@PathVariable("productLineId") productLineId: String): ResponseEntity<ProductLine> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetProductLineList", nickname = "productLinesGetProductLineList", notes = "Get a productLine or list of productLines from the service. ", tags=["ProductLines"])
    @ApiResponses(
        ApiResponse(code = 200, message = "ProductLine is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/parties/{partyId}/productlines")
    fun productLinesGetProductLineList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<ProductLine>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyProductLine", nickname = "productLinesModifyProductLine", notes = "Change ProductLine properties to values specified in the request. Property not specified will remain the same. No element of any collection will be deleted.", tags=["ProductLines"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @PatchMapping("/parties/{partyId}/productlines/{productLineId}")
    fun productLinesModifyProductLine(
			@PathVariable("partyId") partyId: String,
			@PathVariable("productLineId") productLineId: String,
			@RequestBody productLine: ProductLine): ResponseEntity<ProductLine> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateProductLine", nickname = "productLinesUpdateProductLine", notes = "Change the producLine specification.", tags=["ProductLines"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @PutMapping("/parties/{partyId}/productlines/{productLineId}")
    fun productLinesUpdateProductLine(
			@PathVariable("partyId") partyId: String,
			@PathVariable("productLineId") productLineId: String,
			@RequestBody productLine: ProductLine): ResponseEntity<ProductLine> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
