package com.client.product.domain

import java.util.Date
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* A time period defined by a start and end date/time.  A period specifies a range of times. The context of use will specify whether the entire range applies (e.g. \"the patient was an inpatient of the hospital for this time range\") or one value from the period applies (e.g. \"give to the patient between 2 and 4 pm on 24-Jun 2013\"). This is simple period used not as part of array of elements.
* @param start Starting time with inclusive boundary
* @param end End time with inclusive boundary, if not ongoing.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.3.1")

@JsonPropertyOrder("start", "end")

@Embeddable
data class Period(

	@Column(name = "start")
	var start: Date?,

	@Column(name = "end")
	var end: Date?

) 

