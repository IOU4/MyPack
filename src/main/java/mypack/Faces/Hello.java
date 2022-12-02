package mypack.Faces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named(value = "ttrr")
@RequestScoped
public class Hello {

  private String name;
  private String message;
  private int age;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void createMessage() {
    message = "Hello, " + name + "!";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMessage() {
    return message;
  }

  public void formatMessage() {
    message = String.format("Who are you %s?", name);
  }

}
