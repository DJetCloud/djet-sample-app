package com.client.product.controller

import com.client.product.domain.Product
import com.client.product.controller.filter.ProductFilterOnCriticalEstimationPartyIdRankType
import com.client.product.controller.filter.ProductFilterOnPartyIdRank
import com.client.product.controller.filter.ProductFilterOnPartyId
import com.client.product.service.ProductsService
import com.client.product.controller.api.ProductsApi
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
class ProductsController(service: ProductsService)
    : AbstractController<Product, ProductsService>(service), ProductsApi {


    override fun productsCreateProduct(
			@PathVariable("productLineId") productLineId: String,
			@RequestBody product: Product): ResponseEntity<Product> {
		return super.create(productLineId, product)
    }

    override fun productsDeleteProduct(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productId") productId: String): ResponseEntity<Product> {
		return super.delete(productLineId, productId)
    }

    override fun productsGetProduct(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productId") productId: String,
			@ApiParam(value = "for filtering as a sample of Guid" ) @RequestHeader(value = "partyId", required = false) partyId: String?,
			@ApiParam(value = "for filtering as a sample of Enum" ) @RequestHeader(value = "type", required = false) type: String?,
			@ApiParam(value = "for filtering as a sample of boolean" ) @RequestHeader(value = "critical", required = false) critical: Boolean?,
			@ApiParam(value = "for filtering as a sample of Integer" ) @RequestHeader(value = "rank", required = false) rank: Int?,
			@ApiParam(value = "for filtering as a sample of String" ) @RequestHeader(value = "estimation", required = false) estimation: String?): ResponseEntity<Product> {
		val filter = ProductFilterOnCriticalEstimationPartyIdRankType(partyId, type, critical, rank, estimation)
		return super.getById(productLineId, productId, filter)
    }

    override fun productsGetProductList(
			@PathVariable("productLineId") productLineId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@ApiParam(value = "for filtering as a sample of Guid" ) @RequestHeader(value = "partyId", required = false) partyId: String?,
			@ApiParam(value = "for filtering as a sample of Enum" ) @RequestHeader(value = "type", required = false) type: String?,
			@ApiParam(value = "for filtering as a sample of boolean" ) @RequestHeader(value = "critical", required = false) critical: Boolean?,
			@ApiParam(value = "for filtering as a sample of Integer" ) @RequestHeader(value = "rank", required = false) rank: Int?,
			@ApiParam(value = "for filtering as a sample of String" ) @RequestHeader(value = "estimation", required = false) estimation: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Product>> {
		val filter = ProductFilterOnCriticalEstimationPartyIdRankType(partyId, type, critical, rank, estimation)
		return getAll(productLineId, search, page, filter)
    }

    override fun productsModifyProduct(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productId") productId: String,
			@RequestBody product: Product,
			@ApiParam(value = "for filtering as a sample of Guid" ) @RequestHeader(value = "partyId", required = false) partyId: String?,
			@ApiParam(value = "for filtering as a sample of Integer" ) @RequestHeader(value = "rank", required = false) rank: Int?): ResponseEntity<Product> {
		val filter = ProductFilterOnPartyIdRank(partyId, rank)
		return super.modify(productLineId, productId, product, filter)
    }

    override fun productsUpdateProduct(
			@PathVariable("productLineId") productLineId: String,
			@PathVariable("productId") productId: String,
			@RequestBody product: Product,
			@ApiParam(value = "for filtering as a sample of Guid" ) @RequestHeader(value = "partyId", required = false) partyId: String?): ResponseEntity<Product> {
		val filter = ProductFilterOnPartyId(partyId)
		return super.update(productLineId, productId, product, filter)
    }

}
