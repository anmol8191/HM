package com.bezkoder.spring.datajpa.Repository;

import com.bezkoder.spring.datajpa.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Long> {

    UserDetails findById(@Param("id") long id );

}
