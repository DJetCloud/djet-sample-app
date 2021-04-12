package com.client.user.domain

import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* The user's phone numbers for home and work.
* @param home The user's home or cell phone.
* @param work The user's work phone.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("home", "work")

@Embeddable
data class UserPhone(

	@Column(name = "home")
	var home: String,

	@Column(name = "work")
	var work: String

) 

