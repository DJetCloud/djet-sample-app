package com.client.user.controller.api

import com.client.user.domain.Location
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

@Api(value = "Locations", tags = ["Locations"], description = "the Locations API")
interface LocationsApi {

    @ApiOperation(value = "CreateLocation", nickname = "locationsCreateLocation", notes = "Create new Location. Validate Location not yet exist.", tags=["Locations"],)
    @ApiResponses(
        ApiResponse(code = 201, message = "Object created successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 401, message = "Object is already exist.")
    )
    @PostMapping("/locations")
    fun locationsCreateLocation(
			@RequestBody location: Location): ResponseEntity<Location> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "DeleteLocation", nickname = "locationsDeleteLocation", notes = "Delete location if it exists", tags=["Locations"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Person is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Object is not found")
    )
    @DeleteMapping("/locations/{locationId}")
    fun locationsDeleteLocation(
			@PathVariable("locationId") locationId: String): ResponseEntity<Location> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetLocation", nickname = "locationsGetLocation", notes = "Get location or list of locations from service.", tags=["Locations"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Person is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Object is not found")
    )
    @GetMapping("/locations/{locationId}")
    fun locationsGetLocation(
			@PathVariable("locationId") locationId: String): ResponseEntity<Location> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "GetLocationList", nickname = "locationsGetLocationList", notes = "Get location or list of locations from service.", tags=["Locations"],)
    @ApiResponses(
        ApiResponse(code = 200, message = "Person is found and returned."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Object is not found")
    )
    @GetMapping("/locations")
    fun locationsGetLocationList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Location>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "ModifyLocation", nickname = "locationsModifyLocation", notes = "Change Location properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["Locations"],)
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object."),
        ApiResponse(code = 404, message = "Object is not found")
    )
    @PatchMapping("/locations/{locationId}")
    fun locationsModifyLocation(
			@PathVariable("locationId") locationId: String,
			@RequestBody location: Location): ResponseEntity<Location> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @ApiOperation(value = "UpdateLocation", nickname = "locationsUpdateLocation", notes = "Change location specification. Location will be created if not exist.", tags=["Locations"])
    @ApiResponses(
        ApiResponse(code = 204, message = "Operation completed successfully."),
        ApiResponse(code = 400, message = "Execution of user request failed."),
        ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
    )
    @PutMapping("/locations/{locationId}")
    fun locationsUpdateLocation(
			@PathVariable("locationId") locationId: String,
			@RequestBody location: Location): ResponseEntity<Location> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}
