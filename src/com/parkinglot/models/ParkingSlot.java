package com.parkinglot.models;

import com.parkinglot.models.vehicle.Vehicle;
import com.parkinglot.models.vehicle.VehicleType;

public class ParkingSlot {

    private int slotNo;
    private VehicleType type;
    private boolean isEmpty;
    private Vehicle vehicle;

    public ParkingSlot(int slotNo, VehicleType type, boolean isEmpty) {
        this.slotNo = slotNo;
        this.type = type;
        this.isEmpty = isEmpty;
        this.vehicle = null;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.isEmpty = false;
        this.vehicle = vehicle;
    }

    public void unparkVehicle() {
        this.isEmpty = true;
        this.vehicle = null;
    }
}
