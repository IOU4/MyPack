package mypack.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity(name = "driver")
public class Driver extends Employee {

  @OneToOne
  private Car car;

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

}
