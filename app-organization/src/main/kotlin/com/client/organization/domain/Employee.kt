package com.client.organization.domain

import com.client.domain.BaseResource
import com.client.organization.domain.EmployeeRole
import com.client.organization.domain.ReferenceIdentity
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Organization represents departments party have and hierarchical organization of departments inside party.
* @param type Type of the employee in organization. 
* @param partOf Reference to organizations employee assign to.
* @param role List of roles employee represents in organizations. Usually employee associated only with one resource, but it can be employee handle multiple functions in clinic. Schedule will define what time employee operate in specific role.
* @param reference Reference to actual employee specification for industry. Resource defined in organization of industry. For healthcare it will be practitioner.
* @param schedule Reference to schedule for employee in schedule service. This is when employee available for any role he have in organization. When employee have multiple role and separate availability per role, it can be specified in schedule of employee role.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "type", "partOf", "role", "reference", "schedule")

@Entity
@Table(name = "employee")
data class Employee(

	@Column(name = "type")
	var type: String?,

	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTable(
			name = "employee_to_organization",
			joinColumns = [JoinColumn(name = "employee_id")]
	)
	@Column(name = "organization_id")
	var partOf: List<String>?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "employee_to_employee_role",
			joinColumns = [JoinColumn(name = "employee_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "employee_role_id", referencedColumnName = "id")]
	)
	var role: List<EmployeeRole>?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "reference", referencedColumnName = "id")
	var reference: ReferenceIdentity?,

	@Column(name = "schedule")
	var schedule: String?

) : BaseResource()

