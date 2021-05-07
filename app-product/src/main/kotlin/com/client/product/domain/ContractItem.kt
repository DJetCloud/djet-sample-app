package com.client.product.domain

import com.client.domain.BaseResource
import com.client.product.domain.Discount
import com.client.product.domain.Fee
import com.client.product.domain.Price
import com.client.product.domain.Version
import java.util.Date
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Contract item defines rules of distribution for product based on contract.
* @param version Contract item is versioned and order need to remember what version of contract item was used.
* @param start Contract item version start day. This is time version must be used for orders. 
* @param end Contract item version last day of execution. This is time version must be stop to be used for orders and new version apply. If new version not exist, contract is terminated. When not specified, defined by start of next version.
* @param product Reference to the product, which distribution defined by item.
* @param price Price of product for this contract. When not specified, recommended price from product used.
* @param discounts Discounts provided by different parties for distribution of specific product. Contract item product discounts override discounts of parties specified in contract. Override happens based on parties of discount.
* @param fees Fees collected for transaction execution for specific product. Fees of product override fees specified for party in contract. Override happens based on parties and type of fee.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "version", "entity", "start", "end", "product", "price", "discounts", "fees")

@Entity
@Table(name = "contract_item")
data class ContractItem(

	@AttributeOverrides(
		AttributeOverride(name = "major", column = Column(name = "version_major")),
		AttributeOverride(name = "minor", column = Column(name = "version_minor")),
		AttributeOverride(name = "revision", column = Column(name = "version_revision")),
		AttributeOverride(name = "label", column = Column(name = "version_label")),
	)
	@Embedded
	var version: Version,

	@Column(name = "start")
	var start: Date,

	@Column(name = "end")
	var end: Date?,

	@Column(name = "product")
	var product: String,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "price", referencedColumnName = "id")
	var price: Price,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "contract_item_to_discount",
			joinColumns = [JoinColumn(name = "contract_item_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "discount_id", referencedColumnName = "id")]
	)
	var discounts: List<Discount>?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "contract_item_to_fee",
			joinColumns = [JoinColumn(name = "contract_item_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "fee_id", referencedColumnName = "id")]
	)
	var fees: List<Fee>?

) : BaseResource()

