package com.client.product.service

import com.client.product.domain.ContractItem
import com.client.product.repository.ContractItemsRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class ContractItemsService(
    repository: ContractItemsRepository
) : AbstractService<ContractItem, ContractItemsRepository>(repository)
