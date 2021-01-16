package com.example.demo.service;

import com.example.demo.repo.NBRBApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        service.getRatesShort(290,"2020-12-1","2020-12-20");
    }
}