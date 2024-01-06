package com.danny.checkinapi.controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.PropiedadDto;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import use.cases.command.propiedades.create.CreatePropiedadCommand;
import use.cases.command.propiedades.get.GetPropiedadQuery;
import use.cases.command.propiedades.list.GetPropiedadesQuery;

@CrossOrigin(origins = "*")
@RestController
public class PropiedadController {

  Logger logger = LoggerFactory.getLogger(PropiedadController.class);
  final Pipeline pipeline;

  public PropiedadController(Pipeline pipeline) {
    this.pipeline = pipeline;
  }

  @GetMapping("/propiedad/{propId}")
  public List<PropiedadDto> getPropiedad(@PathVariable String propId) {
    GetPropiedadQuery query = new GetPropiedadQuery(propId);
    return query.execute(pipeline);
  }

  @GetMapping("/propiedades")
  public List<PropiedadDto> getListAllPropiedades() {
    GetPropiedadesQuery query = new GetPropiedadesQuery();
    return query.execute(pipeline);
  }

  @PostMapping("/create-propiedad")
  public PropiedadDto createPropiedad(@RequestBody PropiedadDto propiedad) {

    CreatePropiedadCommand command = new CreatePropiedadCommand(propiedad);
    return command.execute(pipeline);
  }
}
