package com.client.product.domain

import com.client.domain.BaseDomain
import com.client.product.domain.Element
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* A communication language used by contact person. 
* @param header This header of element with id and period of element activity.
* @param language The language which can be used to communicate with the patient about his or her health
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.1.0")

@JsonPropertyOrder("id", "header", "language")

@Entity
@Table(name = "communication_language")
data class CommunicationLanguage(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "language")
	var language: String?

) : BaseDomain()

