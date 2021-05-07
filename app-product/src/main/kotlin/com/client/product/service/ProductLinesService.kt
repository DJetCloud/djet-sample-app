package com.client.product.service

import com.client.product.domain.ProductLine
import com.client.product.repository.ProductLinesRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class ProductLinesService(
    repository: ProductLinesRepository
) : AbstractService<ProductLine, ProductLinesRepository>(repository)
