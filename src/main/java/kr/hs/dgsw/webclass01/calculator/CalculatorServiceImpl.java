package kr.hs.dgsw.webclass01.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
  @Override
  public int calculator(String num1, String num2, String sign) {
     int result = 0;

     int number1 = Integer.parseInt(num1);
     int number2 = Integer.parseInt(num2);

     if (num1 == null || num2 == null) {
        return 0;
     }

     switch (sign) {
       case "plus":
          result  = number1 + number2;
         break;
       case "minus":
          result  = number1 - number2;
        break;
       case "multi":
          result  = number1 * number2;
        break;
       case "divide":
          if (number2 == 0) {
            result = 0;
          } else {
            result  = number1 / number2;
          }

         break;
     }

     return result;
  }
}