package com.platform.code_up.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "milestones")
@Data
@NoArgsConstructor
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String type;

    private String icon;

    @ManyToMany(mappedBy = "milestones")
    private List<User> users;
}
