package com.client.product.controller

import com.client.product.domain.ContractItem
import com.client.product.domain.Version
import com.client.product.domain.Price
import com.client.product.domain.Amount
import com.client.product.domain.Quantity
import com.client.product.domain.Discount
import com.client.product.domain.Element
import com.client.product.domain.Period
import com.client.product.domain.Fee
import com.client.domain.Identity
import com.client.product.ProductApplication
import com.client.product.repository.ContractItemsRepository
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
class ContractItemsApiIT : AbstractIntegrationTest<ContractItem>() {

	private val url = "/contracts/parent-id/contractitems"

	@Autowired
	lateinit var repository: ContractItemsRepository

	@Test
	fun `contractItemsCreateContractItem with required fields`() {
		val res = createWithRequiredFields()
		val result = super.create(url, res)
		val savedRes = repository.getOne(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractItemsCreateContractItem with all fields`() {
		val res = createWithAllFields()
		val result = super.create(url, res)
		val savedRes = repository.getOne(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractItemsDeleteContractItem api`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.delete(url, savedRes.id!!)
		savedRes.entity.state = "deleted"
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractItemsGetContractItem with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractItemsGetContractItem with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractItemsGetContractItemList api`() {
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
	fun `contractItemsModifyContractItem with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractItemsUpdateContractItem with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractItemsUpdateContractItem with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}


	private fun resourceAsserts(savedResource: ContractItem, result: MvcResult, index: Int = -1) {
		val prefix = if (index == -1) "$" else "$.content[$index]"
		if (savedResource.id != null) {
			assertEquals(savedResource.id, getValue(result, "$prefix.identity.id"))
		} else {
			assertNotNull(getValue(result, "$prefix.identity.id"))
		}
		assertEquals(savedResource.identity.name, getValue(result, "$prefix.identity.name"))
		assertEquals(savedResource.identity.description, getValue(result, "$prefix.identity.description"))
		assertEquals(savedResource.entity.state, getValue(result, "$prefix.entity.state"))
		assertObjectEquals(savedResource.version, getValue(result, "$prefix.version"))
		assertDateEquals(savedResource.start, getValue(result, "$prefix.start"))
		assertDateEquals(savedResource.end, getValue(result, "$prefix.end"))
		assertEquals(savedResource.product, getValue(result, "$prefix.product"))
		assertObjectEquals(savedResource.price, getValue(result, "$prefix.price"))
		assertListsEquals(savedResource.discounts, getValue(result, "$prefix.discounts"))
		assertListsEquals(savedResource.fees, getValue(result, "$prefix.fees"))
	}

	private fun createWithRequiredFields(): ContractItem {
	return ContractItem(
				version = Version(
					major = 8,
					minor = 8,
					revision = 8,
					label = "test string value"
				),
				start = Date(),
				end = null,
				product = "test string value",
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
				discounts = null,
				fees = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
			this.entity.parent = Identity(id = "parent-id")
		}
	}

	private fun createWithAllFields(): ContractItem {
		return ContractItem(
				version = Version(
					major = 8,
					minor = 8,
					revision = 8,
					label = "test string value"
				),
				start = Date(),
				end = Date(),
				product = "test string value",
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
				discounts = listOf(Discount(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					party = "f8156a0a-bfd3-478d-8803-60e9eaf2faad",
					value = 777.toBigDecimal(),
					ratio = "test string (was object) value"
				)),
				fees = listOf(Fee(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					payParty = "dc4fe015-3b14-424b-8b95-6f6194059ae6",
					receiveParty = "4d7ff0cc-0dd8-4247-9f07-6bef76691852",
					value = 777.toBigDecimal(),
					ratio = "test string (was object) value",
					base = "3bd16a97-3b7a-4aa3-a27d-616fb5383e9f"
				))
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
			this.entity.parent = Identity(id = "parent-id")
		}
	}

}
