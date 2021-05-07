package com.client.product.service

import com.client.product.domain.Contract
import com.client.product.repository.ContractsRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class ContractsService(
    repository: ContractsRepository
) : AbstractService<Contract, ContractsRepository>(repository)
