package com.client.user.domain

import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* The absolute geographic location.
* @param longitude Longitude with WGS84 datum
* @param altitude Latitude with WGS84 datum
* @param latitude Altitude with WGS84 datum
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("longitude", "altitude", "latitude")

@Embeddable
data class Position(

	@Column(name = "longitude")
	var longitude: String?,

	@Column(name = "altitude")
	var altitude: String?,

	@Column(name = "latitude")
	var latitude: String?

) 

