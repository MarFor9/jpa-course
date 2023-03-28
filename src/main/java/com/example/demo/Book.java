package com.example.demo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "Book")
@Table(name = "book")
public class Book {

    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    @Id
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "book_name", nullable = false, columnDefinition = "TEXT")
    private String bookName;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "student_id_fk")
    )
    private Student student;

    public Book() {
    }

    public Book(String bookName, LocalDateTime createdAt) {
        this.bookName = bookName;
        this.createdAt = createdAt;
    }

    public Book(String bookName, LocalDateTime createdAt, Student student) {
        this.bookName = bookName;
        this.createdAt = createdAt;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Student getStudent() {
        return student;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
