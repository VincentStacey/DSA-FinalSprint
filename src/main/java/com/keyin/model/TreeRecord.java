package com.keyin.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TreeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String inputNumbers;

    @Lob
    private String treeJson;

    private LocalDateTime createdAt;

    public TreeRecord() {
        this.createdAt = LocalDateTime.now();
    }

    public TreeRecord(String inputNumbers, String treeJson) {
        this.inputNumbers = inputNumbers;
        this.treeJson = treeJson;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getTreeJson() {
        return treeJson;
    }

    public void setTreeJson(String treeJson) {
        this.treeJson = treeJson;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

