package com.client.domain

import com.client.domain.Completion
import java.util.Date
import org.hibernate.annotations.Type
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Structure for object history. Object history provides information when object was updated and in what completion state it is now.
* @param createdAt Date of object creation.
* @param createdBy User created object.
* @param updatedAt Date of object last update. This is important value as it is flag for optimistic commit to detect overriding changes. 
* @param updatedBy User last updated object.
* @param updatedNote Mote about goal of object update.
* @param updatedMessage Message in issue associated with changes in object.
* @param reviewedAt Date object last update was reviewed by owner. This is indicates user see and aknowalage change.
* @param reviewedBy User who reviewed and acknowledge the last update changes.
* @param retiredAt Date object was retired.
* @param retiredBy User retired object.
* @param completions Array of completion statuses reached by this object.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Embeddable
data class History(

	@Column(name = "created_at")
	var createdAt: Date? = null,

	@Column(name = "created_by")
	var createdBy: String? = null,

	@Column(name = "updated_at")
	var updatedAt: Date? = null,

	@Column(name = "updated_by")
	var updatedBy: String? = null,

	@Column(name = "updated_note")
	var updatedNote: String? = null,

	@Column(name = "updated_message")
	var updatedMessage: String? = null,

	@Column(name = "reviewed_at")
	var reviewedAt: Date? = null,

	@Column(name = "reviewed_by")
	var reviewedBy: String? = null,

	@Column(name = "retired_at")
	var retiredAt: Date? = null,

	@Column(name = "retired_by")
	var retiredBy: String? = null,

	@Type(type = "json")
	@Column(name = "completions", columnDefinition = "json")
	var completions: List<Completion>? = null

) 

