package com.client.domain

import com.client.domain.Binding
import com.client.domain.History
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.UUID
import org.hibernate.annotations.Type
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Updatable entity. Entity can be accessed by API and referenced.
* @param parent Reference to id of folder for current entity. It include full URI of parent entity in name always  starting from party.
* @param type Type of the entity.
* @param state State of the entity
* @param alias List of additional names for the entity.
* @param token Encrypted token for access to entity data.
* @param containingFolder The folder that is the container of the entity
* @param managingOrganization The organization that is the custodian of the entity
* @param source Source system originated the entity. If not specified entity instantiated by core system.
* @param bindings Reference to entity system bind to.
* @param history History of the entity instance.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Entity
@Table(name = "entity")
data class ResourceEntity(

	@JsonIgnore
	@Id
	@Column(name = "entity_id")
	var entityId: String? = null,

	@AttributeOverrides(
		AttributeOverride(name = "id", column = Column(name = "parent_id")),
		AttributeOverride(name = "name", column = Column(name = "parent_name")),
		AttributeOverride(name = "description", column = Column(name = "parent_description")),
	)
	@Embedded
	var parent: Identity? = null,

	@Column(name = "type")
	var type: String? = null,

	@Column(name = "state")
	var state: String? = null,

	@Type(type = "json")
	@Column(name = "alias", columnDefinition = "json")
	var alias: List<String>? = null,

	@Column(name = "token")
	var token: String? = null,

	@Column(name = "containing_folder")
	var containingFolder: String? = null,

	@Column(name = "managing_organization")
	var managingOrganization: String? = null,

	@Column(name = "source")
	var source: String? = null,

	@OneToMany(cascade = [CascadeType.ALL])
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name = "binding_to_entity",
			joinColumns = [JoinColumn(name = "entity_id", referencedColumnName = "entity_id")],
			inverseJoinColumns = [JoinColumn(name = "binding_id", referencedColumnName = "id")]
	)
	var bindings: List<Binding>? = null,

	@Embedded
	var history: History = History()

) 

