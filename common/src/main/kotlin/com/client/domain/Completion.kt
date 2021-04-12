package com.client.domain

import java.util.Date
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Completion status for stage of execution like: finilization, aproval and so on.
* @param status Completion Status for some state of execution.
* @param completedAt Date of status acived and satge of activity completed.
* @param completedBy Person documented completion of this stage by user name.
* @param completedNote Note provided by operator on completion.
* @param completedMessage This is link to message, which change status of the issue to specified by this completion.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Embeddable
data class Completion(

	@Column(name = "status")
	var status: String,

	@Column(name = "completed_at")
	var completedAt: Date?,

	@Column(name = "completed_by")
	var completedBy: String?,

	@Column(name = "completed_note")
	var completedNote: String?,

	@Column(name = "completed_message")
	var completedMessage: String?

) 

