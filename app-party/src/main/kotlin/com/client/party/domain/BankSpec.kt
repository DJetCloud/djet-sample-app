package com.client.party.domain

import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Specification for bank account transfer.
* @param accountNumber Account number of bank customer. 
* @param routingNumber Routing number to institution.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("accountNumber", "routingNumber")

@Embeddable
data class BankSpec(

	@Column(name = "account_number")
	var accountNumber: String,

	@Column(name = "routing_number")
	var routingNumber: String

) 

