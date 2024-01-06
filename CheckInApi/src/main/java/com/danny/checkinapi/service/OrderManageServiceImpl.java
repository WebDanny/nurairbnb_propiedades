package com.danny.checkinapi.service;

import com.nur.model.Reserve;
import com.nur.model.StatusReserve;
import com.nur.repositories.PropiedadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderManageServiceImpl {

  private static final String SOURCE = "propiedades";
  private static final Logger LOG = LoggerFactory.getLogger(OrderManageServiceImpl.class);
  // private PropiedadCrudRepository repository;
  private KafkaTemplate<Long, Reserve> template;
  private final PropiedadRepository propiedadRepository;

  public OrderManageServiceImpl(
      KafkaTemplate<Long, Reserve> template, PropiedadRepository propiedadRepository) {
    this.template = template;
    this.propiedadRepository = propiedadRepository;
  }

  public void reserve(Reserve order) {

    propiedadRepository.update(order.getPropiedad());
    // template.send("propiedades-reserve", 1L, order);
    order.setStatus(StatusReserve.RECEIVED);

    System.out.println("RESERVA ACEPTADA O RECHAZADA");
    LOG.info("Sent: {}", order);
  }

  public void confirm(Reserve order) {

    System.out.println("RESERVA CONFIRMADA:  " + order.getStatus().name());

    order.setStatus(StatusReserve.FINALIZED);

    /*Customer customer = repository.findById(order.getCustomerId()).orElseThrow();
    LOG.info("Found: {}", customer);
    if (order.getStatus().equals("CONFIRMED")) {
        customer.setAmountReserved(customer.getAmountReserved() - order.getPrice());
        repository.save(customer);
    } else if (order.getStatus().equals("ROLLBACK") && !order.getSource().equals(SOURCE)) {
        customer.setAmountReserved(customer.getAmountReserved() - order.getPrice());
        customer.setAmountAvailable(customer.getAmountAvailable() + order.getPrice());
        repository.save(customer);
    }*

     */

    // System.out.println("CONFIRMADO LA RESERVA:  " + order.getStatus().name());

  }
}
