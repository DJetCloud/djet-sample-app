package com.client.party.domain

import com.client.domain.BaseResource
import com.client.party.domain.PaymentInstrument
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Account entity for party. Party can have multiple accounts. Account must be associated with LegalEntity under which account will operate. Account maintain financial activities executed by party and support invoicing and billing for party.
* @param type Type of account. It is reference to account type enumerator.
* @param legalEntity Reference to legal entity used for account.
* @param country Country of the account if different from legal entity
* @param accountNumber Human friendly account number to use on invoices. 
* @param paymentInstruments List of payment instruments can be used by account payments. Order of instruments in list defines priority for instruments use.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "type", "legalEntity", "country", "accountNumber", "paymentInstruments")

@Entity
@Table(name = "account")
data class Account(

	@Column(name = "type")
	var type: String,

	@Column(name = "legal_entity")
	var legalEntity: String,

	@Column(name = "country")
	var country: String?,

	@Column(name = "account_number")
	var accountNumber: String?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "account_to_payment_instrument",
			joinColumns = [JoinColumn(name = "account_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "payment_instrument_id", referencedColumnName = "id")]
	)
	var paymentInstruments: List<PaymentInstrument>?

) : BaseResource()

