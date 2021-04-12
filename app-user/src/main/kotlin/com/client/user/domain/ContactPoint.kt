package com.client.user.domain

import com.client.domain.BaseDomain
import com.client.user.domain.Element
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Details for all kinds of technology-mediated contact points for a person or organization, including telephone, email, etc.   http://build.fhir.org//datatypes.html#ContactPoint
* @param header This is header of contact point element with id and period element is active. 
* @param system System for contact point
* @param value The actual contact point details
* @param use What contact point use for.
* @param rank Specify preferred order of use (1 = highest).
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "system", "value", "use", "rank")

@Entity
@Table(name = "contact_point")
data class ContactPoint(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "system_")
	var system: String?,

	@Column(name = "value")
	var value: String?,

	@Column(name = "use_")
	var use: String?,

	@Column(name = "rank_")
	var rank: Int?

) : BaseDomain()

