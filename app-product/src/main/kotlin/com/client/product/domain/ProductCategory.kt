package com.client.product.domain

import com.client.domain.BaseResource
import com.client.domain.Element
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Service activity. Activity represents actual parts of service and include all operations need be provided to patient.
* @param header This header of element with order and period of element activity.
* @param category Category of products from for the product line. This category defines what resorce to use for actual goods or services specification.
* @param definition Definition of the category
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "header", "category", "definition")

@Entity
@Table(name = "product_category")
data class ProductCategory(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "category")
	var category: String?,

	@Column(name = "definition")
	var definition: String?

) : BaseResource()

