package com.client.user.service

import com.client.user.domain.User
import com.client.user.repository.UsersRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class UsersService(
    repository: UsersRepository
) : AbstractService<User, UsersRepository>(repository)
