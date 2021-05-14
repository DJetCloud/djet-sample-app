package com.client.product.controller.api

import com.client.product.domain.Product
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

@Api(value = "Products", tags = ["Products"], description = "the Products API")
interface ProductsApi {

    @ApiOperation(value = "CreateProduct", nickname = "productsCreateProduct", notes = "Create a new Product. Validate Product not yet exist.", tags=["Products"],)
    @ApiResponses(
        ApiResponse(code = 201, message = "Object created successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 401, message = "Contact is already exist.")
    )
    @PostMapping("/productlines/{productLineId}/products")
    fun productsCreateProduct(
			@PathVariable("productLineId") productLineId: String,
			@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "DeleteProduct", nickname = "productsDeleteProduct", notes = "Soft delete of the product by id.", tags=["Products"],)
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @DeleteMapping("/productlines/{productLineId}/products/{productId}")
    fun productsDeleteProduct(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productId") productId: String): ResponseEntity<Product> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetProduct", nickname = "productsGetProduct", notes = "Get a product or list of products from the service. ", tags=["Products"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Contact is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/productlines/{productLineId}/products/{productId}")
    fun productsGetProduct(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productId") productId: String,
			@ApiParam(value = "for filtering as a sample of Guid" ) @RequestHeader(value = "partyId", required = false) partyId: String?,
			@ApiParam(value = "for filtering as a sample of Enum" ) @RequestHeader(value = "type", required = false) type: String?,
			@ApiParam(value = "for filtering as a sample of boolean" ) @RequestHeader(value = "critical", required = false) critical: Boolean?,
			@ApiParam(value = "for filtering as a sample of Integer" ) @RequestHeader(value = "rank", required = false) rank: Int?,
			@ApiParam(value = "for filtering as a sample of String" ) @RequestHeader(value = "estimation", required = false) estimation: String?): ResponseEntity<Product> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetProductList", nickname = "productsGetProductList", notes = "Get a product or list of products from the service. ", tags=["Products"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Contact is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/productlines/{productLineId}/products")
    fun productsGetProductList(
			@PathVariable("productLineId") productLineId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@ApiParam(value = "for filtering as a sample of Guid" ) @RequestHeader(value = "partyId", required = false) partyId: String?,
			@ApiParam(value = "for filtering as a sample of Enum" ) @RequestHeader(value = "type", required = false) type: String?,
			@ApiParam(value = "for filtering as a sample of boolean" ) @RequestHeader(value = "critical", required = false) critical: Boolean?,
			@ApiParam(value = "for filtering as a sample of Integer" ) @RequestHeader(value = "rank", required = false) rank: Int?,
			@ApiParam(value = "for filtering as a sample of String" ) @RequestHeader(value = "estimation", required = false) estimation: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Product>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyProduct", nickname = "productsModifyProduct", notes = "Change Product properties to values specified in the request. Property not specified will remain the same. No element of any collection will be deleted.", tags=["Products"],)
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @PatchMapping("/productlines/{productLineId}/products/{productId}")
    fun productsModifyProduct(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productId") productId: String,
			@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateProduct", nickname = "productsUpdateProduct", notes = "Change the product specification.", tags=["Products"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @PutMapping("/productlines/{productLineId}/products/{productId}")
    fun productsUpdateProduct(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productId") productId: String,
			@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
