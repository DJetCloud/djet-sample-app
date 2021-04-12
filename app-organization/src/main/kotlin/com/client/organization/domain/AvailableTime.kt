package com.client.organization.domain

import com.client.domain.BaseDomain
import com.client.organization.domain.Element
import java.util.Date
import java.util.UUID
import org.hibernate.annotations.Type
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* A collection of times that the Service Site is available.  More detailed availability information may be provided in associated Schedule/Slot resources.  
* @param header This header of element with order and period of element activity.
* @param daysOfWeek Indicates which days of the week are available between the start and end Times.  
* @param allDay Is this always available? (hence times are irrelevant) e.g. 24 hour service.  
* @param availableStartTime The opening time of day. Note: If the AllDay flag is set, then this time is ignored.  
* @param availableEndTime The closing time of day. Note: If the AllDay flag is set, then this time is ignored.  The time zone is expected to be for where this HealthcareService is provided at.  
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.1")

@JsonPropertyOrder("id", "header", "daysOfWeek", "allDay", "availableStartTime", "availableEndTime")

@Entity
@Table(name = "available_time")
data class AvailableTime(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
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

	@Column(name = "available_start_time")
	var availableStartTime: Date?,

	@Column(name = "available_end_time")
	var availableEndTime: Date?

) : BaseDomain()

