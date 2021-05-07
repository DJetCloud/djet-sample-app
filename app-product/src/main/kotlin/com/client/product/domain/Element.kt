package com.client.product.domain

import com.client.product.domain.Period
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* The base definition for all elements contained inside a resource. All elements, whether defined as a Data Type (including primitives) or as part of a resource structure, have this base content:  Extensions An internal id There are 3 kinds of descendent types that specialize Element:  Primitive data types, that add a primitive value property of the specified type Complex data types, that add their own children (all of which are also elements) BackboneElement, A specialization that adds modifierExtension, which is the super-type of all the element types defined in resource definitions (e.g. Patient.contact) Note that resources themselves all specialize the base type Resource.  http://build.fhir.org//element.html
* @param order Order of element in list. Order can be defined by user or selected by system. Most common order is order of introduction.
* @param rank Rank of the element in list. 1 - is a highest rank.
* @param period Time period element apply to. If period not close, it is current element. If period closed, it is element relevant for this period.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.4.0")

@JsonPropertyOrder("order", "rank", "period")

@Embeddable
data class Element(

	@Column(name = "order_")
	var order: Int?,

	@Column(name = "rank_")
	var rank: Int?,

	@AttributeOverrides(
		AttributeOverride(name = "start", column = Column(name = "period_start")),
		AttributeOverride(name = "end", column = Column(name = "period_end")),
	)
	@Embedded
	var period: Period?

) 

