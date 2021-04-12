package com.client.user

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@SpringBootApplication(scanBasePackages = ["com.client.user", "com.client.config"])
@EntityScan(value = ["com.client.user.domain", "com.client.domain"])
class UserApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<UserApplication>(*args)
}
