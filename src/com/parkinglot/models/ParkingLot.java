package com.parkinglot.models;

import com.parkinglot.models.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ParkingLot {

    private String id;
    private Map<Integer, ParkingFloor> parkingFloors;
    private Map<Ticket, Vehicle> ticketVehicleList;

    public ParkingLot(String id) {
        this.id = id;
        this.parkingFloors = new TreeMap<>();
        this.ticketVehicleList = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Integer, ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void addParkingFloors(int floors) {
        for (int i=1;i<=floors;i++) {
            ParkingFloor parkingFloor = addParkingFloor(i);
            this.parkingFloors.put(i, parkingFloor);
        }
    }

    private ParkingFloor addParkingFloor(int floorNo) {
        return new ParkingFloor(floorNo);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (int f : parkingFloors.keySet()) {
            ParkingFloor pf = parkingFloors.get(f);
            ParkingSlot ps = getFirstFreeSlot(pf, vehicle);
            if (ps != null) {
                Ticket ticket = new Ticket(this.id, f, ps.getSlotNo());
                vehicle.assignTicket(ticket);
                ticketVehicleList.put(ticket, vehicle);
                return ticket;
            }
        }
        return null;
    }

    private ParkingSlot getFirstFreeSlot(ParkingFloor parkingFloor, Vehicle vehicle) {
        Map<Integer, ParkingSlot> parkingSlots = parkingFloor.getParkingSlots();
        for (int s : parkingSlots.keySet()) {
            ParkingSlot ps = parkingSlots.get(s);
            if (ps.getType() == vehicle.getType() && ps.isEmpty()) {
                ps.parkVehicle(vehicle);
                parkingSlots.put(s, ps);
                return ps;
            }
        }
        return null;
    }

    public Vehicle unparkVehicle(Ticket ticket) {
        if (ticketVehicleList.containsKey(ticket)) {
            int floor = ticket.getFloorNo();
            int slot = ticket.getSlotNo();
            ParkingFloor pf = parkingFloors.get(floor);
            Map<Integer, ParkingSlot> parkingSlots = pf.getParkingSlots();
            ParkingSlot ps = parkingSlots.get(slot);
            ps.unparkVehicle();
            parkingSlots.put(slot, ps);
            Vehicle vehicle = ticketVehicleList.get(ticket);
            vehicle.unassignTicket();
            ticketVehicleList.remove(ticket);
            return vehicle;
        }
        return null;
    }
}
