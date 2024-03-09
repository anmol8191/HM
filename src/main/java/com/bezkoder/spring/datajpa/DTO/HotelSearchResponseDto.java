package com.bezkoder.spring.datajpa.DTO;

import jakarta.persistence.Column;

public class HotelSearchResponseDto {

    private int id;

    private String hotelName;

    private String address;

    private int starRatings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStarRatings() {
        return starRatings;
    }

    public void setStarRatings(int starRatings) {
        this.starRatings = starRatings;
    }

    @Override
    public String toString() {
        return "HotelSearchResponseDto{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", address='" + address + '\'' +
                ", starRatings=" + starRatings +
                '}';
    }
}
