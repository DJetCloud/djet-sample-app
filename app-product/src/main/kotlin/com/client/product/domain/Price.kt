package com.client.product.domain

import com.client.domain.BaseDomain
import com.client.product.domain.Amount
import com.client.product.domain.Quantity
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* A amount of money to pay per quantity of service or product..
* @param amount Amount of money to pay.
* @param quantity Quantity of service or product. By default it is one instance.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "amount", "quantity")

@Entity
@Table(name = "price")
data class Price(

	@AttributeOverrides(
		AttributeOverride(name = "amount", column = Column(name = "amount_amount")),
		AttributeOverride(name = "currency", column = Column(name = "amount_currency")),
	)
	@Embedded
	var amount: Amount,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "quantity", referencedColumnName = "id")
	var quantity: Quantity?

) : BaseDomain()

