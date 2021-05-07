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
			@RequestBody productLine: ProductLine,
			@ApiParam(value = "for filtering" ) @RequestHeader(value="partyId", required=false) partyId: String?): ResponseEntity<ProductLine> {
        return super.create(productLine)
    }

    override fun productLinesDeleteProductLine(
			@PathVariable("productLineId") productLineId: String,
			@ApiParam(value = "for filtering" ) @RequestHeader(value="partyId", required=false) partyId: String?): ResponseEntity<ProductLine> {
        return super.delete(productLineId)
    }

    override fun productLinesGetProductLine(
			@PathVariable("productLineId") productLineId: String,
			@ApiParam(value = "for filtering" ) @RequestHeader(value="partyId", required=false) partyId: String?): ResponseEntity<ProductLine> {
        return super.getById(productLineId)
    }

    override fun productLinesGetProductLineList(
			@ApiParam(value = "for filtering" ) @RequestHeader(value="partyId", required=false) partyId: String?,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<ProductLine>> {
        return getAll(search, page)
    }

    override fun productLinesModifyProductLine(
			@PathVariable("productLineId") productLineId: String,
			@RequestBody productLine: ProductLine,
			@ApiParam(value = "for filtering" ) @RequestHeader(value="partyId", required=false) partyId: String?): ResponseEntity<ProductLine> {
        return super.modify(productLineId, productLine)
    }

    override fun productLinesUpdateProductLine(
			@PathVariable("productLineId") productLineId: String,
			@RequestBody productLine: ProductLine,
			@ApiParam(value = "for filtering" ) @RequestHeader(value="partyId", required=false) partyId: String?): ResponseEntity<ProductLine> {
        return super.update(productLineId, productLine)
    }

}
