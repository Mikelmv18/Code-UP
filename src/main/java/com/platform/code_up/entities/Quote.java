package com.platform.code_up.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "quotes")
@Data
@NoArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String quote;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
