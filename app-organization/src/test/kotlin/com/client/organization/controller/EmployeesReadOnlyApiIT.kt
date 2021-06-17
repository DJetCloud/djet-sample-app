package com.client.organization.controller

import com.client.organization.domain.Employee
import com.client.organization.domain.EmployeeRole
import com.client.domain.Element
import com.client.domain.Period
import com.client.organization.domain.ReferenceOrganizationRole
import com.client.organization.domain.ReferenceIdentity
import com.client.organization.OrganizationApplication
import com.client.organization.repository.EmployeesReadOnlyRepository
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
class EmployeesReadOnlyApiIT : AbstractIntegrationTest<Employee>() {

	private val url = "/employees"

	@Autowired
	lateinit var repository: EmployeesReadOnlyRepository

	@Test
	fun `employeesReadOnlyGetEmployee with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `employeesReadOnlyGetEmployee with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `employeesReadOnlyGetEmployeeList api`() {
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


	private fun resourceAsserts(savedResource: Employee, result: MvcResult, index: Int = -1) {
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
		assertListsEquals(savedResource.partOf, getValue(result, "$prefix.partOf"))
		assertListsEquals(savedResource.role, getValue(result, "$prefix.role"))
		assertObjectEquals(savedResource.reference, getValue(result, "$prefix.reference"))
		assertEquals(savedResource.schedule, getValue(result, "$prefix.schedule"))
	}

	private fun createWithRequiredFields(): Employee {
	return Employee(
				type = null,
				partOf = null,
				role = null,
				reference = null,
				schedule = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
		}
	}

	private fun createWithAllFields(): Employee {
		return Employee(
				type = "test_enum_value",
				partOf = listOf("test_list_string_value"),
				role = listOf(EmployeeRole(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					assignedRole = ReferenceOrganizationRole(
					resourceId = "test string value",
					name = "test string value",
					description = "test string value",
					type = "test string value",
					uri = "test string value"
				),
					excludedServices = listOf("test_list_string_value"),
					roleSchedule = "test string value"
				)),
				reference = ReferenceIdentity(
					resourceId = "test string value",
					name = "test string value",
					description = "test string value",
					type = "test string value",
					uri = "test string value"
				),
				schedule = "test string value"
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
		}
	}

}
