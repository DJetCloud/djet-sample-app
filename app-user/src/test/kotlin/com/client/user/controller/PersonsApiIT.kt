package com.client.user.controller

import com.client.user.domain.Person
import com.client.user.domain.Identifier
import com.client.user.domain.Element
import com.client.user.domain.Period
import com.client.user.domain.ReferenceIdentity
import com.client.user.domain.Attachment
import com.client.user.domain.HumanName
import com.client.user.domain.ContactPoint
import com.client.user.domain.Address
import com.client.user.UserApplication
import com.client.user.repository.PersonsRepository
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
@SpringBootTest(classes = [UserApplication::class])
@AutoConfigureMockMvc
class PersonsApiIT : AbstractIntegrationTest<Person>() {

	private val url = "/persons"

	@Autowired
	lateinit var repository: PersonsRepository

	@Test
	fun `personsCreatePerson with required fields`() {
		val res = createWithRequiredFields()
		val result = super.create(url, res)
		val savedRes = repository.getOne(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `personsCreatePerson with all fields`() {
		val res = createWithAllFields()
		val result = super.create(url, res)
		val savedRes = repository.getOne(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `personsDeletePerson api`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.delete(url, savedRes.id!!)
		savedRes.entity.state = "deleted"
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `personsGetPerson with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `personsGetPerson with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `personsGetPersonList api`() {
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
	fun `personsModifyPerson with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `personsUpdatePerson with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `personsUpdatePerson with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}


	private fun resourceAsserts(savedResource: Person, result: MvcResult, index: Int = -1) {
		val prefix = if (index == -1) "$" else "$.content[$index]"
		if (savedResource.id != null) {
			assertEquals(savedResource.id, getValue(result, "$prefix.identity.id"))
		} else {
			assertNotNull(getValue(result, "$prefix.identity.id"))
		}
		assertEquals(savedResource.identity.name, getValue(result, "$prefix.identity.name"))
		assertEquals(savedResource.identity.description, getValue(result, "$prefix.identity.description"))
		assertEquals(savedResource.entity.state, getValue(result, "$prefix.entity.state"))
		assertListsEquals(savedResource.identifier, getValue(result, "$prefix.identifier"))
		assertListsEquals(savedResource.name, getValue(result, "$prefix.name"))
		assertListsEquals(savedResource.telecom, getValue(result, "$prefix.telecom"))
		assertEquals(savedResource.gender, getValue(result, "$prefix.gender"))
		assertDateEquals(savedResource.birthDate, getValue(result, "$prefix.birthDate"))
		assertListsEquals(savedResource.address, getValue(result, "$prefix.address"))
		assertObjectEquals(savedResource.photo, getValue(result, "$prefix.photo"))
	}

	private fun createWithRequiredFields(): Person {
	return Person(
				identifier = null,
				name = null,
				telecom = null,
				gender = null,
				birthDate = null,
				address = null,
				photo = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
		}
	}

	private fun createWithAllFields(): Person {
		return Person(
				identifier = listOf(Identifier(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					use = "test_enum_value",
					type = "test_enum_value",
					system = "test string value",
					value = "test string value",
					description = "test string value",
					assigner = ReferenceIdentity(
					resourceId = "test string value",
					name = "test string value",
					description = "test string value",
					type = "test string value",
					uri = "test string value"
				),
					attachment = listOf(Attachment(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					contentType = "test string value",
					language = "test_enum_value",
					data = "test string value",
					url = "test string value",
					size = 8,
					hash = "test string value",
					title = "test string value",
					creation = Date()
				))
				)),
				name = listOf(HumanName(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					use = "test_enum_value",
					text = "test string value",
					family = "test string value",
					given = listOf("test_list_string_value"),
					prefix = listOf("test_list_string_value"),
					suffix = listOf("test_list_string_value")
				)),
				telecom = listOf(ContactPoint(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					system = "test_enum_value",
					value = "test string value",
					use = "test_enum_value",
					rank = 8
				)),
				gender = "test_enum_value",
				birthDate = Date(),
				address = listOf(Address(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					use = "test_enum_value",
					type = "test_enum_value",
					text = "test string value",
					district = "test string value",
					state = "test string value",
					postalCode = "test string value",
					country = "test_enum_value"
				)),
				photo = Attachment(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					contentType = "test string value",
					language = "test_enum_value",
					data = "test string value",
					url = "test string value",
					size = 8,
					hash = "test string value",
					title = "test string value",
					creation = Date()
				)
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
		}
	}

}
