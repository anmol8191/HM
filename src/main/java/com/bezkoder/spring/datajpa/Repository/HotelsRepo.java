package com.bezkoder.spring.datajpa.Repository;

import com.bezkoder.spring.datajpa.Entity.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelsRepo extends JpaRepository<Hotels,Integer> {

    List<Hotels> findAll();

    @Query("SELECT h.id FROM Hotels h WHERE h.address LIKE %:address%")
    List<Integer> findByAddressLike(@Param("address") String address);

    List<Hotels> getHotelsByIdIn(@Param("Id") List<Integer> id);

    Hotels getHotelsById(@Param("Id") Integer id);
}
