package com.bezkoder.spring.datajpa.Service;

import com.bezkoder.spring.datajpa.DTO.*;
import com.bezkoder.spring.datajpa.Entity.*;
import com.bezkoder.spring.datajpa.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {

    @Autowired
    HotelsRepo hotelsRepo;

    @Autowired
    HotelsRoomDayWiseDataRepo hotelsRoomDayWiseDataRepo;

    @Autowired
    RoomTypesRepo roomTypesRepo;

    @Autowired
    HotelRoomTypeMappingRepo hotelRoomTypeMappingRepo;

    @Autowired
    UserDetailsRepo userDetailsRepo;

    public String deleteHotelBooking(long userId) {

        UserDetails userDetails = userDetailsRepo.findById(userId);
        Long hotelRoomTypeMapping = hotelRoomTypeMappingRepo.findByHotelIdAndRoomTypeId( userDetails.getHotelId() , userDetails.getRoomTypeId() );

        List<HotelsRoomDayWiseData> hotelsRoomDayWiseDataList = hotelsRoomDayWiseDataRepo.getHotelsRoomDayWiseData(Math.toIntExact(hotelRoomTypeMapping),
                userDetails.getStartDate(),userDetails.getEndDate() );

        for( HotelsRoomDayWiseData hotelsRoomDayWiseData : hotelsRoomDayWiseDataList ){

            hotelsRoomDayWiseData.setRoomsAvailability( hotelsRoomDayWiseData.getRoomsAvailability() + userDetails.getNumberOdRoomsBooked() );

        }

        hotelsRoomDayWiseDataRepo.saveAll(hotelsRoomDayWiseDataList);
        userDetailsRepo.deleteById(userId);
        return "Booking Canceled successfully";
    }

        public String updateHotelBooking(HotelBookingUpdationDto hotelBookingUpdationDto) {

            UserDetails userDetails = userDetailsRepo.findById(hotelBookingUpdationDto.getId());
            userDetails.setNumberOdRoomsBooked( userDetails.getNumberOdRoomsBooked() + hotelBookingUpdationDto.getRoomsCountUpdation() );

            Long hotelRoomTypeMapping = hotelRoomTypeMappingRepo.findByHotelIdAndRoomTypeId( userDetails.getHotelId() , userDetails.getRoomTypeId() );

            List<HotelsRoomDayWiseData> hotelsRoomDayWiseDataList = hotelsRoomDayWiseDataRepo.getHotelsRoomDayWiseData(Math.toIntExact(hotelRoomTypeMapping),
                    userDetails.getStartDate(),userDetails.getEndDate() );

            for( HotelsRoomDayWiseData hotelsRoomDayWiseData : hotelsRoomDayWiseDataList ){

                hotelsRoomDayWiseData.setRoomsAvailability( hotelsRoomDayWiseData.getRoomsAvailability() - hotelBookingUpdationDto.getRoomsCountUpdation() );

            }

            hotelsRoomDayWiseDataRepo.saveAll(hotelsRoomDayWiseDataList);
            userDetailsRepo.save(userDetails);

            return "Entry updated Successfully";


        }

        public UserDetails createHotelBooking(HotelBookingCreationDto hotelBookingCreationDto){

            UserDetails userDetails = new UserDetails();

            Integer roomTypeId = roomTypesRepo.findByRoomCategories(hotelBookingCreationDto.getRoomType());


            userDetails.setUserName(hotelBookingCreationDto.getCustomerName());
            userDetails.setHotelId(hotelBookingCreationDto.getHotelId());
            userDetails.setNumberOdRoomsBooked(hotelBookingCreationDto.getNumberOfRooms());
            userDetails.setRoomTypeId(roomTypeId);
            userDetails.setStartDate(hotelBookingCreationDto.getStartDate());
            userDetails.setEndDate(hotelBookingCreationDto.getEndDate());

            Long hotelRoomTypeMapping = hotelRoomTypeMappingRepo.findByHotelIdAndRoomTypeId( hotelBookingCreationDto.getHotelId() , roomTypeId );

            List<HotelsRoomDayWiseData> hotelsRoomDayWiseDataList = hotelsRoomDayWiseDataRepo.getHotelsRoomDayWiseData(Math.toIntExact(hotelRoomTypeMapping),
                    hotelBookingCreationDto.getStartDate(),hotelBookingCreationDto.getEndDate() );


            for( HotelsRoomDayWiseData hotelsRoomDayWiseData : hotelsRoomDayWiseDataList ){

                hotelsRoomDayWiseData.setRoomsAvailability( hotelsRoomDayWiseData.getRoomsAvailability() - hotelBookingCreationDto.getNumberOfRooms() );

            }

            hotelsRoomDayWiseDataRepo.saveAll(hotelsRoomDayWiseDataList);
            userDetailsRepo.save(userDetails);

            return userDetails;
        }
        public HotelDetailsResponseDto viewHotelDetails(Integer hotelId){
            HotelDetailsResponseDto hotelDetailsResponseDto = new HotelDetailsResponseDto();
            Hotels hotel = hotelsRepo.getHotelsById(hotelId);
            if(hotel!=null) {
                hotelDetailsResponseDto = new Gson().fromJson(hotel.getFacilities(), HotelDetailsResponseDto.class);
            }
            return  hotelDetailsResponseDto;

        }

        public List<HotelSearchResponseDto> searchHotelDetails(HotelSearchDto hotelSearchDto) {

            List<HotelSearchResponseDto> hotelSearchResponseListDto = new ArrayList<>();
            List<Long> uniqueHotelRoomMapping = new ArrayList<>();
            Map<Integer,Integer> map = new HashMap<>();


            List<Integer> hotelIdList = hotelsRepo.findByAddressLike( hotelSearchDto.getLocation() );

            Integer roomTypeId = roomTypesRepo.findByRoomCategories(hotelSearchDto.getRoomType());

            List<Integer> hotelRoomTypeMappingList = hotelRoomTypeMappingRepo.findByHotelIdInAndRoomTypeId( hotelIdList , roomTypeId );

            hotelRoomTypeMappingList = hotelsRoomDayWiseDataRepo.getHotelsRoomDayWiseDataId(hotelRoomTypeMappingList,hotelSearchDto.getNumberOfRooms(),
                                                    hotelSearchDto.getStartDate(),hotelSearchDto.getEndDate());

            long differenceInDays = (hotelSearchDto.getEndDate().getTime() - hotelSearchDto.getStartDate().getTime())/(1000 * 60 * 60 * 24);


            for( Integer hotelRooMapping : hotelRoomTypeMappingList ){

                if( map.containsKey(hotelRooMapping) ){
                    map.put( hotelRooMapping , map.get(hotelRooMapping) + 1 );
                }
                else{
                    map.put( hotelRooMapping , 1 );
                }

            }


            for (Map.Entry<Integer,Integer> mapElement : map.entrySet()) {

                if( mapElement.getValue() == differenceInDays  ){
                    uniqueHotelRoomMapping.add( mapElement.getKey().longValue() );
                }

            }

            hotelIdList = hotelRoomTypeMappingRepo.findHotelIdByMappingId(uniqueHotelRoomMapping);

            List<Hotels> hotelsList = hotelsRepo.getHotelsByIdIn(hotelIdList);

            for( Hotels hotels : hotelsList ){

                HotelSearchResponseDto hotelSearchResponseDto = new HotelSearchResponseDto();

                hotelSearchResponseDto.setId( hotels.getId() );
                hotelSearchResponseDto.setHotelName( hotels.getHotelName() );
                hotelSearchResponseDto.setAddress(hotels.getAddress() );
                hotelSearchResponseDto.setStarRatings( hotels.getStarRatings() );

                hotelSearchResponseListDto.add(hotelSearchResponseDto);
            }

            return hotelSearchResponseListDto;
        }





    }
