package com.client.controller

import com.client.domain.BaseResource
import org.springframework.data.jpa.domain.Specification

interface CommonFilter<E : BaseResource> {
	fun toSpecification() : Specification<E>
	fun getQuery() : String
}
