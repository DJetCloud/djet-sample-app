package com.client.user.domain

import com.client.domain.BaseResource
import com.client.user.domain.Address
import com.client.user.domain.ContactPoint
import com.client.user.domain.HoursOfOperation
import com.client.user.domain.Position
import org.hibernate.annotations.Type
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* https://www.hl7.org/fhir/location.html Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.  A Location includes both incidental locations (a place which is used for healthcare without prior designation or authorization) and dedicated, formally appointed locations. Locations may be private, public, mobile or fixed and scale from small freezers to full hospital buildings or parking garages.
* @param type Type of location.
* @param mode Mode of location.
* @param status Status of location.
* @param operationalStatus The operational status of the location (typically only for a bed/room)
* @param physicalType Physical form of the location
* @param telecom A contact detail.
* @param address One or more addresses for the contact.
* @param position The absolute geographic location
* @param hoursOfOperation What days/times during a week is this location usually open
* @param availabilityExceptions Description of availability exceptions
* @param partOf Another Location this one is physically a part of
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "type", "mode", "status", "operationalStatus", "physicalType", "telecom", "address", "position", "hoursOfOperation", "availabilityExceptions", "partOf")

@Entity
@Table(name = "location")
data class Location(

	@Type(type = "json")
	@Column(name = "type", columnDefinition = "json")
	var type: List<String>?,

	@Column(name = "mode")
	var mode: String?,

	@Column(name = "status")
	var status: String?,

	@Column(name = "operational_status")
	var operationalStatus: String?,

	@Column(name = "physical_type")
	var physicalType: String?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "contact_point_to_location",
			joinColumns = [JoinColumn(name = "location_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "contact_point_id", referencedColumnName = "id")]
	)
	var telecom: List<ContactPoint>?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "address", referencedColumnName = "id")
	var address: Address?,

	@AttributeOverrides(
		AttributeOverride(name = "longitude", column = Column(name = "position_longitude")),
		AttributeOverride(name = "altitude", column = Column(name = "position_altitude")),
		AttributeOverride(name = "latitude", column = Column(name = "position_latitude")),
	)
	@Embedded
	var position: Position?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "hours_of_operation_to_location",
			joinColumns = [JoinColumn(name = "location_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "hours_of_operation_id", referencedColumnName = "id")]
	)
	var hoursOfOperation: List<HoursOfOperation>?,

	@Column(name = "availability_exceptions")
	var availabilityExceptions: String?,

	@Column(name = "part_of")
	var partOf: String?

) : BaseResource()

