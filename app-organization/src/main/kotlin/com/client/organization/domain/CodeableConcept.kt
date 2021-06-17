package com.client.organization.domain

import com.client.domain.BaseDomain
import com.client.domain.Element
import com.client.organization.domain.Coding
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* A CodeableConcept represents a value that is usually supplied by providing a reference to one or more terminologies or ontologies but may also be defined by the provision of text. This is a common pattern in healthcare data. Concept - reference to a terminology or just text.
* @param header Header of codable concept element
* @param coding Code defined by a terminology system. It can be list of different codes.
* @param text Plain text representation of the concept
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "coding", "text")

@Entity
@Table(name = "codeable_concept")
data class CodeableConcept(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "codeable_concept_to_coding",
			joinColumns = [JoinColumn(name = "codeable_concept_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "coding_id", referencedColumnName = "id")]
	)
	var coding: List<Coding>?,

	@Column(name = "text")
	var text: String?

) : BaseDomain()

