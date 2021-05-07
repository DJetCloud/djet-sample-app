package com.client.product.service

import com.client.product.domain.ProductCategory
import com.client.product.repository.ProductCategoriesRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class ProductCategoriesService(
    repository: ProductCategoriesRepository
) : AbstractService<ProductCategory, ProductCategoriesRepository>(repository)
