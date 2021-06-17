package com.client.party.domain

import com.client.domain.BaseResource
import com.client.domain.Period
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Legal entity of a party. Party can have multiple legal entities used in different regions or for any other reason.
* @param type Type of legal entity
* @param country Region for legal entity.
* @param legalEntityCode Human friendly legal entity name used on documents when different from actual legal name.
* @param govermentId Id provided by respective government for legal entity.
* @param active Date legal entity start and end time to operate.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "type", "country", "legalEntityCode", "govermentId", "active")

@Entity
@Table(name = "legal_entity")
data class LegalEntity(

	@Column(name = "type")
	var type: String,

	@Column(name = "country")
	var country: String?,

	@Column(name = "legal_entity_code")
	var legalEntityCode: String?,

	@Column(name = "goverment_id")
	var govermentId: String?,

	@AttributeOverrides(
		AttributeOverride(name = "start", column = Column(name = "active_start")),
		AttributeOverride(name = "end", column = Column(name = "active_end")),
	)
	@Embedded
	var active: Period?

) : BaseResource()

