package com.client.product.domain

import com.client.domain.BaseResource
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Group of products representing product line for organization. Product line define most common product categories and attributes.
* @param type Type of the service. 
* @param owner Legal entity responsible for managing line of products.
* @param account Master account to manage transactions with products from product line.
* @param category Category of product belong to product line. Category defines actual service and resource for product line products. Service will safe resources.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "type", "owner", "account", "category")

@Entity
@Table(name = "product_line")
data class ProductLine(

	@Column(name = "type")
	var type: String?,

	@Column(name = "owner")
	var owner: String?,

	@Column(name = "account")
	var account: String?,

	@Column(name = "category")
	var category: String?

) : BaseResource()

