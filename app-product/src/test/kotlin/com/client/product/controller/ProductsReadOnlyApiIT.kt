package com.client.product.controller

import com.client.product.domain.Product
import com.client.product.domain.ReferenceIdentity
import com.client.product.domain.ProductSKU
import com.client.product.domain.Property
import com.client.product.domain.ProductRef
import com.client.product.domain.Element
import com.client.product.domain.Period
import com.client.product.domain.Discount
import com.client.product.domain.Attachment
import com.client.product.domain.ContactPoint
import com.client.product.domain.CommunicationLanguage
import com.client.product.domain.AvailableTime
import com.client.product.domain.NotAvailableTime
import com.client.product.domain.Price
import com.client.product.domain.Amount
import com.client.product.domain.Quantity
import com.client.product.ProductApplication
import com.client.product.repository.ProductsReadOnlyRepository
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
@SpringBootTest(classes = [ProductApplication::class])
@AutoConfigureMockMvc
class ProductsReadOnlyApiIT : AbstractIntegrationTest<Product>() {

	private val url = "/products"

	@Autowired
	lateinit var repository: ProductsReadOnlyRepository

	@Test
	fun `productsReadOnlyGetProduct with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `productsReadOnlyGetProduct with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `productsReadOnlyGetProductList api`() {
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


	private fun resourceAsserts(savedResource: Product, result: MvcResult, index: Int = -1) {
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
		assertEquals(savedResource.category, getValue(result, "$prefix.category"))
		assertObjectEquals(savedResource.reference, getValue(result, "$prefix.reference"))
		assertEquals(savedResource.service, getValue(result, "$prefix.service"))
		assertObjectEquals(savedResource.sku, getValue(result, "$prefix.sku"))
		assertListsEquals(savedResource.products, getValue(result, "$prefix.products"))
		assertObjectEquals(savedResource.photo, getValue(result, "$prefix.photo"))
		assertListsEquals(savedResource.telecom, getValue(result, "$prefix.telecom"))
		assertListsEquals(savedResource.communication, getValue(result, "$prefix.communication"))
		assertEquals(savedResource.location, getValue(result, "$prefix.location"))
		assertListsEquals(savedResource.coverageArea, getValue(result, "$prefix.coverageArea"))
		assertEquals(savedResource.appointmentRequired, getValue(result, "$prefix.appointmentRequired"))
		assertListsEquals(savedResource.availableTime, getValue(result, "$prefix.availableTime"))
		assertListsEquals(savedResource.notAvailable, getValue(result, "$prefix.notAvailable"))
		assertEquals(savedResource.availabilityExceptions, getValue(result, "$prefix.availabilityExceptions"))
		assertObjectEquals(savedResource.price, getValue(result, "$prefix.price"))
		assertEquals(savedResource.partyId, getValue(result, "$prefix.partyId"))
		assertEquals(savedResource.critical, getValue(result, "$prefix.critical"))
		assertEquals(savedResource.rank, getValue(result, "$prefix.rank") as Int?)
		assertEquals(savedResource.estimation, getValue(result, "$prefix.estimation"))
	}

	private fun createWithRequiredFields(): Product {
	return Product(
				type = null,
				category = null,
				reference = null,
				service = null,
				sku = ProductSKU(
					barCode = "test string valu",
					product = "test string value",
					properties = listOf(Property(
					type = "test_enum_value",
					reference = "test string value",
					value = "test string value"
				)),
					start = Date(),
					end = Date()
				),
				products = null,
				photo = null,
				telecom = null,
				communication = null,
				location = null,
				coverageArea = null,
				appointmentRequired = null,
				availableTime = null,
				notAvailable = null,
				availabilityExceptions = null,
				price = null,
				partyId = null,
				critical = null,
				rank = null,
				estimation = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
		}
	}

	private fun createWithAllFields(): Product {
		return Product(
				type = "test_enum_value",
				category = "654b9da1-660b-448d-97c3-a678d505d213",
				reference = ReferenceIdentity(
					resourceId = "test string value",
					name = "test string value",
					description = "test string value",
					type = "test string value",
					uri = "test string value"
				),
				service = "test string value",
				sku = ProductSKU(
					barCode = "test string valu",
					product = "test string value",
					properties = listOf(Property(
					type = "test_enum_value",
					reference = "test string value",
					value = "test string value"
				)),
					start = Date(),
					end = Date()
				),
				products = listOf(ProductRef(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					product = "test string value",
					properties = Property(
					type = "test_enum_value",
					reference = "test string value",
					value = "test string value"
				),
					discount = Discount(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					party = "4d113be8-8622-4076-a2f8-11aa207c0ba5",
					value = 777.toBigDecimal(),
					ratio = "test string (was object) value"
				)
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
				),
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
					use = "test_enum_value"
				)),
				communication = listOf(CommunicationLanguage(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					language = "test_enum_value"
				)),
				location = "test string value",
				coverageArea = listOf("test_list_string_value"),
				appointmentRequired = false,
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
				price = Price(
					amount = Amount(
					amount = 777.toBigDecimal(),
					currency = "test_enum_value"
				),
					quantity = Quantity(
					value = 777.toBigDecimal(),
					comparator = "test_enum_value",
					unit = "test string value",
					system = "test string value",
					code = "test string valu",
				)
				),
				partyId = "9ba79fe8-a5f2-4db0-9077-9c6351d48f1e",
				critical = false,
				rank = 8,
				estimation = "test string value"
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
		}
	}

}
