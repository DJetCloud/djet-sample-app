package com.client.user.domain

import com.client.domain.Attachment
import com.client.domain.BaseResource
import com.client.user.domain.Address
import com.client.user.domain.ContactPoint
import com.client.user.domain.HumanName
import com.client.user.domain.Identifier
import java.util.Date
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* An individual has identity outside of a healthcare setting. The Person resource is used to capture this information and to relate the person as an individual to other resources that do have a health-related context.  For example, while a patient resource may be created and maintained by each organization providing care for that person as a patient, a person resource provides a mechanism for linking patient resources across different organizations and their unique patient identity domains. 
* @param identifier Identifiers for this entity. A human identifier for this person.
* @param name A name associated with the person.
* @param telecom A contact detail for the person.
* @param gender Person gender.
* @param birthDate The date on which the person was born.
* @param address One or more addresses for the person.
* @param photo Image of the person
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "identifier", "name", "telecom", "gender", "birthDate", "address", "photo")

@Entity
@Table(name = "person")
data class Person(

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "identifier_to_person",
			joinColumns = [JoinColumn(name = "person_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "identifier_id", referencedColumnName = "id")]
	)
	var identifier: List<Identifier>?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "human_name_to_person",
			joinColumns = [JoinColumn(name = "person_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "human_name_id", referencedColumnName = "id")]
	)
	var name: List<HumanName>?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "contact_point_to_person",
			joinColumns = [JoinColumn(name = "person_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "contact_point_id", referencedColumnName = "id")]
	)
	var telecom: List<ContactPoint>?,

	@Column(name = "gender")
	var gender: String?,

	@Column(name = "birth_date")
	var birthDate: Date?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "address_to_person",
			joinColumns = [JoinColumn(name = "person_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "address_id", referencedColumnName = "id")]
	)
	var address: List<Address>?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "photo", referencedColumnName = "id")
	var photo: Attachment?

) : BaseResource()

