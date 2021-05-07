package com.client.product.domain

import com.client.domain.BaseDomain
import com.client.product.domain.ContractPartyRole
import com.client.product.domain.Element
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Party of contract for product distribution. This is reference to party actually playing specific role.
* @param header This header of element with order and period of element activity.
* @param role Role of the party in the contract.
* @param party Reference to party legal entity playing this role in the contract. Party can have legal entity playing role od supplier and other legal entity play role of distributor. It provides flexibility of managing multiple roles by one party. 
* @param account Account to use for money transaction. When not specified used default legal entity account.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("id", "header", "role", "party", "account")

@Entity
@Table(name = "contract_party")
data class ContractParty(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "role")
	var role: ContractPartyRole,

	@Column(name = "party")
	var party: String,

	@Column(name = "account")
	var account: String?

) : BaseDomain()

