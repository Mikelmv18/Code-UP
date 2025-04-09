package com.platform.code_up.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "achievements")
@Data
@NoArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String name;

    private String icon;

    @ManyToMany(mappedBy = "achievements")
    private List<User> users;
}
