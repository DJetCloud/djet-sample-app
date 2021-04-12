package com.client.user.domain

import com.client.domain.BaseResource
import com.client.user.domain.Address
import com.client.user.domain.ContactPoint
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* An individual has identity outside of a healthcare setting. The Person resource is used to capture this information and to relate the person as an individual to other resources that do have a health-related context.  For example, while a patient resource may be created and maintained by each organization providing care for that person as a patient, a person resource provides a mechanism for linking patient resources across different organizations and their unique patient identity domains. 
* @param type Type of contact.
* @param telecom A contact detail.
* @param address One or more addresses for the contact.
* @param person Person for contact if contact associated with one.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "type", "telecom", "address", "person")

@Entity
@Table(name = "contact")
data class Contact(

	@Column(name = "type")
	var type: String?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "contact_to_contact_point",
			joinColumns = [JoinColumn(name = "contact_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "contact_point_id", referencedColumnName = "id")]
	)
	var telecom: List<ContactPoint>?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "address_to_contact",
			joinColumns = [JoinColumn(name = "contact_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "address_id", referencedColumnName = "id")]
	)
	var address: List<Address>?,

	@Column(name = "person")
	var person: String?

) : BaseResource()

