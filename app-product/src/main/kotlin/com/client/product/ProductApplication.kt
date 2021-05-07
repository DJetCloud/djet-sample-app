package com.client.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@SpringBootApplication(scanBasePackages = ["com.client.product", "com.client.config"])
@EntityScan(value = ["com.client.product.domain", "com.client.domain"])
class ProductApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<ProductApplication>(*args)
}
