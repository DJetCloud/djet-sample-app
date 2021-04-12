package com.client.user.controller

import com.client.user.domain.Location
import com.client.user.domain.ContactPoint
import com.client.user.domain.Element
import com.client.user.domain.Period
import com.client.user.domain.Address
import com.client.user.domain.Position
import com.client.user.domain.HoursOfOperation
import com.client.user.UserApplication
import com.client.user.repository.LocationsRepository
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
class LocationsApiIT : AbstractIntegrationTest<Location>() {

	private val url = "/locations"

	@Autowired
	lateinit var repository: LocationsRepository

	@Test
	fun `locationsCreateLocation with required fields`() {
		val res = createWithRequiredFields()
		val result = super.create(url, res)
		val savedRes = repository.getOne(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `locationsCreateLocation with all fields`() {
		val res = createWithAllFields()
		val result = super.create(url, res)
		val savedRes = repository.getOne(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `locationsGetLocation with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `locationsGetLocation with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `locationsGetLocationList api`() {
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
	fun `locationsModifyLocation with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `locationsUpdateLocation with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `locationsUpdateLocation with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}


	private fun resourceAsserts(savedResource: Location, result: MvcResult, index: Int = -1) {
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
		assertEquals(savedResource.mode, getValue(result, "$prefix.mode"))
		assertEquals(savedResource.status, getValue(result, "$prefix.status"))
		assertEquals(savedResource.operationalStatus, getValue(result, "$prefix.operationalStatus"))
		assertEquals(savedResource.physicalType, getValue(result, "$prefix.physicalType"))
		assertListsEquals(savedResource.telecom, getValue(result, "$prefix.telecom"))
		assertObjectEquals(savedResource.address, getValue(result, "$prefix.address"))
		assertObjectEquals(savedResource.position, getValue(result, "$prefix.position"))
		assertListsEquals(savedResource.hoursOfOperation, getValue(result, "$prefix.hoursOfOperation"))
		assertEquals(savedResource.availabilityExceptions, getValue(result, "$prefix.availabilityExceptions"))
		assertEquals(savedResource.partOf, getValue(result, "$prefix.partOf"))
	}

	private fun createWithRequiredFields(): Location {
	return Location(
				type = null,
				mode = null,
				status = null,
				operationalStatus = null,
				physicalType = null,
				telecom = null,
				address = null,
				position = null,
				hoursOfOperation = null,
				availabilityExceptions = null,
				partOf = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
		}
	}

	private fun createWithAllFields(): Location {
		return Location(
				type = listOf("test_list_string_value"),
				mode = "test_enum_value",
				status = "test_enum_value",
				operationalStatus = "test_enum_value",
				physicalType = "test_enum_value",
				telecom = listOf(ContactPoint(
					header = Element(
					order = 8,
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
				address = Address(
					header = Element(
					order = 8,
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
				),
				position = Position(
					longitude = "test string (was object) value",
					altitude = "test string (was object) value",
					latitude = "test string (was object) value"
				),
				hoursOfOperation = listOf(HoursOfOperation(
					header = Element(
					order = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					daysOfWeek = listOf("test_list_string_value"),
					allDay = false,
					openingTime = "test string (was object) value",
					closingTime = "test string (was object) value"
				)),
				availabilityExceptions = "test string value",
				partOf = "test string value"
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
		}
	}

}
