package com.example.demo.repository;


import com.example.demo.entity.Consumer;
import com.example.demo.entity.Student;
import com.example.demo.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,String> {

    Optional<Consumer> findOptionalByEmail(String email);
    boolean existsByEmail(String email);

    @Query(value = "SELECT * FROM consumer u WHERE u.role = 2", nativeQuery = true)
    List<Consumer> getAllStudents();


    @Query(value = "SELECT * FROM consumer u WHERE u.role = 1", nativeQuery = true)
    List<Consumer> getAllTeacher();
}
