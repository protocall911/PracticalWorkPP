package com.example.PracticalWorkPP;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String calculator() {
        return "Calculator";
    }

    @GetMapping("/calculator")
    public String calculatorGet(@RequestParam(name = "value1", required = false, defaultValue = "0") double value1,
                                @RequestParam(name = "value2", required = false, defaultValue = "0") double value2,
                                @RequestParam(name = "operation", required = false) String operation, Model model) {

        double result = switch (operation) {
            case "+" -> value1 + value2;
            case "-" -> value1 - value2;
            case "*" -> value1 * value2;
            case "/" -> value1 / value2;
            default -> 0;
        };
        model.addAttribute("result",result);
        return "Calculator";
    }
    @PostMapping("/calculator")
    public String calculatorPost(@RequestParam(name = "value1") double value1,
                                 @RequestParam(name = "value2") double value2,
                                 @RequestParam(name = "operation") String operation, Model model) {
        double result = switch (operation) {
            case "+" -> value1 + value2;
            case "-" -> value1 - value2;
            case "*" -> value1 * value2;
            case "/" -> value1 / value2;
            default -> 0;
        };
        model.addAttribute("result",result);
        return "Calculator";
    }
}
