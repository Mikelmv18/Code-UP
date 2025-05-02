package com.platform.code_up.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lessons")
@Data
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private String contentType;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Integer lesson_order;

    private Integer unit_number;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Lesson(String title, String content, String contentType, int lessonOrder, int unitNumber, Course course) {
        this.title = title;
        this.content = content;
        this.contentType = contentType;
        this.lesson_order = lessonOrder;
        this.unit_number = unitNumber;
        this.course = course;
    }

}
