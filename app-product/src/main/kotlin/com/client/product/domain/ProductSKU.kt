package com.client.product.domain

import com.client.domain.BaseDomain
import java.util.Date
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Unit specification of the product. Product can be presented by many units with different characteristics like size, color and so on. SKU defines characteristics and parent product it extends. 
* @param barCode Bar code used for SKU.
* @param product Product SKU is for. When product not specified it is primary SKU of product. 
* @param properties Properties of the SKU. This is properties differentiate current SKU from other SKU of the product. 
* @param start Product SKU availability start day. This is time SKU can be used for orders. 
* @param end Product SKU availability end day. This is time SKU can not be used for orders any more.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "barCode", "product", "properties", "start", "end")

@Entity
@Table(name = "product_s_k_u")
data class ProductSKU(

	@Column(name = "bar_code")
	var barCode: String?,

	@Column(name = "product")
	var product: String?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "product_sku_to_property",
			joinColumns = [JoinColumn(name = "product_sku_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "property_id", referencedColumnName = "id")]
	)
	var properties: List<Property>?,

	@Column(name = "start")
	var start: Date,

	@Column(name = "end")
	var end: Date

) : BaseDomain()

