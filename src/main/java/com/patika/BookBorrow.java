package com.patika;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book_borrows")
public class BookBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_borrow_id" , columnDefinition = "serial")
    private Long id;

    @Column(name = "book_borrow_name" , nullable = false)
    private String borrowerName;

    @Column(name = "book_borrow_date" )
    private LocalDate borrowingDate;

    @Column(name = "book_borrow_return")
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_borrow_book_id" , referencedColumnName = "book_id" )
    private Book book;

    public BookBorrow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
