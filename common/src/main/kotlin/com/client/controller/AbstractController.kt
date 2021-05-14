package com.client.controller

import com.client.domain.BaseResource
import com.client.domain.Identity
import com.client.exception.InvalidRequestException
import com.client.exception.ResourceNotFoundException
import com.client.service.CommonService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.*

abstract class AbstractController<E: BaseResource, S: CommonService<E>>(val  service: S):
		CommonController<E>, CommonParameterizedController<E> {

	override fun create(domain: E): ResponseEntity<E> {
		val result = service.save(domain)?: throw InvalidRequestException()
		return ResponseEntity(result, HttpStatus.CREATED)
	}

	override fun delete(id: String): ResponseEntity<E> {
		val entity = service.getById(id)?: throw ResourceNotFoundException()
		service.delete(entity)
		return ResponseEntity(entity, HttpStatus.OK)
	}

	override fun delete(id: String, filter: Map<String, Any?>): ResponseEntity<E> {
		val filterQuery = getFilterQuery(filter)
		if (filterQuery.isEmpty()) {
			return delete(id)
		}
		val entity = service.getByIdAndFilter(id, filterQuery) ?: throw ResourceNotFoundException()
		service.delete(entity)
		return ResponseEntity(entity, HttpStatus.OK)
	}

	override fun getById(id: String): ResponseEntity<E> {
		val entity = service.getById(id)?: throw ResourceNotFoundException()
		return ResponseEntity(entity, HttpStatus.OK)
	}

	override fun getById(id: String, filter: Map<String, Any?>): ResponseEntity<E> {
		val filterQuery = getFilterQuery(filter)
		if (filterQuery.isEmpty()) {
			return getById(id)
		}
		val entity = service.getByIdAndFilter(id, filterQuery) ?: throw ResourceNotFoundException()
		return ResponseEntity(entity, HttpStatus.OK)
	}

	override fun getAll(search: String?, pageable : Pageable): ResponseEntity<Page<E>> {
		return ResponseEntity(service.getAll(pageable, search), HttpStatus.OK)
	}

	override fun getAll(search: String?, pageable : Pageable, filter: Map<String, Any?>): ResponseEntity<Page<E>> {
		val searchCriteria = getSearchCriteria(search, filter)
		return ResponseEntity(service.getAll(pageable, searchCriteria), HttpStatus.OK)
	}

	override fun update(id: String, domain: E): ResponseEntity<E> {
		service.getById(id)?: throw ResourceNotFoundException()
		domain.id = id
		val result = service.update(domain)?: throw InvalidRequestException()
		return ResponseEntity(result, HttpStatus.OK)
	}

	override fun update(id: String, domain: E, filter: Map<String, Any?>): ResponseEntity<E> {
		val filterQuery = getFilterQuery(filter)
		if (!filterQuery.isEmpty()) {
			service.getByIdAndFilter(id, filterQuery) ?: throw ResourceNotFoundException()
		}
		domain.id = id
		val result = service.update(domain)?: throw InvalidRequestException()
		return ResponseEntity(result, HttpStatus.OK)
	}

	override fun modify(id: String, domain: E): ResponseEntity<E> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	override fun modify(id: String, domain: E, filter: Map<String, Any?>): ResponseEntity<E> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	override fun saveAll(domains: List<E>): List<E> {
		return service.saveAll(domains)
	}

	override fun saveAll(domains: List<E>, filter: Map<String, Any?>): List<E> {
		val filterQuery = getFilterQuery(filter)
		if (!filterQuery.isEmpty()) {
			domains.forEach {
				val id = it.id ?: throw ResourceNotFoundException()
				service.getByIdAndFilter(id, filterQuery) ?: throw ResourceNotFoundException()
			}
		}
		return service.saveAll(domains)
	}

	override fun deleteAll(@RequestParam ids: List<String>): List<E> {
		val domains = service.getByIds(ids)
		service.deleteAll(domains)
		return domains
	}

	override fun deleteAll(@RequestParam ids: List<String>, filter: Map<String, Any?>): List<E> {
		val domains = service.getByIds(ids)
		val filterQuery = getFilterQuery(filter)
		if (!filterQuery.isEmpty()) {
			domains.forEach{
				val id = it.id ?: throw ResourceNotFoundException()
				service.getByIdAndFilter(id, filterQuery) ?: throw ResourceNotFoundException()
			}
		}
		service.deleteAll(domains)
		return domains
	}

	override fun create(parentId: String, domain: E): ResponseEntity<E> {
		if(domain.entity.parent != null) {
			domain.entity.parent!!.id = parentId
		} else {
			domain.entity.parent = Identity(id = parentId)
		}
		val result = service.save(domain) ?: throw InvalidRequestException()
		return ResponseEntity(result, HttpStatus.CREATED)
	}

	override fun getById(parentId: String, id: String): ResponseEntity<E> {
		val domain = service.getById(id) ?: throw ResourceNotFoundException()
		Assert.isTrue(parentId == domain.entity.parent?.id, "parent $parentId is not valid")
		return ResponseEntity(domain, HttpStatus.OK)
	}

	override fun getById(parentId: String, id: String, filter: Map<String, Any?>): ResponseEntity<E> {
		val filterQuery = getFilterQuery(filter)
		if (filterQuery.isEmpty()) {
			return getById(parentId, id)
		}
		val domain = service.getByIdAndFilter(id, filterQuery) ?: throw ResourceNotFoundException()
		Assert.isTrue(parentId == domain.entity.parent?.id, "parent $parentId is not valid")
		return ResponseEntity(domain, HttpStatus.OK)
	}

	override fun delete(parentId: String, id: String): ResponseEntity<E> {
		val domain = service.getById(id) ?: throw ResourceNotFoundException()
		validateParent(domain, parentId)
		service.delete(domain)
		return ResponseEntity(domain, HttpStatus.OK)
	}

	override fun delete(parentId: String, id: String, filter: Map<String, Any?>): ResponseEntity<E> {
		val filterQuery = getFilterQuery(filter)
		if (filterQuery.isEmpty()) {
			return delete(parentId, id)
		}
		val domain = service.getByIdAndFilter(id, filterQuery) ?: throw ResourceNotFoundException()
		validateParent(domain, parentId)
		service.delete(domain)
		return ResponseEntity(domain, HttpStatus.OK)
	}

	override fun update(parentId: String, id: String, domain: E): ResponseEntity<E> {
		validateParent(domain, parentId)
		domain.id = id
		val updatedEntity = service.update(domain)
		return ResponseEntity(updatedEntity, HttpStatus.OK)
	}

	override fun update(parentId: String, id: String, domain: E, filter: Map<String, Any?>): ResponseEntity<E> {
		val filterQuery = getFilterQuery(filter)
		if (!filterQuery.isEmpty()) {
			service.getByIdAndFilter(id, filterQuery) ?: throw ResourceNotFoundException()
		}
		validateParent(domain, parentId)
		domain.id = id
		val updatedEntity = service.update(domain)
		return ResponseEntity(updatedEntity, HttpStatus.OK)
	}

	override fun modify(parentId: String, id: String, domain: E): ResponseEntity<E> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	override fun modify(parentId: String, id: String, domain: E, filter: Map<String, Any?>): ResponseEntity<E> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	override fun saveAll(parentId: String, domains: List<E>): List<E> {
		domains.forEach {
			validateParent(it, parentId)
			it.id = it.identity.id
		}
		return service.saveAll(domains)
	}

	override fun saveAll(parentId: String, domains: List<E>, filter: Map<String, Any?>): List<E> {
		val filterQuery = getFilterQuery(filter)
		if (filterQuery.isEmpty()) {
			return saveAll(parentId, domains)
		}
		domains.forEach {
			val id = it.id ?: throw ResourceNotFoundException()
			service.getByIdAndFilter(id, filterQuery) ?: throw ResourceNotFoundException()
			validateParent(it, parentId)
			it.id = it.identity.id
		}
		return service.saveAll(domains)
	}

	override fun deleteAll(parentId: String, ids: List<String>): List<E> {
		val entities = service.getByIds(ids)
		entities.forEach { domain ->
			validateParent(domain, parentId)
		}
		service.deleteAll(entities)
		return entities
	}

	override fun deleteAll(parentId: String, ids: List<String>, filter: Map<String, Any?>): List<E> {
		val entities = service.getByIds(ids)
		val filterQuery = getFilterQuery(filter)
		if (filterQuery.isEmpty()) {
			return deleteAll(parentId, ids)
		}
		entities.forEach {
			val id = it.id ?: throw ResourceNotFoundException()
			service.getByIdAndFilter(id, filterQuery) ?: throw ResourceNotFoundException()
			validateParent(it, parentId)
		}
		service.deleteAll(entities)
		return entities
	}

	override fun getAll(parentId: String, search: String?, pageable: Pageable): ResponseEntity<Page<E>> {
		val searchCriteria = getSearchCriteria(search, parentId)
		return ResponseEntity(service.getAll(pageable, searchCriteria), HttpStatus.OK)
	}

	override fun getAll(parentId: String, search: String?, pageable: Pageable, filter: Map<String, Any?>): ResponseEntity<Page<E>> {
		val searchCriteria = getSearchCriteria(search, parentId, filter)
		return ResponseEntity(service.getAll(pageable, searchCriteria), HttpStatus.OK)
	}

	private fun validateParent(domain: E, parentId: String) {
		Assert.notNull(domain.entity.parent, "parent can not be empty")
		Assert.notNull(domain.entity.parent?.id, "parent id is required")
		Assert.isTrue(parentId == domain.entity.parent?.id, "parent $parentId is not valid")
	}

	private fun getSearchCriteria(query: String?, parentId: String): String {
		val underParentSearchCriteria = "entity.parent.id==$parentId"
		return if (query.isNullOrBlank()) {
			underParentSearchCriteria
		} else {
			"$underParentSearchCriteria;$query"
		}
	}

	private fun getSearchCriteria(query: String?, filter: Map<String, Any?>): String? {
		val filterQuery = getFilterQuery(filter)
		return if (filterQuery.isEmpty()) {
			if (query.isNullOrBlank()) {
				null
			} else {
				query
			}
		} else if (query.isNullOrBlank()) {
			filterQuery
		} else {
			"$filterQuery;$query"
		}
	}

	private fun getSearchCriteria(query: String?, parentId: String, filter: Map<String, Any?>): String {
		val baseSearchCriteria = getSearchCriteria(query, filter)
		val underParentSearchCriteria = "entity.parent.id==$parentId"
		return if (baseSearchCriteria.isNullOrBlank()) {
			underParentSearchCriteria
		} else {
			"$underParentSearchCriteria;$baseSearchCriteria"
		}
	}

	private fun getFilterQuery(filter: Map<String, Any?>): String {
		var result = ""
		filter.forEach { (key, value) ->
			if (key != null && value != null) {
				result = "$result;$key==$value"
			}
		}
		return result
	}

	override fun getAll(search: String?, pageable: Pageable, filter: CommonFilter<E>): ResponseEntity<Page<E>> {
		return ResponseEntity(service.getAll(pageable, search, filter), HttpStatus.OK)
	}

	override fun getAll(parentId: String, search: String?, pageable: Pageable, filter: CommonFilter<E>): ResponseEntity<Page<E>> {
		val searchCriteria = getSearchCriteria(search, parentId)
		return ResponseEntity(service.getAll(pageable, searchCriteria, filter), HttpStatus.OK)
	}
}
