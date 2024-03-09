package com.bezkoder.spring.datajpa.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "hotels_room_day_wise_data")
public class HotelsRoomDayWiseData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "hotel_roomtype_mapping_id")
    private Integer hotelRoomTypeMappingId;

    @Column(name = "total_rooms")
    private Integer totalRooms;

    @Column(name = "rooms_availability")
    private Integer roomsAvailability;

    @Column(name = "date")
    private java.util.Date Date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getHotelRoomTypeMappingId() {
        return hotelRoomTypeMappingId;
    }

    public void setHotelRoomTypeMappingId(Integer hotelRoomTypeMappingId) {
        this.hotelRoomTypeMappingId = hotelRoomTypeMappingId;
    }

    public Integer getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Integer totalRooms) {
        this.totalRooms = totalRooms;
    }

    public Integer getRoomsAvailability() {
        return roomsAvailability;
    }

    public void setRoomsAvailability(Integer roomsAvailability) {
        this.roomsAvailability = roomsAvailability;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "HotelsRoomDayWiseData{" +
                "id=" + id +
                ", hotelRoomTypeMappingId=" + hotelRoomTypeMappingId +
                ", totalRooms='" + totalRooms + '\'' +
                ", roomsAvailability=" + roomsAvailability +
                ", Date=" + Date +
                '}';
    }
}
