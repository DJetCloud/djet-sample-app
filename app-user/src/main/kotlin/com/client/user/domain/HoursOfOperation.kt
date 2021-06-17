package com.client.user.domain

import com.client.domain.BaseDomain
import com.client.domain.Element
import java.util.UUID
import org.hibernate.annotations.Type
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* What days/times during a week entity usually operational.
* @param header This header of element with id and period of element activity.
* @param daysOfWeek Days of week entity is operational.
* @param allDay The entity is operational all day
* @param openingTime Time that the entity operation start
* @param closingTime Time that the entity operation ends
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "daysOfWeek", "allDay", "openingTime", "closingTime")

@Entity
@Table(name = "hours_of_operation")
data class HoursOfOperation(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Type(type = "json")
	@Column(name = "days_of_week", columnDefinition = "json")
	var daysOfWeek: List<String>?,

	@Column(name = "all_day")
	var allDay: Boolean?,

	@Column(name = "opening_time")
	var openingTime: String?,

	@Column(name = "closing_time")
	var closingTime: String?

) : BaseDomain()

