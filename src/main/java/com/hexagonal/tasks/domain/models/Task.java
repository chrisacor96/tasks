package com.hexagonal.tasks.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;


}
