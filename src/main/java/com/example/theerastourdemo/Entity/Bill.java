package com.example.theerastourdemo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name ="total_tickets")
    private int totalTickets;
    @Column(name="total_price")
    private double totalPrice;
    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name ="user_id")
    private Member userId;
    @Column(name ="status")
    private Boolean status;
    @OneToMany(mappedBy = "billId" ,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Ticket> tickets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Member getUserId() {
        return userId;
    }

    public void setUserId(Member userId) {
        this.userId = userId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
