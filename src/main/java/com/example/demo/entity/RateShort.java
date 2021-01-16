package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RateShort extends Rate {

    @JsonProperty("Date")
    private LocalDate date;
    @JsonProperty("Cur_OfficialRate")
    private Float rate;

    public void setDate(String date) {
        this.date = LocalDateTime.parse(date).toLocalDate();
    }
}
