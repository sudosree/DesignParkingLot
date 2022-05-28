package com.parkinglot.models;

import com.parkinglot.models.vehicle.VehicleType;

import java.util.TreeMap;
import java.util.Map;

public class ParkingFloor {

    private int floorNo;
    private Map<Integer, ParkingSlot> parkingSlots;

    public ParkingFloor(int floorNo) {
        this.floorNo = floorNo;
        this.parkingSlots = new TreeMap<>();
    }

    public void addParkingSlots(int slots) {
        for (int i=1;i<=slots;i++) {
            ParkingSlot ps = addParkingSlot(i);
            parkingSlots.put(i, ps);
        }
    }

    private ParkingSlot addParkingSlot(int slot) {
        ParkingSlot ps;
        switch(slot) {
            case 1:
                ps = new ParkingSlot(slot, VehicleType.TRUCK, true);
                break;
            case 2:
            case 3:
                ps = new ParkingSlot(slot, VehicleType.BIKE, true);
                break;
            default:
                ps = new ParkingSlot(slot, VehicleType.CAR, true);
        }
        return ps;
    }

    public Map<Integer, ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(Map<Integer, ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}
