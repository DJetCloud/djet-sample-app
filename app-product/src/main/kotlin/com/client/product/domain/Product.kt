package com.client.product.domain

import com.client.domain.Attachment
import com.client.domain.BaseResource
import com.client.product.domain.AvailableTime
import com.client.product.domain.CommunicationLanguage
import com.client.product.domain.ContactPoint
import com.client.product.domain.NotAvailableTime
import com.client.product.domain.Price
import com.client.product.domain.ProductRef
import com.client.product.domain.ProductSKU
import com.client.product.domain.ReferenceIdentity
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Products represent goods or services supplied by organizations of the party.
* @param type Type of the product. 
* @param category Category product belong to from list of product line categories.
* @param reference Reference to actual product specification for industry goods or services. Resource defined in product category industry. 
* @param service Reference to service to support this product. Service defines what will be done in what order and how it can be scheduled and executed. Service abstract and not bound to industry it belongs too. 
* @param sku Product SKU definition. SKU bound products together and allows to select SKU based on requiroments.
* @param products List of products associated with current product. For package it all products in the package. For sku it can be list of products with different SKU of this product.
* @param photo If there is a photo/symbol associated with this good or service, it may be included here to facilitate quick identification of the goods or services in a list.  
* @param telecom List of contacts related to this specific service.  
* @param communication Some services are specifically made available in multiple languages, this property permits a directory to declare the languages this is offered in. Typically this is only provided where a service operates in communities with mixed languages used.  When using this property it indicates that the service is available with this language, it is not derived from the practitioners, and not all are required to use this language, just that this language is available while scheduling.  
* @param location The location(s) where this  goods can be acquired or service may be provided.  
* @param coverageArea The location(s) that this service is available to (not where the service is provided).  The locations referenced by the coverage area can include both specific locations, including areas, and also conceptual domains too (mode = kind), such as a physical area (tri-state area) and some other attribute (covered by Example Care Organization). These types of Locations are often not managed by any specific organization. This could also include generic locations such as \"in-home\".  
* @param appointmentRequired Indicates whether or not a prospective consumer will require an appointment for a particular service at a site to be provided by the Organization. Indicates if an appointment is required for access to this service.  
* @param availableTime Times the Service Site is available 
* @param notAvailable Not available during this time due to provided reason 
* @param availabilityExceptions A description of site availability exceptions, e.g. public holiday availability. Succinctly describing all possible exceptions to normal site availability as details in the available Times and not available Times.  
* @param price Recommended price for product or service. 
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("identity", "entity", "type", "category", "reference", "service", "sku", "products", "photo", "telecom", "communication", "location", "coverageArea", "appointmentRequired", "availableTime", "notAvailable", "availabilityExceptions", "price")

@Entity
@Table(name = "product")
data class Product(

	@Column(name = "type")
	var type: String?,

	@Column(name = "category")
	var category: String?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "reference", referencedColumnName = "id")
	var reference: ReferenceIdentity?,

	@Column(name = "service")
	var service: String?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "sku", referencedColumnName = "id")
	var sku: ProductSKU,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "product_to_product_ref",
			joinColumns = [JoinColumn(name = "product_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "product_ref_id", referencedColumnName = "id")]
	)
	var products: List<ProductRef>?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "photo", referencedColumnName = "id")
	var photo: Attachment?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "contact_point_to_product",
			joinColumns = [JoinColumn(name = "product_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "contact_point_id", referencedColumnName = "id")]
	)
	var telecom: List<ContactPoint>?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "communication_language_to_product",
			joinColumns = [JoinColumn(name = "product_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "communication_language_id", referencedColumnName = "id")]
	)
	var communication: List<CommunicationLanguage>?,

	@Column(name = "location")
	var location: String?,

	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTable(
			name = "location_to_product",
			joinColumns = [JoinColumn(name = "product_id")]
	)
	@Column(name = "location_id")
	var coverageArea: List<String>?,

	@Column(name = "appointment_required")
	var appointmentRequired: Boolean?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "available_time_to_product",
			joinColumns = [JoinColumn(name = "product_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "available_time_id", referencedColumnName = "id")]
	)
	var availableTime: List<AvailableTime>?,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "not_available_time_to_product",
			joinColumns = [JoinColumn(name = "product_id", referencedColumnName = "id")],
			inverseJoinColumns = [JoinColumn(name = "not_available_time_id", referencedColumnName = "id")]
	)
	var notAvailable: List<NotAvailableTime>?,

	@Column(name = "availability_exceptions")
	var availabilityExceptions: String?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "price", referencedColumnName = "id")
	var price: Price?

) : BaseResource()

