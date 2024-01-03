package org.locpham.tranning.hibernate.airport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "PASSENGERS")
@SecondaryTable( name = "ADDRESSES",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "PASSENGER_ID")
)
public class Passenger {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSENGER_ADDRESS", table ="ADDRESSES", columnDefinition = "varchar(25) not null")
    private String address;

    public Passenger(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name  = "AIRPORT_ID")
    private Airport airport;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets = new ArrayList<>();

    public Passenger() {
    }

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
