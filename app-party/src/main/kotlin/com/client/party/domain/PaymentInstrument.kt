package com.client.party.domain

import com.client.domain.BaseDomain
import com.client.domain.Element
import com.client.party.domain.PaymentInstrumentSpec
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Payment instrument to use for payment from eccount.
* @param header This header of element with order and period of element activity.
* @param type Type of financial instrument used for account payments.
* @param spec Specification of payment instrument for specified type.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "type", "spec")

@Entity
@Table(name = "payment_instrument")
data class PaymentInstrument(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "type")
	var type: String?,

	@AttributeOverrides(
		AttributeOverride(name = "bank.accountNumber", column = Column(name = "spec_bank_account_number")),
		AttributeOverride(name = "bank.routingNumber", column = Column(name = "spec_bank_routing_number")),
	)
	@Embedded
	var spec: PaymentInstrumentSpec?

) : BaseDomain()

