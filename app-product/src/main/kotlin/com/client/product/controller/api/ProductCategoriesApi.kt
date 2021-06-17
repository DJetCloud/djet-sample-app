package com.client.product.controller.api

import com.client.product.domain.ProductCategory
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

@Api(value = "ProductCategories", tags = ["ProductCategories"], description = "the ProductCategories API")
interface ProductCategoriesApi {

    @ApiOperation(value = "CreateProductCategory", nickname = "productCategoriesCreateProductCategory", notes = "Create a new Product Category. Validate Product Category not yet exist.", tags=["ProductCategories"])
    @ApiResponses(
        ApiResponse(code = 201, message = "Object created successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 401, message = "Product category is already exist.")
    )
    @PostMapping("/productlines/{productLineId}/productcategories")
    fun productCategoriesCreateProductCategory(
			@PathVariable("productLineId") productLineId: String,
			@RequestBody productCategory: ProductCategory): ResponseEntity<ProductCategory> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "DeleteProductCategory", nickname = "productCategoriesDeleteProductCategory", notes = "Soft delete of the product category by id.", tags=["ProductCategories"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Product category is not found")
    )
    @DeleteMapping("/productlines/{productLineId}/productcategories/{productCategoryId}")
    fun productCategoriesDeleteProductCategory(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productCategoryId") productCategoryId: String): ResponseEntity<ProductCategory> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetProductCategory", nickname = "productCategoriesGetProductCategory", notes = "Get a product categpry or list of products categories from the service. ", tags=["ProductCategories"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Product category is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Product category is not found")
    )
    @GetMapping("/productlines/{productLineId}/productcategories/{productCategoryId}")
    fun productCategoriesGetProductCategory(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productCategoryId") productCategoryId: String): ResponseEntity<ProductCategory> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetProductCategoryList", nickname = "productCategoriesGetProductCategoryList", notes = "Get a product categpry or list of products categories from the service. ", tags=["ProductCategories"])
    @ApiResponses(
        ApiResponse(code = 200, message = "Product category is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Product category is not found")
    )
    @GetMapping("/productlines/{productLineId}/productcategories")
    fun productCategoriesGetProductCategoryList(
			@PathVariable("productLineId") productLineId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<ProductCategory>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyProductCategory", nickname = "productCategoriesModifyProductCategory", notes = "Change Product Category properties to values specified in the request. Property not specified will remain the same. No element of any collection will be deleted.", tags=["ProductCategories"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Product category is not found")
    )
    @PatchMapping("/productlines/{productLineId}/productcategories/{productCategoryId}")
    fun productCategoriesModifyProductCategory(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productCategoryId") productCategoryId: String,
			@RequestBody productCategory: ProductCategory): ResponseEntity<ProductCategory> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateProductCategory", nickname = "productCategoriesUpdateProductCategory", notes = "Change the product category specification.", tags=["ProductCategories"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 404, message = "Product category is not found")
    )
    @PutMapping("/productlines/{productLineId}/productcategories/{productCategoryId}")
    fun productCategoriesUpdateProductCategory(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productCategoryId") productCategoryId: String,
			@RequestBody productCategory: ProductCategory): ResponseEntity<ProductCategory> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
