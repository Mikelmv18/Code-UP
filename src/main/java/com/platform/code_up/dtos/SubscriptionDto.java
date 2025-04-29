package com.platform.code_up.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDto {

    private Date startTime;
    private Date endTime;
    private String paymentStatus;
    private Integer userId;
}
