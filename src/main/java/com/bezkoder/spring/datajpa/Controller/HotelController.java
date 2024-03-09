package com.bezkoder.spring.datajpa.Controller;

import com.bezkoder.spring.datajpa.DTO.*;
import com.bezkoder.spring.datajpa.Entity.UserDetails;
import com.bezkoder.spring.datajpa.Service.HotelService;
import com.bezkoder.spring.datajpa.Repository.HotelsRoomDayWiseDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @Autowired
    HotelsRoomDayWiseDataRepo hotelsRoomDayWiseDataRepo;

    @GetMapping("/search/hotels")
    public List<HotelSearchResponseDto> SearchHotels(@RequestBody HotelSearchDto hotelSearchDto){

       return hotelService.searchHotelDetails(hotelSearchDto);

    }

    @GetMapping("/view/hotel/details")
    public HotelDetailsResponseDto ViewHotelDetails(@RequestParam("hotelId") Integer hotelId){

        return hotelService.viewHotelDetails(hotelId);

    }

    @PostMapping("/create/hotel/booking")
    public UserDetails createHotelBooking(@RequestBody HotelBookingCreationDto hotelBookingCreationDto){

        return hotelService.createHotelBooking(hotelBookingCreationDto);

    }

    @PutMapping("/update/hotel/booking")
    public String updateHotelBooking(@RequestBody HotelBookingUpdationDto hotelBookingUpdationDto){

        return hotelService.updateHotelBooking(hotelBookingUpdationDto);

    }

    @DeleteMapping("/delete/hotel/booking")
    public String deleteHotelBooking(@RequestParam("userId") long userId){

        return hotelService.deleteHotelBooking(userId);

    }
}
