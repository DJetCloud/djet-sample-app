package com.client.product.controller

import com.client.product.domain.Product
import com.client.product.service.ProductsReadOnlyService
import com.client.product.controller.api.ProductsReadOnlyApi
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
class ProductsReadOnlyController(service: ProductsReadOnlyService)
    : AbstractController<Product, ProductsReadOnlyService>(service), ProductsReadOnlyApi {


    override fun productsReadOnlyGetProduct(
			@PathVariable("productId") productId: String): ResponseEntity<Product> {
		return super.getById(productId)
    }

    override fun productsReadOnlyGetProductList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Product>> {
		return getAll(search, page)
    }

}
