package com.example.demo.controller;

import com.example.demo.entity.Rate;
import com.example.demo.entity.RateShort;
import com.example.demo.service.NBRBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller()
@RequestMapping("/api")
public class MainController {
    private final NBRBService service;

    public MainController(NBRBService service) {
        this.service = service;
    }

    @GetMapping
    public String getDemo(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String start,
            @RequestParam(required = false)  String end,
            Model model
            ) {
        LocalDate now=LocalDate.now();
        if (start == null)
            start = now.minusWeeks(1).toString();
        if (end == null)
            end = now.toString();
        List<Rate> ratesList = service.getRatesList();
        if (id == null)
            id = ratesList.get(1).getId();

        LocalDate startDate= LocalDate.parse(start);
        LocalDate endDate=LocalDate.parse(end);
        if(endDate.isAfter(now)) {
            end = now.toString();
            endDate=now;
        }
        if(startDate.isAfter(endDate) | startDate.isEqual(endDate)) {
            start = endDate.minusDays(3).toString();
        }
        List<RateShort> ratesShort = service.getRatesShort(id, start, end);
        model.addAttribute("currency", ratesList);
        model.addAttribute("start", start);
        model.addAttribute("now", now.toString());
        model.addAttribute("end", end);
        model.addAttribute("ratesShort", ratesShort.toArray());
        model.addAttribute("id", id);
        return "api";
    }

}
