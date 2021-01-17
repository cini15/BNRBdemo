package com.example.demo.service;

import com.example.demo.entity.RateShort;
import com.example.demo.repo.NBRBApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NBRBServiceTest {
    NBRBService service;

    @BeforeEach
    void init(){
        service= new NBRBService(new NBRBApi());

    }

    @Test
    void getRatesList() {
        service.getRatesList();
    }

    @Test
    void getRatesShort() {
        String start = "2020-11-03";
        String end = "2020-12-20";
        service.getRatesShort(290, start, end);
    }
}