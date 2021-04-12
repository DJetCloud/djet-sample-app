package com.client.party.domain

import com.client.domain.BaseResource
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Party represents all participants of the Medical Network. Party have multiple types and base on type provide or consume different services across Network.
* @param type Type of the Party. Client can be Person, Clinic or Provider.
* @param region Main operational region (AWS) for client to make it align with systems in this region for compliance or performance. 
* @param partyCode Party code used to identify party in human friendly documents..
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "type", "region", "partyCode")

@Entity
@Table(name = "party")
data class Party(

	@Column(name = "type")
	var type: String?,

	@Column(name = "region")
	var region: String?,

	@Column(name = "party_code")
	var partyCode: String?

) : BaseResource()

