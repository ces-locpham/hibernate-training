package org.locpham.tranning.hibernate;

import org.locpham.tranning.hibernate.airport.Airport;
import org.locpham.tranning.hibernate.airport.Passenger;
import org.locpham.tranning.hibernate.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("hibernatefundamentals.m02.ex01");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Airport airport = new Airport(1, "Airport 1");
        Passenger passenger1 = new Passenger(1, "Passenger 1");
        passenger1.setAirport(airport);

        Passenger passenger2 = new Passenger(2, "Passenger 2");
        passenger2.setAirport(airport);

        airport.addPassenger(passenger1);
        airport.addPassenger(passenger2);

        Ticket ticket1 = new Ticket(1, "Ticket 1");
        ticket1.setPassenger(passenger1);

        Ticket ticket2 = new Ticket(2, "Ticket 2");
        ticket2.setPassenger(passenger1);

        passenger1.addTicket(ticket1);
        passenger1.addTicket(ticket2);

        Ticket ticket3 = new Ticket(3, "Ticket 3");
        ticket3.setPassenger(passenger2);

        em.persist(airport);
        em.persist(passenger1);
        em.persist(passenger2);
        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);


        em.getTransaction().commit();
        emf.close();
    }
}