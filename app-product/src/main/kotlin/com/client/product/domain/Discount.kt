package com.client.product.domain

import com.client.domain.BaseDomain
import com.client.product.domain.Element
import java.math.BigDecimal
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Discount party will provide to product for consumer. Consumer will pay price of the product minus all discounts provided by parties, participating in contract. Discount definy amount of money party will provide to support product consumption by consumer. 
* @param header This header of element with order and period of element activity.
* @param party What party will provide discount for the product. When not specified it is merchant of records who will provide discount to consumer. 
* @param value Value discount in currency of the price. It is amount price will be reduced by.
* @param ratio Percentage of the price to be discounted from the price.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "party", "value", "ratio")

@Entity
@Table(name = "discount")
data class Discount(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "party")
	var party: String?,

	@Column(name = "value")
	var value: BigDecimal?,

	@Column(name = "ratio")
	var ratio: String?

) : BaseDomain()

