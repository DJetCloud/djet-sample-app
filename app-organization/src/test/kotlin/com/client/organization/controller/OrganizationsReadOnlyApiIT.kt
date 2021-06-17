package com.client.organization.controller

import com.client.organization.domain.Organization
import com.client.organization.domain.ReferenceLocation
import com.client.organization.OrganizationApplication
import com.client.organization.repository.OrganizationsReadOnlyRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MvcResult
import org.springframework.util.LinkedMultiValueMap
import java.util.*
import kotlin.test.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [OrganizationApplication::class])
@AutoConfigureMockMvc
class OrganizationsReadOnlyApiIT : AbstractIntegrationTest<Organization>() {

	private val url = "/organizations"

	@Autowired
	lateinit var repository: OrganizationsReadOnlyRepository

	@Test
	fun `organizationsReadOnlyGetOrganization with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `organizationsReadOnlyGetOrganization with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `organizationsReadOnlyGetOrganizationList api`() {
		repository.deleteAll()
		val res1 = createWithRequiredFields()
		val res2 = createWithAllFields()

		val savedRes1 = repository.save(res1)
		val savedRes2 = repository.save(res2)

		val params = LinkedMultiValueMap<String, String>()
		params["sort"] = "entity.history.createdAt"
		val result = super.findAll(url, params)

		resourceAsserts(savedRes1, result, 0)
		resourceAsserts(savedRes2, result, 1)
	}


	private fun resourceAsserts(savedResource: Organization, result: MvcResult, index: Int = -1) {
		val prefix = if (index == -1) "$" else "$.content[$index]"
		if (savedResource.id != null) {
			assertEquals(savedResource.id, getValue(result, "$prefix.identity.id"))
		} else {
			assertNotNull(getValue(result, "$prefix.identity.id"))
		}
		assertEquals(savedResource.identity.name, getValue(result, "$prefix.identity.name"))
		assertEquals(savedResource.identity.description, getValue(result, "$prefix.identity.description"))
		assertEquals(savedResource.entity.state, getValue(result, "$prefix.entity.state"))
		assertListsEquals(savedResource.type, getValue(result, "$prefix.type"))
		assertEquals(savedResource.partOf, getValue(result, "$prefix.partOf"))
		assertListsEquals(savedResource.location, getValue(result, "$prefix.location"))
		assertListsEquals(savedResource.contact, getValue(result, "$prefix.contact"))
		assertEquals(savedResource.legal, getValue(result, "$prefix.legal"))
		assertEquals(savedResource.account, getValue(result, "$prefix.account"))
	}

	private fun createWithRequiredFields(): Organization {
	return Organization(
				type = null,
				partOf = null,
				location = null,
				contact = null,
				legal = null,
				account = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
		}
	}

	private fun createWithAllFields(): Organization {
		return Organization(
				type = listOf("test_list_string_value"),
				partOf = "test string value",
				location = listOf(ReferenceLocation(
					resourceId = "test string value",
					name = "test string value",
					description = "test string value",
					type = "test string value",
					uri = "test string value"
				)),
				contact = listOf("test_list_string_value"),
				legal = "test string value",
				account = "test string value"
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
		}
	}

}
