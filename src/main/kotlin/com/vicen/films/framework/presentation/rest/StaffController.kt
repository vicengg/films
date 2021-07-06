package com.vicen.films.framework.presentation.rest

import com.vicen.films.application.commands.CreateStaffMemberCommand
import com.vicen.films.application.queries.GetStaffMemberQuery
import com.vicen.films.application.service.StaffService
import com.vicen.films.framework.presentation.rest.dto.StaffListDto
import com.vicen.films.framework.presentation.rest.dto.StaffMemberDtoIn
import com.vicen.films.framework.presentation.rest.dto.StaffMemberDtoOut
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.util.*

@RestController
@RequestMapping("/staff")
class StaffController(val staffService: StaffService) : BaseController() {

    @RequestMapping(method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getStaff(): StaffListDto {
        return StaffListDto.of(staffService.getStaff())
    }

    @RequestMapping(value = ["/{uuid}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getStaffMember(@PathVariable("uuid") uuid: String): StaffMemberDtoOut {
        return StaffMemberDtoOut(staffService.getStaffMember(GetStaffMemberQuery(UUID.fromString(uuid))))
    }

    @RequestMapping(method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createStaffMember(@RequestBody request: StaffMemberDtoIn): StaffMemberDtoOut {
        val command = CreateStaffMemberCommand(
                request.name ?: throwMandatoryFieldError("name"),
                request.lastName ?: throwMandatoryFieldError("lastName"),
                request.birthDate?.let { LocalDate.parse(request.birthDate) } ?: throwMandatoryFieldError("birthDate"))
        return StaffMemberDtoOut(staffService.createStaffMember(command))
    }

}