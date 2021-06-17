package com.client.organization.controller

import com.client.organization.domain.OrganizationRole
import com.client.organization.domain.ReferenceIdentity
import com.client.organization.domain.CodeableConcept
import com.client.domain.Element
import com.client.domain.Period
import com.client.organization.domain.Coding
import com.client.organization.domain.AvailableTime
import com.client.organization.domain.NotAvailableTime
import com.client.domain.Identity
import com.client.organization.OrganizationApplication
import com.client.organization.repository.OrganizationRolesRepository
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
class OrganizationRolesApiIT : AbstractIntegrationTest<OrganizationRole>() {

	private val url = "/organizations/parent-id/organizationroles"

	@Autowired
	lateinit var repository: OrganizationRolesRepository

	@Test
	fun `organizationRolesCreateOrganizationRole with required fields`() {
		val res = createWithRequiredFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `organizationRolesCreateOrganizationRole with all fields`() {
		val res = createWithAllFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `organizationRolesDeleteOrganizationRole api`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.delete(url, savedRes.id!!)
		savedRes.entity.state = "deleted"
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `organizationRolesGetOrganizationRole with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `organizationRolesGetOrganizationRole with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `organizationRolesGetOrganizationRoleList api`() {
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

	@Test
	fun `organizationRolesModifyOrganizationRole with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `organizationRolesUpdateOrganizationRole with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `organizationRolesUpdateOrganizationRole with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}


	private fun resourceAsserts(savedResource: OrganizationRole, result: MvcResult, index: Int = -1) {
		val prefix = if (index == -1) "$" else "$.content[$index]"
		if (savedResource.id != null) {
			assertEquals(savedResource.id, getValue(result, "$prefix.identity.id"))
		} else {
			assertNotNull(getValue(result, "$prefix.identity.id"))
		}
		assertEquals(savedResource.identity.name, getValue(result, "$prefix.identity.name"))
		assertEquals(savedResource.identity.description, getValue(result, "$prefix.identity.description"))
		assertEquals(savedResource.entity.state, getValue(result, "$prefix.entity.state"))
		assertEquals(savedResource.type, getValue(result, "$prefix.type"))
		assertObjectEquals(savedResource.reference, getValue(result, "$prefix.reference"))
		assertListsEquals(savedResource.telecom, getValue(result, "$prefix.telecom"))
		assertEquals(savedResource.location, getValue(result, "$prefix.location"))
		assertListsEquals(savedResource.availableTime, getValue(result, "$prefix.availableTime"))
		assertListsEquals(savedResource.notAvailable, getValue(result, "$prefix.notAvailable"))
		assertEquals(savedResource.availabilityExceptions, getValue(result, "$prefix.availabilityExceptions"))
		assertListsEquals(savedResource.services, getValue(result, "$prefix.services"))
	}

	private fun createWithRequiredFields(): OrganizationRole {
	return OrganizationRole(
				type = null,
				reference = null,
				telecom = null,
				location = null,
				availableTime = null,
				notAvailable = null,
				availabilityExceptions = null,
				services = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
			this.entity.parent = Identity(id = "parent-id")
		}
	}

	private fun createWithAllFields(): OrganizationRole {
		return OrganizationRole(
				type = "test_enum_value",
				reference = ReferenceIdentity(
					resourceId = "test string value",
					name = "test string value",
					description = "test string value",
					type = "test string value",
					uri = "test string value"
				),
				telecom = listOf(CodeableConcept(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					coding = listOf(Coding(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					version = "test string value",
					code = "test string value",
					display = "test string value",
					userSelected = false,
					system = "test string value"
				)),
					text = "test string value"
				)),
				location = "test string value",
				availableTime = listOf(AvailableTime(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					daysOfWeek = listOf("test_list_string_value"),
					allDay = false,
					availableStartTime = Date(),
					availableEndTime = Date()
				)),
				notAvailable = listOf(NotAvailableTime(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					description = "test string value",
					during = Period(
					start = Date(),
					end = Date()
				)
				)),
				availabilityExceptions = "test string value",
				services = listOf("test_list_string_value")
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
			this.entity.parent = Identity(id = "parent-id")
		}
	}

}
