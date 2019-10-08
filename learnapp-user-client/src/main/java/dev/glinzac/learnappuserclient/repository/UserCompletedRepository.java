package dev.glinzac.learnappuserclient.repository;

import dev.glinzac.learnappuserclient.entities.UserCompleted;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserCompletedRepository extends CrudRepository<UserCompleted,Integer> {

//    @Query(value="select * from user_completed where withdraw_count < 4 && course_details IN (select course_id from course_details where mentor_id = :mentorId)",nativeQuery = true)
//    List<UserCompleted> findTrainerCourses(@Param(value="mentorId") int mentorId);

    @Query(value="select * from user_completed where user_name= :username && course_details = :courseId",nativeQuery = true)
    Optional<UserCompleted> findCourse(@Param(value="username") String username, @Param(value="courseId") String courseId);

    @Query(value="select * from user_completed",nativeQuery = true)
    List<UserCompleted> findMentorInCompleted();
}
