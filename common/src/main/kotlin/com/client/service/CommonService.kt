package com.client.service

import com.client.controller.CommonFilter
import com.client.domain.BaseResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CommonService<E: BaseResource> {
	fun save(domain: E): E?
	fun saveAll(domains: List<E>): List<E>
	fun delete(domain: E)
	fun getById(id: String): E?
	fun update(domain: E): E?
	fun getAll(pageable: Pageable, query: String?): Page<E>
	fun getByIds(ids: List<String>): List<E>
	fun deleteAll(domains: List<E>)
	fun getByIdAndFilter(id: String, filter: String): E?
	fun getAll(pageable: Pageable, query: String?, filter: CommonFilter<E>): Page<E>
}
