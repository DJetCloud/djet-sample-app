package com.client.user.service

import com.client.user.domain.Location
import com.client.user.repository.LocationsRepository
import com.client.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class LocationsService(
    repository: LocationsRepository
) : AbstractService<Location, LocationsRepository>(repository)
