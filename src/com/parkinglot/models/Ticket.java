package com.parkinglot.models;

import java.util.Objects;

public class Ticket {

    private String parkingLotId;
    private int floorNo;
    private int slotNo;

    public Ticket(String parkingLotId, int floorNo, int slotNo) {
        this.parkingLotId = parkingLotId;
        this.floorNo = floorNo;
        this.slotNo = slotNo;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return floorNo == ticket.floorNo && slotNo == ticket.slotNo && parkingLotId.equals(ticket.parkingLotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingLotId, floorNo, slotNo);
    }

    @Override
    public String toString() {
        return "Ticket ID: " +
                parkingLotId + "_" +
                floorNo + "_" +
                slotNo;
    }
}
