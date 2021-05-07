package com.client.product.domain

import com.client.domain.BaseDomain
import com.client.product.domain.Discount
import com.client.product.domain.Element
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Reference to product related to current product. It can have additional properties to define specific product settings.
* @param header This header of element with order and period of element activity.
* @param product Reference to actual product.
* @param properties List of additional properties associated with the product.
* @param discount Discount for this product when it included in list.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "product", "properties", "discount")

@Entity
@Table(name = "product_ref")
data class ProductRef(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "product")
	var product: String,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "properties", referencedColumnName = "id")
	var properties: Property?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "discount", referencedColumnName = "id")
	var discount: Discount?

) : BaseDomain()

