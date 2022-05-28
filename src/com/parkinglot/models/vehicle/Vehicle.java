package com.parkinglot.models.vehicle;

import com.parkinglot.models.Ticket;

public abstract class Vehicle {

    private String registrationNo;
    private VehicleType type;
    private String color;
    private Ticket ticket;

    public Vehicle(String registrationNo, VehicleType type, String color) {
        this.registrationNo = registrationNo;
        this.type = type;
        this.color = color;
        this.ticket = null;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void assignTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void unassignTicket() {
        this.ticket = null;
    }

    @Override
    public String toString() {
        return "Registration Number:" + registrationNo +
                " and Color: " + color;
    }
}
