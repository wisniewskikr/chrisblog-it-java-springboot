package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MvcController {

    @GetMapping
    public String init() {
        return "init";
    }

    @GetMapping("/success")
    public String success(@RequestParam String paymentId, Model model) {
        model.addAttribute("paymentId", paymentId);
        return "success";
    }

    @GetMapping("/cancel")
    public String cancel(@RequestParam String paymentId, Model model) {
        model.addAttribute("paymentId", paymentId);
        return "cancel";
    }

}
