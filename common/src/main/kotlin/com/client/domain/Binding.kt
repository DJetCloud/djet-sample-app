package com.client.domain

import com.client.domain.BaseDomain
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Binding represents connection of entity to entity in other external systems. It can be system where entity actually originated ond from which it was imported or system where entity exported.
* @param type Type of binding defines system we bind to.
* @param code Code of object in system we bind to if different from id.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Entity
@Table(name = "binding")
data class Binding(

	@Column(name = "type")
	var type: String,

	@Column(name = "code")
	var code: String?

) : BaseDomain()

