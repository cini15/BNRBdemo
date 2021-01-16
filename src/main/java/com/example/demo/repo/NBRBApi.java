package com.example.demo.repo;

import com.example.demo.entity.Rate;
import com.example.demo.entity.RateShort;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class NBRBApi {
    private final String URL_API_RATES_DYNAMICS="https://www.nbrb.by/api/exrates/rates/dynamics/";
    private final String URL_API_RATES="https://www.nbrb.by/api/exrates/rates?periodicity=0";

    public List<Rate> getAllRates() throws IOException {
        List<Rate> rates;
        ObjectMapper objectMapper= new ObjectMapper();
        rates=objectMapper.readValue(new URL(URL_API_RATES), new TypeReference<List<Rate>>() {});

        return rates;
    }
    public List<RateShort> getRatebyIdAndDate(int id, LocalDate start, LocalDate end) throws IOException {
        List<RateShort> rates;

        ObjectMapper objectMapper= new ObjectMapper();
        String url=URL_API_RATES_DYNAMICS+id+"?startdate="+start.toString()+"&endDate="+end.toString();
        rates=objectMapper.readValue(new URL(url), new TypeReference<List<RateShort>>() {});

        return rates;
    }

}
