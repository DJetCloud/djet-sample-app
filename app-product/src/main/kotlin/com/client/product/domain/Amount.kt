package com.client.product.domain

import java.math.BigDecimal
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* A amount of money. Money meagered by sum of currency.
* @param amount Amount of money
* @param currency Currency to represent amount of money. 
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("amount", "currency")

@Embeddable
data class Amount(

	@Column(name = "amount")
	var amount: BigDecimal,

	@Column(name = "currency")
	var currency: String?

) 

