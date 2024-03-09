package com.bezkoder.spring.datajpa.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "hotel_roomtype_mapping")
public class HotelRoomTypeMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="hotel_id")
    private Integer hotelId;

    @Column(name = "room_types_id")
    private Integer roomTypeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "HotelRoomTypeMapping{" +
                "id=" + id +
                ", hotelId=" + hotelId +
                ", roomTypeId=" + roomTypeId +
                '}';
    }
}
