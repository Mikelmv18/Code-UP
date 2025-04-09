package com.platform.code_up.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "subscriptions")
@Data
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date startTime;

    private Date endTime;

    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
