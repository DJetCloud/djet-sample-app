package com.client.product.controller.filter

import com.client.controller.CommonFilter
import com.client.product.domain.Product
import com.client.product.domain.Product_
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

class ProductFilterOnPartyIdTypeCriticalRankEstimation(
	val partyId: String?,
	val type: String?,
	val critical: Boolean?,
	val rank: Int?,
	val estimation: String?
) : CommonFilter<Product> {
	override fun toSpecification(): Specification<Product> {
		return byPartyId().and(byType()).and(byCritical()).and(byRank()).and(byEstimation())
	}

	private fun byPartyId(): Specification<Product> {
		return Specification { root: Root<Product>, _: CriteriaQuery<*>, builder: CriteriaBuilder ->
			partyId?.let { builder.equal(root.get(Product_.partyId), it) }
		}
	}

	private fun byType(): Specification<Product> {
		return Specification { root: Root<Product>, _: CriteriaQuery<*>, builder: CriteriaBuilder ->
			type?.let { builder.equal(root.get(Product_.type), it) }
		}
	}

	private fun byCritical(): Specification<Product> {
		return Specification { root: Root<Product>, _: CriteriaQuery<*>, builder: CriteriaBuilder ->
			critical?.let { builder.equal(root.get(Product_.critical), it) }
		}
	}

	private fun byRank(): Specification<Product> {
		return Specification { root: Root<Product>, _: CriteriaQuery<*>, builder: CriteriaBuilder ->
			rank?.let { builder.equal(root.get(Product_.rank), it) }
		}
	}

	private fun byEstimation(): Specification<Product> {
		return Specification { root: Root<Product>, _: CriteriaQuery<*>, builder: CriteriaBuilder ->
			estimation?.let { builder.equal(root.get(Product_.estimation), it) }
		}
	}

	override fun getQuery(): String {
		val partyIdQuery = if (partyId != null) "partyId==$partyId;" else ""
		val typeQuery = if (type != null) "type==$type;" else ""
		val criticalQuery = if (critical != null) "critical==$critical;" else ""
		val rankQuery = if (rank != null) "rank==$rank;" else ""
		val estimationQuery = if (estimation != null) "estimation==$estimation" else ""
		return partyIdQuery + typeQuery + criticalQuery + rankQuery + estimationQuery
	}
}
