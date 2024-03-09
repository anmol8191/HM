package com.bezkoder.spring.datajpa.Repository;

import com.bezkoder.spring.datajpa.Entity.HotelRoomTypeMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRoomTypeMappingRepo extends JpaRepository<HotelRoomTypeMapping,Long> {

    @Query(" select hrm.id from  HotelRoomTypeMapping hrm where hrm.hotelId in (:hotel_id) and hrm.roomTypeId = :room_type_id")
    List<Integer> findByHotelIdInAndRoomTypeId(@Param("hotel_id") List<Integer> hotel_id,
                                                            @Param("room_type_id") Integer room_type_id);

    @Query("select hrm.hotelId from HotelRoomTypeMapping hrm where hrm.id in (:id)")
    List<Integer> findHotelIdByMappingId(@Param("id") List<Long> id );

    @Query("select hrm.id from HotelRoomTypeMapping hrm where hrm.hotelId = :hotel_id and  hrm.roomTypeId = :room_type_id")
    Long findByHotelIdAndRoomTypeId(@Param("hotel_id") Integer hotel_id,
                                    @Param("room_type_id") Integer room_type_id);

}
