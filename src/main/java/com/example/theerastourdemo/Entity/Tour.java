package com.example.theerastourdemo.Entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
//    @Column(name = "location_id")
//    private String locationId;
    @Column(name = "tour_date")
    private LocalDate tourDate;
    @Column(name = "tour_time")
    private LocalDateTime tourDateTime;
    @Column(name = "tour_timestamp")
    private Instant tourTimestamp;
    @Column(name = "total_tickets")
    private int totalTickets;
    @Column(name = "sold_tickets")
    private int soldTickets;
    @Column(name = "description")
    private String description;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="tour_id")
    private List<Ticket> tickets;

    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="location_id")
    private Location locationId;

    public Tour() {
    }

    public Tour(String name, String type, String locationId, LocalDate tourDate, LocalDateTime tourDateTime, Instant tourTimestamp, int totalTickets) {
        this.name = name;
        this.type = type;
        this.tourDate = tourDate;
        this.tourDateTime = tourDateTime;
        this.tourTimestamp = tourTimestamp;
        this.totalTickets = totalTickets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public LocalDate getTourDate() {
        return tourDate;
    }

    public void setTourDate(LocalDate tourDate) {
        this.tourDate = tourDate;
    }

    public LocalDateTime getTourDateTime() {
        return tourDateTime;
    }

    public void setTourDateTime(LocalDateTime tourDateTime) {
        this.tourDateTime = tourDateTime;
    }

    public Instant getTourTimestamp() {
        return tourTimestamp;
    }

    public void setTourTimestamp(Instant tourTimestamp) {
        this.tourTimestamp = tourTimestamp;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(int soldTickets) {
        this.soldTickets = soldTickets;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location location) {
        this.locationId = location;
    }

    public void add(Ticket ticket){
        if(tickets == null){
            tickets = new ArrayList<>();
        }
        tickets.add(ticket);
    }
}
