package com.client.user.domain

import com.client.domain.BaseDomain
import com.client.user.domain.Element
import java.util.UUID
import org.hibernate.annotations.Type
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* A name of a human with text, parts and usage information.  Names may be changed or repudiated. People may have different names in different contexts. Names may be divided into parts of different type that have variable significance depending on context, though the division into parts is not always significant. With personal names, the different parts might or might not be imbued with some implicit meaning; various cultures associate different importance with the name parts and the degree to which systems SHALL care about name parts around the world varies widely. 
* @param header This is header of name structure with id and period name element is active.
* @param use Identifies the purpose for this name.
* @param text Text representation of the full name.
* @param family Family name (often called 'Surname')
* @param given Given names (not always 'first'). Includes middle names This repeating element order: Given Names appear in the correct order for presenting the name
* @param prefix Parts that come before the name This repeating element order: Prefixes appear in the correct order for presenting the name
* @param suffix Parts that come after the name This repeating element order: Suffixes appear in the correct order for presenting the name
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "use", "text", "family", "given", "prefix", "suffix")

@Entity
@Table(name = "human_name")
data class HumanName(

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

	@Column(name = "text")
	var text: String?,

	@Column(name = "family")
	var family: String?,

	@Type(type = "json")
	@Column(name = "given", columnDefinition = "json")
	var given: List<String>?,

	@Type(type = "json")
	@Column(name = "prefix", columnDefinition = "json")
	var prefix: List<String>?,

	@Type(type = "json")
	@Column(name = "suffix", columnDefinition = "json")
	var suffix: List<String>?

) : BaseDomain()

