package com.vicen.films.framework.presentation.rest;

import com.vicen.films.application.commands.CreateStaffMemberCommand;
import com.vicen.films.application.queries.GetStaffMemberQuery;
import com.vicen.films.application.queries.GetStaffQuery;
import com.vicen.films.application.service.StaffService;
import com.vicen.films.framework.presentation.rest.dto.StaffListDto;
import com.vicen.films.framework.presentation.rest.dto.StaffMemberDtoIn;
import com.vicen.films.framework.presentation.rest.dto.StaffMemberDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/staff")
public class StaffController extends BaseController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffListDto getStaff() {
        return StaffListDto.of(staffService.getStaff(new GetStaffQuery()));
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffMemberDtoOut getStaffMember(@PathVariable("uuid") String uuid) {
        return StaffMemberDtoOut.of(staffService.getStaffMember(new GetStaffMemberQuery(UUID.fromString(uuid))));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffMemberDtoOut createStaffMember(@RequestBody StaffMemberDtoIn request) {
        CreateStaffMemberCommand command = new CreateStaffMemberCommand(
                request.getName(),
                request.getLastName(),
                LocalDate.parse(request.getBirthDate()));
        return StaffMemberDtoOut.of(staffService.createStaffMember(command));
    }

}
