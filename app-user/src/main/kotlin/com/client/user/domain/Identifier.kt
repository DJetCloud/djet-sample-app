package com.client.user.domain

import com.client.domain.Attachment
import com.client.domain.BaseDomain
import com.client.domain.Element
import com.client.user.domain.ReferenceIdentity
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* A numeric or alphanumeric string that is associated with a single object or entity within a given system. Typically, identifiers are used to connect content in resources to external content available in other frameworks or protocols. Identifiers are associated with objects and may be changed or retired due to human or system process and errors. Structure
* @param header This is header of identifier element with id and period element is active.
* @param use A numeric or alphanumeric string that is associated with a single object or entity within a given system. Typically, identifiers are used to connect content in resources to external content available in other frameworks or protocols. Identifiers are associated with objects and may be changed or retired due to human or system process and errors.
* @param type Description of identifier
* @param system The namespace for the identifier value.
* @param value The value that is unique.
* @param description Description of identifier. Provide additional information about identifier.
* @param assigner Organization that issued id (may be just text)
* @param attachment Image or copy of the document to support identifier.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "use", "type", "system", "value", "description", "assigner", "attachment")

@Entity
@Table(name = "identifier")
data class Identifier(

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

	@Column(name = "system_")
	var system: String?,

	@Column(name = "value")
	var value: String?,

	@Column(name = "description")
	var description: String?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "assigner", referencedColumnName = "id")
	var assigner: ReferenceIdentity?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "attachment_to_identifier",
			joinColumns = [JoinColumn(name = "identifier_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "attachment_id", referencedColumnName = "id")]
	)
	var attachment: List<Attachment>?

) : BaseDomain()

