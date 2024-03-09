package com.bezkoder.spring.datajpa.DTO;

public class HotelBookingUpdationDto {

    private int id;
    private int roomsCountUpdation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomsCountUpdation() {
        return roomsCountUpdation;
    }

    public void setRoomsCountUpdation(int roomsCountUpdation) {
        this.roomsCountUpdation = roomsCountUpdation;
    }

    @Override
    public String toString() {
        return "HotelBookingUpdationDto{" +
                "id=" + id +
                ", roomsCountUpdation=" + roomsCountUpdation +
                '}';
    }
}
