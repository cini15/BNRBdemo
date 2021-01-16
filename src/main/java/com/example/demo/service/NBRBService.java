package com.example.demo.service;

import com.example.demo.entity.Rate;
import com.example.demo.entity.RateShort;
import com.example.demo.repo.NBRBApi;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NBRBService {
    private NBRBApi api;

    public NBRBService(NBRBApi api) {
        this.api = api;
    }

    public List<Rate> getRatesList(){
        List<Rate> rates;
        try {
            rates= api.getAllRates();
        } catch (IOException e) {
            e.printStackTrace();
            rates=new ArrayList<>();
        }
        return rates;
    }
    @Validated
    public List<RateShort> getRatesShort(int id, String  start,String  end){
        List<RateShort> rateShorts;
        LocalDate startDate= LocalDate.parse(start);
        LocalDate endDate=LocalDate.parse(end);
        System.out.println("start " + start+ " end "+ end);
        List<RateShort> rates=new ArrayList<>();
        if(endDate.minusDays(365).isAfter(startDate)){
            rates=getRatesShort(id,startDate.plusDays(365).toString(),endDate.toString());
        }
        System.out.println(LocalDate.ofEpochDay(startDate.toEpochDay()));
        System.out.println(startDate.toEpochDay());
        try {
            rateShorts=api.getRatebyIdAndDate(id,startDate,endDate);
        } catch (IOException e) {
            e.printStackTrace();
            rateShorts=new ArrayList<>();
        }
        rateShorts.addAll(rates);
        return rateShorts;
    }

}
