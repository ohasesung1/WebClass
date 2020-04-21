package kr.hs.dgsw.webclass01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Calculator {

  @GetMapping("/param_calculator")
  public int paramCalculator(@RequestParam final int num1, @RequestParam final int num2, @RequestParam final String operator) {
    int result = 0;
    switch (operator) {
      case "+":
        result = num1 + num2;
        break;
      case "-":
        result = num1 - num2;
        break;
      case "*":
        result = num1 * num2;
        break;
      case "/":
        result = num1 / num2;
        break;
      default:
        break;
    }
    return result;
  }

  @GetMapping("/path_variable_calculator/{num1}/{num2}/{operator}")
  public int pathVariableCalculator(@PathVariable final int num1, @PathVariable final int num2, @PathVariable final String operator) {
    int result = 0;
    switch (operator) {
      case "+":
        result = num1 + num2;
        break;
      case "-":
        result = num1 - num2;
        break;
      case "*":
        result = num1 * num2;
        break;
      case "/":
        result = num1 / num2;
        break;
      default:
        break;
    }
    return result;
  }
}