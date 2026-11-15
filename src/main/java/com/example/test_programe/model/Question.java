package com.example.test_programe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "questions")
public class Question {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_test", nullable = false)
    private Test test;

    public Question() {}

    public Question(
        String text, 
        Test test
    ) {
        this.text = text;
        this.test = test;
    }

    

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String gettext() {
        return text;
    }
    public void setQ_text(String text) {
        this.text = text;
    }

    public Test getTest() {
        return test;
    }
    public void setTest(Test test) {
        this.test = test;
    }
}
