/*
 * @copyright defined in LICENSE.txt
 */

package acktsap.sample.validator;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validator: 애플리케이션에서 사용하는 객체 검증용 인터페이스
 */
@Component
public class ValidatorRunner implements ApplicationRunner {

  @Autowired
  Validator validator;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Event event = new Event();
    event.limit = -1;

    // custom
    EventValidator eventValidator = new EventValidator();
    Errors errors = new BeanPropertyBindingResult(event, "event");

    eventValidator.validate(event, errors);

    System.out.println(errors.hasErrors());
    errors.getAllErrors().forEach(e -> {
      System.out.println("===== error code ======");
      Arrays.stream(e.getCodes()).forEach(System.out::println);
      System.out.println(e.getDefaultMessage());
    });

    // spring boot autowired
    System.out.println("Default validator: " + validator.getClass());
    Errors errors2 = new BeanPropertyBindingResult(event, "event");

    validator.validate(event, errors2);

    System.out.println(errors2.hasErrors());
    errors2.getAllErrors().forEach(e -> {
      System.out.println("===== error code ======");
      Arrays.stream(e.getCodes()).forEach(System.out::println);
      System.out.println(e.getDefaultMessage());
    });
  }

}