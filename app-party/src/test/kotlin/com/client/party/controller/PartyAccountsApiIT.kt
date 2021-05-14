package com.client.party.controller

import com.client.party.domain.Account
import com.client.party.domain.PaymentInstrument
import com.client.party.domain.Element
import com.client.party.domain.Period
import com.client.party.domain.PaymentInstrumentSpec
import com.client.party.domain.BankSpec
import com.client.domain.Identity
import com.client.party.PartyApplication
import com.client.party.repository.PartyAccountsRepository
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
@SpringBootTest(classes = [PartyApplication::class])
@AutoConfigureMockMvc
class PartyAccountsApiIT : AbstractIntegrationTest<Account>() {

	private val url = "/parties/parent-id/accounts"

	@Autowired
	lateinit var repository: PartyAccountsRepository

	@Test
	fun `partyAccountsCreateAccount with required fields`() {
		val res = createWithRequiredFields()
		val result = super.create(url, res)
		val savedRes = repository.getOne(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsCreateAccount with all fields`() {
		val res = createWithAllFields()
		val result = super.create(url, res)
		val savedRes = repository.getOne(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsDeleteAccount api`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.delete(url, savedRes.id!!)
		savedRes.entity.state = "deleted"
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsGetAccount with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsGetAccount with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsGetAccountList api`() {
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
	fun `partyAccountsModifyAccount with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsUpdateAccount with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsUpdateAccount with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}


	private fun resourceAsserts(savedResource: Account, result: MvcResult, index: Int = -1) {
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
		assertEquals(savedResource.legalEntity, getValue(result, "$prefix.legalEntity"))
		assertEquals(savedResource.country, getValue(result, "$prefix.country"))
		assertEquals(savedResource.accountNumber, getValue(result, "$prefix.accountNumber"))
		assertListsEquals(savedResource.paymentInstruments, getValue(result, "$prefix.paymentInstruments"))
	}

	private fun createWithRequiredFields(): Account {
	return Account(
				type = "test_enum_value",
				legalEntity = "test string value",
				country = null,
				accountNumber = null,
				paymentInstruments = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
			this.entity.parent = Identity(id = "parent-id")
		}
	}

	private fun createWithAllFields(): Account {
		return Account(
				type = "test_enum_value",
				legalEntity = "test string value",
				country = "test_enum_value",
				accountNumber = "test string value",
				paymentInstruments = listOf(PaymentInstrument(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					type = "test_enum_value",
					spec = PaymentInstrumentSpec(
					bank = BankSpec(
					accountNumber = "test string valu",
					routingNumber = "test string valu"
				)
				)
				))
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
			this.entity.parent = Identity(id = "parent-id")
		}
	}

}
