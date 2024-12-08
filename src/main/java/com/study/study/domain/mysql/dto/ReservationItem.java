package com.study.study.domain.mysql.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationItem {


    private LocalDate date;
    private String content;

}
