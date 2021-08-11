package com.main.mongopoc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "statusHistory")
public class StatusHistory {

    @Id
    private String id;
    private String name;
    private LocalDate date;
    private LocalDateTime dateTime;

    public StatusHistory(String id, String name, LocalDate date, LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.dateTime = dateTime;
    }

    public StatusHistory() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
