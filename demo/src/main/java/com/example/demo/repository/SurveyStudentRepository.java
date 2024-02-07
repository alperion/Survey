package com.example.demo.repository;


import com.example.demo.entity.Survey;
import com.example.demo.entity.SurveyStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyStudentRepository extends JpaRepository<SurveyStudent,String> {
    void deleteBySurveyId(String surveyId);

    void deleteByStudentId(String studentId);

//    @Query(value = "SELECT * FROM survey_student u WHERE u.student_id = ?1",nativeQuery = true)
//    List<SurveyStudent> getAllByStudentId(String studentId);

    List<SurveyStudent> findAllByStudentId(String studentId);

    List<SurveyStudent> findAllBySurveyId(String surveyId);
}
