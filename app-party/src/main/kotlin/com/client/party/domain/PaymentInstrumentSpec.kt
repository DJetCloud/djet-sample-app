package com.client.party.domain

import com.client.party.domain.BankSpec
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Payment specification for all supported payment types.
* @param bank Specification for bank account as payment instrument.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("bank")

@Embeddable
data class PaymentInstrumentSpec(

	@AttributeOverrides(
		AttributeOverride(name = "accountNumber", column = Column(name = "bank_account_number")),
		AttributeOverride(name = "routingNumber", column = Column(name = "bank_routing_number")),
	)
	@Embedded
	var bank: BankSpec?

) 

