
CREATE TABLE hotels (     id INT AUTO_INCREMENT PRIMARY KEY,     hotel_name VARCHAR(255),
                        address VARCHAR(255), star_ratings INT );

alter table hotels add column facilities JSON NULL ;

alter table user_details add column start_date DATE ;

alter table user_details add column end_date DATE ;


CREATE TABLE room_types (     id INT AUTO_INCREMENT PRIMARY KEY,     room_categories VARCHAR(255) );


CREATE TABLE hotel_roomtype_mapping (     id INT AUTO_INCREMENT PRIMARY KEY,
                                          hotel_id INT ,
                                          room_types_id INT);

CREATE TABLE hotels_room_day_wise_data (     id INT AUTO_INCREMENT PRIMARY KEY,
                                             hotel_roomtype_mapping_id INT ,
                                             total_rooms INT,
                                             rooms_availability INT,
                                          date Date);

CREATE TABLE user_details (     id INT AUTO_INCREMENT PRIMARY KEY,
                                user_name VARCHAR(255) ,
                                hotel_id INT,
                                room_type_id INT,
                                number_of_rooms_booked INT);
