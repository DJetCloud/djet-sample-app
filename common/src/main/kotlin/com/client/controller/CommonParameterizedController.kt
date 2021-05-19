package com.client.controller

import com.client.domain.BaseResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface CommonParameterizedController<E : BaseResource> {
    fun create(parentId: String, domain: E): ResponseEntity<E>
    fun getById(parentId: String, id: String): ResponseEntity<E>
    fun delete(parentId: String, id: String): ResponseEntity<E>
    fun update(parentId: String, id: String, domain: E): ResponseEntity<E>
    fun modify(parentId: String, id: String, domain: E): ResponseEntity<E>
    fun saveAll(parentId: String, domains: List<E>): List<E>
    fun deleteAll(parentId: String, ids: List<String>): List<E>
    fun getAll(parentId: String, search: String?, pageable : Pageable): ResponseEntity<Page<E>>

	fun getById(parentId: String, id: String, filter: CommonFilter<E>): ResponseEntity<E>
    fun delete(parentId: String, id: String, filter: CommonFilter<E>): ResponseEntity<E>
    fun update(parentId: String, id: String, domain: E, filter: CommonFilter<E>): ResponseEntity<E>
    fun modify(parentId: String, id: String, domain: E, filter: CommonFilter<E>): ResponseEntity<E>
    fun saveAll(parentId: String, domains: List<E>, filter: CommonFilter<E>): List<E>
    fun deleteAll(parentId: String, ids: List<String>, filter: CommonFilter<E>): List<E>
    fun getAll(parentId: String, search: String?, pageable : Pageable, filter: CommonFilter<E>): ResponseEntity<Page<E>>
}
