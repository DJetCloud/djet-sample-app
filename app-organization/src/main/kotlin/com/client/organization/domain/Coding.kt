package com.client.organization.domain

import com.client.domain.BaseDomain
import com.client.organization.domain.Element
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* A Coding is a representation of a defined concept using a symbol from a defined \"code system\"
* @param header Header of coding element
* @param version Version of the system - if relevant
* @param code Symbol in syntax defined by the system
* @param display Representation defined by the system
* @param userSelected If this coding was chosen directly by the user
* @param system Identity of the terminology system
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "version", "code", "display", "userSelected", "system")

@Entity
@Table(name = "coding")
data class Coding(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "version")
	var version: String?,

	@Column(name = "code")
	var code: String?,

	@Column(name = "display")
	var display: String?,

	@Column(name = "user_selected")
	var userSelected: Boolean?,

	@Column(name = "system_")
	var system: String?

) : BaseDomain()

