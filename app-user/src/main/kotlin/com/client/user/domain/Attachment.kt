package com.client.user.domain

import com.client.domain.BaseDomain
import com.client.user.domain.Element
import java.util.Date
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* This type is for containing or referencing attachments - additional data content defined in other formats. The most common use of this type is to include images or reports in some report format such as PDF. However it can be used for any data that has a MIME type.  http://build.fhir.org//datatypes.html#Attachment
* @param header Management information for document
* @param contentType Mime type of the content, with charset etc.
* @param language Human language of the content (BCP-47)
* @param data Data inline, base64ed
* @param url Uri where the data can be found
* @param size Number of bytes of content (if url provided)
* @param hash Hash of the data (sha-1, base64ed)
* @param title Label to display in place of the data
* @param creation Date attachment was first created
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.3.0")

@JsonPropertyOrder("id", "header", "contentType", "language", "data", "url", "size", "hash", "title", "creation")

@Entity
@Table(name = "attachment")
data class Attachment(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "content_type")
	var contentType: String?,

	@Column(name = "language")
	var language: String?,

	@Column(name = "data")
	var data: String?,

	@Column(name = "url")
	var url: String?,

	@Column(name = "size")
	var size: Int?,

	@Column(name = "hash")
	var hash: String?,

	@Column(name = "title")
	var title: String?,

	@Column(name = "creation")
	var creation: Date?

) : BaseDomain()

