package com.client.user.domain

import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Stores details about an email address that a user has associated with their account.
* @param address The email address, e.g. `foo@example.com`
* @param verified true if the user has clicked the link in a confirmation email to this address.
* @param dateAdded Timestamp (milliseconds since epoch) when the email address was added to the account.
* @param dateBounced Timestamp (milliseconds since epoch) when an email sent to this address last bounced. Reset to null when the address no longer bounces.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("address", "verified", "dateAdded", "dateBounced")

@Embeddable
data class EmailAddress(

	@Column(name = "address")
	var address: String,

	@Column(name = "verified")
	var verified: Boolean,

	@Column(name = "date_added")
	var dateAdded: Long,

	@Column(name = "date_bounced")
	var dateBounced: Long?

) 

