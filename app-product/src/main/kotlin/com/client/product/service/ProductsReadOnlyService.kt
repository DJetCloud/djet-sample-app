package com.client.product.service

import com.client.product.domain.Product
import com.client.product.repository.ProductsReadOnlyRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class ProductsReadOnlyService(
    repository: ProductsReadOnlyRepository
) : AbstractService<Product, ProductsReadOnlyRepository>(repository)
