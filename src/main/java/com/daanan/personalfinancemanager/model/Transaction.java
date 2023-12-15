package com.daanan.personalfinancemanager.model;

import com.daanan.personalfinancemanager.util.TransactionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "transaction")
public class Transaction {

    // FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "description")
    private String description;

    // CONSTRUCTORS

    public Transaction( ) {

    }

    // GETTERS AND SETTERS


    public Long getTransactionId( ) {

        return transactionId;
    }

    public void setTransactionId(Long transactionId) {

        this.transactionId = transactionId;
    }

    public User getUser( ) {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public BigDecimal getAmount( ) {

        return amount;
    }

    public void setAmount(BigDecimal amount) {

        this.amount = amount;
    }

    public TransactionType getType( ) {

        return type;
    }

    public void setType(TransactionType type) {

        this.type = type;
    }

    public Category getCategory( ) {

        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }

    public LocalDateTime getDate( ) {

        return date;
    }

    public void setDate(LocalDateTime date) {

        this.date = date;
    }

    public String getDescription( ) {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }
}
