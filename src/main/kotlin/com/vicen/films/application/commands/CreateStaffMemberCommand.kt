package com.vicen.films.application.commands;

import java.time.LocalDate

class CreateStaffMemberCommand(val name: String, val lastName: String, val birthDate: LocalDate) : Command
