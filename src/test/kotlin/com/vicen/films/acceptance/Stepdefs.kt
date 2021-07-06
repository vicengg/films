package com.vicen.films.acceptance

import com.fasterxml.jackson.databind.ObjectMapper
import com.vicen.films.framework.presentation.rest.dto.StaffMemberDtoIn
import com.vicen.films.framework.presentation.rest.dto.StaffMemberDtoOut
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.apache.commons.io.IOUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.util.*

class Stepdefs {

    private val urlBase = "http://localhost:8080"
    private val staffResource = "/staff"
    private val objectMapper = ObjectMapper()
    private val restTemplate = RestTemplate()

    private var staffMemberIn: StaffMemberDtoIn? = null
    private var staffMemberResponse: ResponseEntity<StaffMemberDtoOut>? = null

    @Given("^the staff member JSON model (\\d{1})$")
    @Throws(IOException::class)
    fun loadStaffMemberModel(modelNumber: Int) {
        val json = loadJson(JsonModels.STAFF_MEMBER.getFilePath(modelNumber))
        staffMemberIn = objectMapper.readerFor(StaffMemberDtoIn::class.java).readValue<StaffMemberDtoIn>(json)
    }

    @When("^the staff member is sent to create$")
    @Throws(IOException::class)
    fun sendStaffMemberModel() {
        staffMemberResponse = restTemplate.postForEntity(urlBase + staffResource, staffMemberIn, StaffMemberDtoOut::class.java)
    }

    @Then("^the staff member is created$")
    @Throws(IOException::class)
    fun checkStaffMemberIsCreated() {
        assertEquals(200, staffMemberResponse?.statusCodeValue)
        assertNotNull(staffMemberResponse?.body)
        assertNotNull(UUID.fromString(staffMemberResponse?.body?.id))
    }

    @Throws(IOException::class)
    private fun loadJson(filePath: String): String {
        val inputStream = this.javaClass.getResourceAsStream(filePath)
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8.name())
    }


}

