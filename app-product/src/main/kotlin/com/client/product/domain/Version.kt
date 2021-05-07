package com.client.product.domain

import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Object version. Version presented by 3 values: Major present backward incompatable versions, Minor identify backward compatable version and Revision identified small fixes.
* @param major Major version of object. Major version introduced for not backward compatabale changes. New major version of an object can be created only for latest object version.
* @param minor Minor version of object. Minor version introduce for backward compatable changes. New minor version of an object can be created only for latest object version.
* @param revision Object revision. Introduced for bag fixes with backward compatability garantee. Revision can be created for any version of the object.
* @param label Version label. Human friendly label for the version. Label need to be unique for all object versions.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.1.0")

@JsonPropertyOrder("major", "minor", "revision", "label")

@Embeddable
data class Version(

	@Column(name = "major")
	var major: Int,

	@Column(name = "minor")
	var minor: Int,

	@Column(name = "revision")
	var revision: Int,

	@Column(name = "label")
	var label: String?

) 

