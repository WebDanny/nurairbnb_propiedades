package com.danny.checkinapi.controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import use.cases.command.checkin.assign.propiedad.AssignPropiedadCommand;
import use.cases.command.checkin.create.checkin.CreateCheckInCommand;
import use.cases.command.checkin.get.checkin.GetCheckInQuery;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CheckInController {

  Logger logger = LoggerFactory.getLogger(CheckInController.class);
  final Pipeline pipeline;

  public CheckInController(Pipeline pipeline) {
    this.pipeline = pipeline;
  }

  @PostMapping("/assign-propiedad")
  public PropiedadDto assignPropiedad(@RequestBody CheckInDto checkInDto) {
    AssignPropiedadCommand assignSeatCommand = new AssignPropiedadCommand(checkInDto);
    return assignSeatCommand.execute(pipeline);
  }

  @PostMapping("/create-checkin")
  public CheckInDto createCheckIn(@RequestBody CheckInDto checkInDto) {
    CreateCheckInCommand createCheckInCommand = new CreateCheckInCommand(checkInDto);
    return createCheckInCommand.execute(pipeline);
  }

  @GetMapping("/checkIn/{checkInId}/{personaId}")
  public CheckInDto getCheckIn(@PathVariable String checkInId, @PathVariable String passengerId) {
    GetCheckInQuery query = new GetCheckInQuery(checkInId, passengerId);
    return query.execute(pipeline);
  }
}
