package com.client.product.domain

import com.client.domain.BaseDomain
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Property of object. Property presented as Name/Value pair.
* @param type Type of the property data.
* @param reference Reference to structure for types of structure, field or enum. Reference can be complete and include organization name, system name, application name and dataset name. Reference can be short and contain only dataset name. Version identify structure currently used and if not specified, it means last approved version.
* @param value Property value.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.2.0")

@JsonPropertyOrder("identity", "type", "reference", "value")

@Entity
@Table(name = "property")
data class Property(

	@Column(name = "type")
	var type: String?,

	@Column(name = "reference")
	var reference: String?,

	@Column(name = "value")
	var value: String?

) : BaseDomain()

