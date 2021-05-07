package com.client.organization.domain

import com.client.domain.BaseDomain
import com.client.organization.domain.Element
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Role assigned to Employee from organization list of roles. 
* @param header This header of element with id and period of element activity.
* @param assignedRole Organization role assigned to employee
* @param excludedServices List of services excluded from employee permission list.
* @param roleSchedule Schedule for availability of employee to perform specified role. Schedule of employee defines when he available to execute any of his roles. This schedule define his availability for this role only.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "assignedRole", "excludedServices", "roleSchedule")

@Entity
@Table(name = "employee_role")
data class EmployeeRole(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "assigned_role")
	var assignedRole: String?,

	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTable(
			name = "employee_role_to_product",
			joinColumns = [JoinColumn(name = "employee_role_id")]
	)
	@Column(name = "product_id")
	var excludedServices: List<String>?,

	@Column(name = "role_schedule")
	var roleSchedule: String?

) : BaseDomain()

