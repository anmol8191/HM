package com.bezkoder.spring.datajpa.DTO;


public class HotelDetailsResponseDto {

private String gym;
private String wifi;
private String parking;
private String swimming_pool;

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getSwimming_pool() {
        return swimming_pool;
    }

    public void setSwimming_pool(String swimming_pool) {
        this.swimming_pool = swimming_pool;
    }

    @Override
    public String toString() {
        return "HotelDetailsResponseDto{" +
                "gym='" + gym + '\'' +
                ", wifi='" + wifi + '\'' +
                ", parking='" + parking + '\'' +
                ", swimming_pool='" + swimming_pool + '\'' +
                '}';
    }
}
