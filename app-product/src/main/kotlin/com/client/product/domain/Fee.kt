package com.client.product.domain

import com.client.domain.BaseDomain
import com.client.domain.Element
import java.math.BigDecimal
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Fee party will pay to other parties as result of contract execution. Network calculates portion of transaction for every party in the contract. 
* @param header This header of element with order and period of element activity.
* @param payParty What party will pay fees as result of transaction execution. When not specified it is merchant of records.
* @param receiveParty Party to receive fee payment. This is id from parties list. This parameter required to understand what party will receive the fee.
* @param value Value discount in currency of the price. It is amount price will be reduced by.
* @param ratio Percentage of the price to be discounted from the price.
* @param base This is base to calculate the fees. When base not specified price of service or product play role of the base. When base specified, id of fees calculated on previous step used as base. 
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "payParty", "receiveParty", "value", "ratio", "base")

@Entity
@Table(name = "fee")
data class Fee(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "pay_party")
	var payParty: String?,

	@Column(name = "receive_party")
	var receiveParty: String,

	@Column(name = "value")
	var value: BigDecimal?,

	@Column(name = "ratio")
	var ratio: String?,

	@Column(name = "base")
	var base: String?

) : BaseDomain()

