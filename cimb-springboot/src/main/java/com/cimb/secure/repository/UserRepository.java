package com.cimb.secure.repository;

import com.cimb.secure.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User u WHERE u.username = '%:searchKey%' OR u.email = '%:searchKey%'")
    User findByUsername(@Param("searchKey") String searchKey);

}
