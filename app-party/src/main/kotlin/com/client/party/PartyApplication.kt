package com.client.party

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@SpringBootApplication(scanBasePackages = ["com.client.party", "com.client.config"])
@EntityScan(value = ["com.client.party.domain", "com.client.domain"])
class PartyApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<PartyApplication>(*args)
}
