package com.client.organization.domain

import com.client.domain.BaseDomain
import com.client.organization.domain.Element
import com.client.organization.domain.Period
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* The service or goods is not available during this period of time due to the provided reason. 
* @param header This header of element with order and period of element activity.
* @param description The reason that can be presented to the user as to why this time is not available.
* @param during Service is not available (seasonally or for a public holiday) from this date.    
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "description", "during")

@Entity
@Table(name = "not_available_time")
data class NotAvailableTime(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "description")
	var description: String,

	@AttributeOverrides(
		AttributeOverride(name = "start", column = Column(name = "during_start")),
		AttributeOverride(name = "end", column = Column(name = "during_end")),
	)
	@Embedded
	var during: Period?

) : BaseDomain()

