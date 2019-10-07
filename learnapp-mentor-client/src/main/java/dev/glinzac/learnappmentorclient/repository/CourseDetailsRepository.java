package dev.glinzac.learnappmentorclient.repository;

import dev.glinzac.learnappmentorclient.entities.CourseDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseDetailsRepository extends CrudRepository<CourseDetails,String> {
    @Query(value="select * from course_details where technology = :tech",nativeQuery = true)
    List<CourseDetails> findTrainingInProgress(@Param(value="tech") String tech);

    @Query(value="select * from course_details where mentor_id = :mentorId",nativeQuery = true)
    List<CourseDetails> findByMentorId(@Param(value="mentorId") int mentorId);
}
