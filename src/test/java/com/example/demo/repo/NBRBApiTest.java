package com.example.demo.repo;

import com.example.demo.entity.Rate;
import com.example.demo.entity.RateShort;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NBRBApiTest {

    @Test
    void getAllRates() throws IOException {
        NBRBApi api= new NBRBApi();
        List<Rate> ratebyIdAndDate = api.getAllRates();
        for (Rate r : ratebyIdAndDate){
            System.out.println(r);

        }
    }

    @Test
    void getRatesById() throws IOException {
        NBRBApi api= new NBRBApi();
        LocalDate start= LocalDate.parse("2020-12-01");
        LocalDate end= LocalDate.parse("2020-12-20");
        start.format(DateTimeFormatter.BASIC_ISO_DATE);
        List<RateShort> ratebyIdAndDate = api.getRatebyIdAndDate(290,start,end);
        for (RateShort r : ratebyIdAndDate){
            System.out.println(r);
        }

    }
}