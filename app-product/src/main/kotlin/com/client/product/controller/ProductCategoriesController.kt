package com.client.product.controller

import com.client.product.domain.ProductCategory
import com.client.product.service.ProductCategoriesService
import com.client.product.controller.api.ProductCategoriesApi
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
class ProductCategoriesController(service: ProductCategoriesService)
    : AbstractController<ProductCategory, ProductCategoriesService>(service), ProductCategoriesApi {


    override fun productCategoriesCreateProductCategory(
			@PathVariable("productLineId") productLineId: String,
			@RequestBody productCategory: ProductCategory): ResponseEntity<ProductCategory> {
		return super.create(productLineId, productCategory)
    }

    override fun productCategoriesDeleteProductCategory(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productCategoryId") productCategoryId: String): ResponseEntity<ProductCategory> {
		return super.delete(productLineId, productCategoryId)
    }

    override fun productCategoriesGetProductCategory(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productCategoryId") productCategoryId: String): ResponseEntity<ProductCategory> {
		return super.getById(productLineId, productCategoryId)
    }

    override fun productCategoriesGetProductCategoryList(
			@PathVariable("productLineId") productLineId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<ProductCategory>> {
		return getAll(productLineId, search, page)
    }

    override fun productCategoriesModifyProductCategory(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productCategoryId") productCategoryId: String,
			@RequestBody productCategory: ProductCategory): ResponseEntity<ProductCategory> {
		return super.modify(productLineId, productCategoryId, productCategory)
    }

    override fun productCategoriesUpdateProductCategory(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productCategoryId") productCategoryId: String,
			@RequestBody productCategory: ProductCategory): ResponseEntity<ProductCategory> {
		return super.update(productLineId, productCategoryId, productCategory)
    }

}
