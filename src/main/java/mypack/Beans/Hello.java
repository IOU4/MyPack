package mypack.Beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import mypack.Config.Config;

@Named(value = "hello")
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
    var em = Config.getInstance().getEm();
    em.getTransaction().begin();
    var query = em.createNativeQuery("select * from test");
    var res = query.getResultList();
    res.forEach(r -> System.out.println(r));
    em.getTransaction().commit();
    em.close();
    message = String.format("Who are you %s?", name);
  }

}
