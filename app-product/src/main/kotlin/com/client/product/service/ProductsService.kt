package com.client.product.service

import com.client.product.domain.Product
import com.client.product.repository.ProductsRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class ProductsService(
    repository: ProductsRepository
) : AbstractService<Product, ProductsRepository>(repository)
