package ru.zalex.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/calc")
public class CalcController {

    @GetMapping("/calc")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        double result;
        switch (action) {
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / (double) b;
                break;
            case "plus":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            default:
                result = 0;
        }

        model.addAttribute("result", " " + a + action + b + " = " + result);

        return "calc/calc";
    }
}
