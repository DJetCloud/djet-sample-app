package com.client.organization.domain

import com.client.domain.BaseResource
import org.hibernate.annotations.Type
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* https://www.hl7.org/FHIR/organization.html  Organization represents departments party have and hierarchical organization of departments inside party.  A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action. Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.
* @param type Type of application from external information system, Can be used for type of medical organizations.
* @param partOf The organization of which this organization forms a part.
* @param location A of locations organization presented in.
* @param contact Contact for the organization for a certain purpose
* @param legal Legal entity organization operates under.
* @param account Account organization use for settlement.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "type", "partOf", "location", "contact", "legal", "account")

@Entity
@Table(name = "organization")
data class Organization(

	@Type(type = "json")
	@Column(name = "type", columnDefinition = "json")
	var type: List<String>?,

	@Column(name = "part_of")
	var partOf: String?,

	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTable(
			name = "location_to_organization",
			joinColumns = [JoinColumn(name = "organization_id")]
	)
	@Column(name = "location_id")
	var location: List<String>?,

	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTable(
			name = "contact_to_organization",
			joinColumns = [JoinColumn(name = "organization_id")]
	)
	@Column(name = "contact_id")
	var contact: List<String>?,

	@Column(name = "legal")
	var legal: String?,

	@Column(name = "account")
	var account: String?

) : BaseResource()

