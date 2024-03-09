package com.bezkoder.spring.datajpa.Repository;

import com.bezkoder.spring.datajpa.Entity.RoomTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomTypesRepo extends JpaRepository<RoomTypes, Long> {

    @Query( "select rt.id from RoomTypes rt where rt.room_categories = :room_categories"  )
    Integer findByRoomCategories(@Param("room_categories") String room_categories);

}
