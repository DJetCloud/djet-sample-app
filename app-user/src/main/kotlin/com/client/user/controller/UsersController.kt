package com.client.user.controller

import com.client.user.domain.User
import com.client.user.service.UsersService
import com.client.user.controller.api.UsersApi
import io.swagger.annotations.ApiParam
import com.client.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class UsersController(service: UsersService)
    : AbstractController<User, UsersService>(service), UsersApi {


    override fun usersCreateUser(
			@RequestBody user: User): ResponseEntity<User> {
        return super.create(user)
    }

    override fun usersDeleteUser(
			@PathVariable("userId") userId: String): ResponseEntity<User> {
        return super.delete(userId)
    }

    override fun usersGetUser(
			@PathVariable("userId") userId: String): ResponseEntity<User> {
        return super.getById(userId)
    }

    override fun usersGetUserList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<User>> {
        return getAll(search, page)
    }

    override fun usersModifyUser(
			@PathVariable("userId") userId: String,
			@RequestBody user: User): ResponseEntity<User> {
        return super.modify(userId, user)
    }

    override fun usersUpdateUser(
			@PathVariable("userId") userId: String,
			@RequestBody user: User): ResponseEntity<User> {
        return super.update(userId, user)
    }

}
