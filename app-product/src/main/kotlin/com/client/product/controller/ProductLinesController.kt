package com.client.product.controller

import com.client.product.domain.ProductLine
import com.client.product.service.ProductLinesService
import com.client.product.controller.api.ProductLinesApi
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
class ProductLinesController(service: ProductLinesService)
    : AbstractController<ProductLine, ProductLinesService>(service), ProductLinesApi {


    override fun productLinesCreateProductLine(
			@PathVariable("partyId") partyId: String,
			@RequestBody productLine: ProductLine): ResponseEntity<ProductLine> {
        return super.create(partyId, productLine)
    }

    override fun productLinesDeleteProductLine(
			@PathVariable("partyId") partyId: String,
			@PathVariable("productLineId") productLineId: String): ResponseEntity<ProductLine> {
        return super.delete(partyId, productLineId)
    }

    override fun productLinesGetProductLine(
			@PathVariable("partyId") partyId: String,
			@PathVariable("productLineId") productLineId: String): ResponseEntity<ProductLine> {
        return super.getById(partyId, productLineId)
    }

    override fun productLinesGetProductLineList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<ProductLine>> {
        return getAll(partyId, search, page)
    }

    override fun productLinesModifyProductLine(
			@PathVariable("partyId") partyId: String,
			@PathVariable("productLineId") productLineId: String,
			@RequestBody productLine: ProductLine): ResponseEntity<ProductLine> {
        return super.modify(partyId, productLineId, productLine)
    }

    override fun productLinesUpdateProductLine(
			@PathVariable("partyId") partyId: String,
			@PathVariable("productLineId") productLineId: String,
			@RequestBody productLine: ProductLine): ResponseEntity<ProductLine> {
        return super.update(partyId, productLineId, productLine)
    }

}
