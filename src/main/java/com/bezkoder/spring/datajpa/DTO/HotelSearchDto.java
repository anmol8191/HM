package com.bezkoder.spring.datajpa.DTO;

import java.util.Date;

public class HotelSearchDto {

    private String location;
    private Date startDate;
    private Date endDate;
    private String roomType;
    private int numberOfRooms;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "HotelSearchDto{" +
                "location='" + location + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", roomType='" + roomType + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                '}';
    }
}
