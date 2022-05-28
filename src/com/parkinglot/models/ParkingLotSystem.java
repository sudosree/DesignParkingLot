package com.parkinglot.models;

import com.parkinglot.models.vehicle.Vehicle;

import java.util.Map;

public class ParkingLotSystem {

    public ParkingLotSystem() { }

    public ParkingLot createParkingLot(String id, int floors, int slots) {
        ParkingLot parkingLot = new ParkingLot(id);
        parkingLot.addParkingFloors(floors);
        Map<Integer, ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for (int f : parkingFloors.keySet()) {
            ParkingFloor pf = parkingFloors.get(f);
            pf.addParkingSlots(slots);
        }
        return parkingLot;
    }

    public void parkVehicle(ParkingLot parkingLot, Vehicle vehicle) {
        Ticket ticket = parkingLot.parkVehicle(vehicle);
        if (ticket != null) {
            System.out.println("Parked Vehicle. " + ticket.toString());
        } else {
            System.out.println("Parking Lot Full");
        }
    }

    public void unparkVehicle(ParkingLot parkingLot, Ticket ticket) {
        Vehicle vehicle = parkingLot.unparkVehicle(ticket);
        if (vehicle != null) {
            System.out.println("Unparked vehicle with " + vehicle.toString());
        } else {
            System.out.println("Invalid Ticket");
        }
    }
}
