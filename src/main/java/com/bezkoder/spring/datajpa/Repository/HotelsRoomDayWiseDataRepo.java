package com.bezkoder.spring.datajpa.Repository;

import com.bezkoder.spring.datajpa.Entity.HotelsRoomDayWiseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface HotelsRoomDayWiseDataRepo extends JpaRepository<HotelsRoomDayWiseData, Long> {


    @Query(" select hrd.hotelRoomTypeMappingId from HotelsRoomDayWiseData hrd where hrd.hotelRoomTypeMappingId in (:hotel_roomtype_mapping_id)" +
            "and hrd.roomsAvailability >= :rooms_availability and hrd.Date >= :start_date and hrd.Date <= :end_date")
    List<Integer> getHotelsRoomDayWiseDataId(@Param("hotel_roomtype_mapping_id") List<Integer> hotel_roomtype_mapping_id,
                                             @Param("rooms_availability") Integer rooms_availability,
                                             @Param("start_date") Date start_date,
                                             @Param("end_date") Date end_date);

    @Query("select hrd from HotelsRoomDayWiseData hrd where hrd.hotelRoomTypeMappingId = :hotel_roomtype_mapping_id and " +
            "hrd.Date > :start_date and hrd.Date <= :end_date ")
    List<HotelsRoomDayWiseData> getHotelsRoomDayWiseData(@Param("hotel_roomtype_mapping_id") Integer hotel_roomtype_mapping_id,
                                                         @Param("start_date") Date start_date,
                                                         @Param("end_date") Date end_date);

}
