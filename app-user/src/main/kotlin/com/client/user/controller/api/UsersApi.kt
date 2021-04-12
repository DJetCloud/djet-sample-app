package com.client.user.controller.api

import com.client.user.domain.User
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Api(value = "Users", tags = ["Users"], description = "the Users API")
interface UsersApi {

    @ApiOperation(value = "CreateUser", nickname = "usersCreateUser", notes = "Create new User. Validate User not yet exist.", tags=["Users"],)
    @ApiResponses(
        ApiResponse(code = 201, message = "Object created successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 401, message = "User is already exist.")
    )
    @PostMapping("/users")
    fun usersCreateUser(
			@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetUser", nickname = "usersGetUser", notes = "Get user or list of users from service.", tags=["Users"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "User is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "User is not found")
    )
    @GetMapping("/users/{userId}")
    fun usersGetUser(
			@PathVariable("userId") userId: String): ResponseEntity<User> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetUserList", nickname = "usersGetUserList", notes = "Get user or list of users from service.", tags=["Users"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "User is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "User is not found")
    )
    @GetMapping("/users")
    fun usersGetUserList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<User>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyUser", nickname = "usersModifyUser", notes = "Change User properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["Users"],)
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "User is not found")
    )
    @PatchMapping("/users/{userId}")
    fun usersModifyUser(
			@PathVariable("userId") userId: String,
			@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateUser", nickname = "usersUpdateUser", notes = "Change user specification. User will be created if not exist.", tags=["Users"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
    )
    @PutMapping("/users/{userId}")
    fun usersUpdateUser(
			@PathVariable("userId") userId: String,
			@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
