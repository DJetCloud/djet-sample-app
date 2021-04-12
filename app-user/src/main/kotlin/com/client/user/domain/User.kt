package com.client.user.domain

import com.client.domain.BaseResource
import com.client.user.domain.EmailAddress
import com.client.user.domain.ReferenceIdentity
import com.client.user.domain.UserPhone
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Complete information about user.
* @param email email used for user communication.
* @param phone Phone used for user registration and authentication.
* @param profile User public profile. Profile contains public information about user. This information will be visible to other users of organization. Additional profiles can be used in specific organization to override elements of profile different for this organization.
* @param parties List of parties that the user owns
* @param primaryParty Primary Party. Assigned while user creation in the system. 
* @param provider Reference identity of authorization provider
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "email", "phone", "profile", "parties", "primaryParty", "provider")

@Entity
@Table(name = "user")
data class User(

	@AttributeOverrides(
		AttributeOverride(name = "address", column = Column(name = "email_address")),
		AttributeOverride(name = "verified", column = Column(name = "email_verified")),
		AttributeOverride(name = "dateAdded", column = Column(name = "email_date_added")),
		AttributeOverride(name = "dateBounced", column = Column(name = "email_date_bounced")),
	)
	@Embedded
	var email: EmailAddress,

	@AttributeOverrides(
		AttributeOverride(name = "home", column = Column(name = "phone_home")),
		AttributeOverride(name = "work", column = Column(name = "phone_work")),
	)
	@Embedded
	var phone: UserPhone?,

	@Column(name = "profile")
	var profile: String?,

	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTable(
			name = "party_to_user",
			joinColumns = [JoinColumn(name = "user_id")]
	)
	@Column(name = "party_id")
	var parties: List<String>?,

	@Column(name = "primary_party")
	var primaryParty: String?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "provider", referencedColumnName = "id")
	var provider: ReferenceIdentity?

) : BaseResource()

