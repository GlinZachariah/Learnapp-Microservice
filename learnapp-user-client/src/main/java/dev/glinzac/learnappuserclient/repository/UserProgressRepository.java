package dev.glinzac.learnappuserclient.repository;

import dev.glinzac.learnappuserclient.entities.UserProgress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserProgressRepository extends CrudRepository<UserProgress,Integer> {
    @Query(value="select count(*) from user_progress where user_name= :username && course_details = :coursename",nativeQuery = true)
    Optional<Integer> findProgressCourse(@Param(value="username") String username, @Param(value="coursename") String courseName);

    @Query(value="select * from user_progress where user_name= :username && course_details = :courseId",nativeQuery = true)
    Optional<UserProgress> findCourse(@Param(value="username") String username, @Param(value="courseId") String courseId);

    @Query(value="select * from user_progress where user_name = :username",nativeQuery = true)
    List<UserProgress> findTrainingInProgress(@Param(value="username") String username);

    @Query(value="select * from user_progress",nativeQuery = true)
    List<UserProgress> findMentorInProgress();
}
