package dev.glinzac.learnappmentorclient.repository;

import dev.glinzac.learnappmentorclient.entities.MentorDetails;
import dev.glinzac.learnappmentorclient.entities.Skills;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MentorDetailsRepository extends CrudRepository<MentorDetails,Integer> {
    @Query(value="select mentor_id from mentor_details where user_details = :username",nativeQuery = true)
    Optional<Integer> findMentorId(@Param(value="username") String username);

    @Query(value="select skills_skillname from mentor_details_skills where mentor_details_mentor_id = :mentorId",nativeQuery = true)
    List<Skills> findMentorSkills(@Param(value="mentorId") int mentorId);
}
