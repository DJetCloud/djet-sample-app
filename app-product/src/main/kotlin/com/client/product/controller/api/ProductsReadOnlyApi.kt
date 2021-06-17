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

@Api(value = "ProductsReadOnly", tags = ["ProductsReadOnly"], description = "the ProductsReadOnly API")
interface ProductsReadOnlyApi {

    @ApiOperation(value = "GetProduct", nickname = "productsReadOnlyGetProduct", notes = "Get a product or list of products from the service. ", tags=["ProductsReadOnly"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Contact is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/products/{productId}")
    fun productsReadOnlyGetProduct(
			@PathVariable("productId") productId: String): ResponseEntity<Product> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetProductList", nickname = "productsReadOnlyGetProductList", notes = "Get a product or list of products from the service. ", tags=["ProductsReadOnly"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Contact is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Contact is not found")
    )
    @GetMapping("/products")
    fun productsReadOnlyGetProductList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Product>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
