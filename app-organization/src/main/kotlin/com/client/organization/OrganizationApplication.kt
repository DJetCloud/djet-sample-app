package com.client.organization

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@SpringBootApplication(scanBasePackages = ["com.client.organization", "com.client.config"])
@EntityScan(value = ["com.client.organization.domain", "com.client.domain"])
class OrganizationApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<OrganizationApplication>(*args)
}
