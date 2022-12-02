package mypack.Faces;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

  public String greetingTemplate(String lang) {
    String template = "Hello, %s!";
    if (lang == null)
      return template;
    switch (lang) {
      case "fr":
        template = "Bonjour, %s!";
        break;
      case "de":
        template = "Hallo, %s!";
        break;
    }
    return template;
  }
}
