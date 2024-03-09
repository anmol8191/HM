package com.bezkoder.spring.datajpa.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "hotel_id")
    private Integer hotelId;

    @Column(name = "room_type_id")
    private Integer roomTypeId;

    @Column(name = "number_of_rooms_booked")
    private Integer numberOdRoomsBooked;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getNumberOdRoomsBooked() {
        return numberOdRoomsBooked;
    }

    public void setNumberOdRoomsBooked(Integer numberOdRoomsBooked) {
        this.numberOdRoomsBooked = numberOdRoomsBooked;
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

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", hotelId=" + hotelId +
                ", roomTypeId=" + roomTypeId +
                ", numberOdRoomsBooked=" + numberOdRoomsBooked +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
