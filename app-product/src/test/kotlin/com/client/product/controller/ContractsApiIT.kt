package com.client.product.controller

import com.client.product.domain.Contract
import com.client.product.domain.Version
import com.client.product.domain.ContractParty
import com.client.product.domain.Element
import com.client.product.domain.Period
import com.client.product.domain.Discount
import com.client.product.domain.Fee
import com.client.product.ProductApplication
import com.client.product.repository.ContractsRepository
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
class ContractsApiIT : AbstractIntegrationTest<Contract>() {

	private val url = "/contracts"

	@Autowired
	lateinit var repository: ContractsRepository

	@Test
	fun `contractsCreateContract with required fields`() {
		val res = createWithRequiredFields()
		val result = super.create(url, res)
		val savedRes = repository.getOne(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractsCreateContract with all fields`() {
		val res = createWithAllFields()
		val result = super.create(url, res)
		val savedRes = repository.getOne(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractsDeleteContract api`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.delete(url, savedRes.id!!)
		savedRes.entity.state = "deleted"
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractsGetContract with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractsGetContract with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractsGetContractList api`() {
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
	fun `contractsModifyContract with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractsUpdateContract with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `contractsUpdateContract with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}


	private fun resourceAsserts(savedResource: Contract, result: MvcResult, index: Int = -1) {
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
		assertEquals(savedResource.type, getValue(result, "$prefix.type"))
		assertListsEquals(savedResource.parties, getValue(result, "$prefix.parties"))
		assertEquals(savedResource.merchant, getValue(result, "$prefix.merchant"))
		assertDateEquals(savedResource.start, getValue(result, "$prefix.start"))
		assertDateEquals(savedResource.end, getValue(result, "$prefix.end"))
		assertListsEquals(savedResource.products, getValue(result, "$prefix.products"))
		assertEquals(savedResource.currency, getValue(result, "$prefix.currency"))
		assertListsEquals(savedResource.discounts, getValue(result, "$prefix.discounts"))
		assertListsEquals(savedResource.fees, getValue(result, "$prefix.fees"))
	}

	private fun createWithRequiredFields(): Contract {
	return Contract(
				version = Version(
					major = 8,
					minor = 8,
					revision = 8,
					label = "test string value"
				),
				type = null,
				parties = null,
				merchant = "b08ad54d-74bc-4115-af27-f0df3f60c425",
				start = Date(),
				end = null,
				products = null,
				currency = "test_enum_value",
				discounts = null,
				fees = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
		}
	}

	private fun createWithAllFields(): Contract {
		return Contract(
				version = Version(
					major = 8,
					minor = 8,
					revision = 8,
					label = "test string value"
				),
				type = "test_enum_value",
				parties = listOf(ContractParty(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					role = null,
					party = "test string value",
					account = "test string value"
				)),
				merchant = "b08ad54d-74bc-4115-af27-f0df3f60c425",
				start = Date(),
				end = Date(),
				products = listOf("test_list_string_value"),
				currency = "test_enum_value",
				discounts = listOf(Discount(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					party = "8ca4bb64-5f06-42e6-9e4f-bb7c18fb2944",
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
					payParty = "a0f206c7-9e9d-4846-ad6b-d969c68d3fcf",
					receiveParty = "b04e5c3a-664b-4c7c-9443-381a611274c6",
					value = 777.toBigDecimal(),
					ratio = "test string (was object) value",
					base = "408dcf65-3cb4-48f1-9516-4a69bf369b24"
				))
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
		}
	}

}
