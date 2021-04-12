package com.client.organization.domain

import com.client.domain.BaseResource
import com.client.organization.domain.AvailableTime
import com.client.organization.domain.CodeableConcept
import com.client.organization.domain.NotAvailableTime
import com.client.organization.domain.ReferenceIdentity
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Role to play in organization. Employees can play multiple or single role in organization. Role can define what services provided by the role and in what availability of this role services.
* @param type Type of the role
* @param reference Reference to actual role specification defined by type. Resource defined in organization role type. 
* @param telecom Contact details that are specific to the role/location/service.   
* @param location The location(s) at which this role operates.
* @param availableTime Times the role service is available 
* @param notAvailable Not available during this time due to provided reason 
* @param availabilityExceptions A description of site availability exceptions, e.g. public holiday availability. Succinctly describing all possible exceptions to normal site availability as details in the available Times and not available Times.  
* @param services The list of services that this worker provides for this role's Organization/Location(s) 
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "type", "reference", "telecom", "location", "availableTime", "notAvailable", "availabilityExceptions", "services")

@Entity
@Table(name = "organization_role")
data class OrganizationRole(

	@Column(name = "type")
	var type: String?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "reference", referencedColumnName = "id")
	var reference: ReferenceIdentity?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "organization_role_to_telecom",
			joinColumns = [JoinColumn(name = "organization_role_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "codeable_concept_id", referencedColumnName = "id")]
	)
	var telecom: List<CodeableConcept>?,

	@Column(name = "location")
	var location: String?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "available_time_to_organization_role",
			joinColumns = [JoinColumn(name = "organization_role_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "available_time_id", referencedColumnName = "id")]
	)
	var availableTime: List<AvailableTime>?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "not_available_time_to_organization_role",
			joinColumns = [JoinColumn(name = "organization_role_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "not_available_time_id", referencedColumnName = "id")]
	)
	var notAvailable: List<NotAvailableTime>?,

	@Column(name = "availability_exceptions")
	var availabilityExceptions: String?,

	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTable(
			name = "organization_role_to_product",
			joinColumns = [JoinColumn(name = "organization_role_id")]
	)
	@Column(name = "product_id")
	var services: List<String>?

) : BaseResource()

