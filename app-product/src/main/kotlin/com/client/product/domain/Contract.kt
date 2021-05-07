package com.client.product.domain

import com.client.domain.BaseResource
import com.client.product.domain.ContractParty
import com.client.product.domain.Discount
import com.client.product.domain.Fee
import com.client.product.domain.Version
import java.util.Date
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Legal contract to supply or distribute products.
* @param version Contract is versioned and order need to remember what version of contract was used.
* @param type Type of the contract defines who participate in the contract.
* @param parties List of parties participating in contract.
* @param merchant Merchant of records id from parties list. Merchant of records is a party to collect payment from consumer and distribute it based on fees calculated for transaction. 
* @param start Contract version start day. This is time version must be used for orders. 
* @param end Contract version last day of execution. This is time version must be stop to be used for orders and new version apply. If new version not exist, contract is terminated. When not specified, defined by start of next version.
* @param products Product lines contract apply too. When product item don't in contract, product line used to determine all products covered by contract. If not specified, contract cover only products specified in contract items.
* @param currency Currency used for product price and fees calculation for contract by default.
* @param discounts Discount provided by parties to consumer. This discounts will be provided to consumer and extracted from distribution of the party. In contract if defines discount to all items. Item can override contract discount.
* @param fees Fees need to be payed by different parties as result of transaction execution. 
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "version", "entity", "type", "parties", "merchant", "start", "end", "products", "currency", "discounts", "fees")

@Entity
@Table(name = "contract")
data class Contract(

	@AttributeOverrides(
		AttributeOverride(name = "major", column = Column(name = "version_major")),
		AttributeOverride(name = "minor", column = Column(name = "version_minor")),
		AttributeOverride(name = "revision", column = Column(name = "version_revision")),
		AttributeOverride(name = "label", column = Column(name = "version_label")),
	)
	@Embedded
	var version: Version,

	@Column(name = "type")
	var type: String?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "contract_to_contract_party",
			joinColumns = [JoinColumn(name = "contract_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "contract_party_id", referencedColumnName = "id")]
	)
	var parties: List<ContractParty>?,

	@Column(name = "merchant")
	var merchant: String,

	@Column(name = "start")
	var start: Date,

	@Column(name = "end")
	var end: Date?,

	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTable(
			name = "contract_to_product_line",
			joinColumns = [JoinColumn(name = "contract_id")]
	)
	@Column(name = "product_line_id")
	var products: List<String>?,

	@Column(name = "currency")
	var currency: String,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "contract_to_discount",
			joinColumns = [JoinColumn(name = "contract_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "discount_id", referencedColumnName = "id")]
	)
	var discounts: List<Discount>?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "contract_to_fee",
			joinColumns = [JoinColumn(name = "contract_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "fee_id", referencedColumnName = "id")]
	)
	var fees: List<Fee>?

) : BaseResource()

