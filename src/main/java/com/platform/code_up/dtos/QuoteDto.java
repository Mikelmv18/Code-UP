package com.platform.code_up.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDto {

    private String quote;
    private Date date;
    private Integer userId;
}
