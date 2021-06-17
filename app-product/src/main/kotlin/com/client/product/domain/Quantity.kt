package com.client.product.domain

import com.client.domain.BaseDomain
import java.math.BigDecimal
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* A measured amount (or an amount that can potentially be measured).
* @param value Numerical value (with implicit precision)
* @param comparator How to understand the value
* @param unit Unit representation
* @param system System that defines coded unit form
* @param code Coded form of the unit
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("value", "comparator", "unit", "system", "code", "id")

@Entity
@Table(name = "quantity")
data class Quantity(

	@Column(name = "value")
	var value: BigDecimal,

	@Column(name = "comparator")
	var comparator: String?,

	@Column(name = "unit")
	var unit: String?,

	@Column(name = "system_")
	var system: String?,

	@Column(name = "code")
	var code: String?

) : BaseDomain()

