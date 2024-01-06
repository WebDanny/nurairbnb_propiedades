package com.nur.event;

import com.nur.model.CheckIn;
import core.DomainEvent;

public class CheckInCompleted extends DomainEvent {

  private CheckIn checkIn;

  public CheckInCompleted(CheckIn checkIn) {
    super(checkIn.getDate());
    this.checkIn = checkIn;
  }

  public CheckIn getCheckIn() {
    return checkIn;
  }
}
