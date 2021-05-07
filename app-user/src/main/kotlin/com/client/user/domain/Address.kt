package com.client.user.domain

import com.client.domain.BaseDomain
import com.client.user.domain.Element
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* An address expressed using postal conventions (as opposed to GPS or other location definition formats). This data type may be used to convey addresses for use in delivering mail as well as for visiting locations which might not be valid for mail delivery. There are a variety of postal address formats defined around the world.  http://build.fhir.org//datatypes.html#Address 
* @param header This header of element with id and period of element activity.
* @param use What address use for.
* @param type Type of address.
* @param text Text representation of the address
* @param district District name (aka county)
* @param state Address state. Sub-unit of country (abbreviations ok)
* @param postalCode Postal code for area
* @param country Country (e.g. can be ISO 3166 2 or 3 letter code)
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "use", "type", "text", "district", "state", "postalCode", "country")

@Entity
@Table(name = "address")
data class Address(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "use_")
	var use: String?,

	@Column(name = "type")
	var type: String?,

	@Column(name = "text")
	var text: String?,

	@Column(name = "district")
	var district: String?,

	@Column(name = "state")
	var state: String?,

	@Column(name = "postal_code")
	var postalCode: String?,

	@Column(name = "country")
	var country: String?

) : BaseDomain()

