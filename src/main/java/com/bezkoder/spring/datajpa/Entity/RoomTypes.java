package com.bezkoder.spring.datajpa.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "room_types")
public class RoomTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "room_categories")
    private String room_categories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoom_categories() {
        return room_categories;
    }

    public void setRoom_categories(String roomCategories) {
        this.room_categories = roomCategories;
    }

    @Override
    public String toString() {
        return "RoomTypes{" +
                "id=" + id +
                ", roomCategories='" + room_categories + '\'' +
                '}';
    }
}
