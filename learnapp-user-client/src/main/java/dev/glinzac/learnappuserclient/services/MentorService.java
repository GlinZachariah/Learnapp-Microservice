package dev.glinzac.learnappuserclient.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import dev.glinzac.learnappuserclient.models.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MentorService {

    @Autowired
    @Qualifier(value = "eurekaClient")
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    public String mentorServiceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("MENTOR", false);
        return instance.getHomePageUrl();
    }

    public CourseModel getCourseDetails(String courseId){
        return  restTemplate.getForObject(mentorServiceUrl()+"getCourseDetails/"+courseId,CourseModel.class);
    }

    public  void addToCourseCompleted(String courseId){
        restTemplate.getForObject(mentorServiceUrl()+"addCourseCompletedCount/"+courseId,Integer.class);
    }

    public void increaseTraineeCount(String courseId){
        restTemplate.getForObject(mentorServiceUrl()+"increaseTraineeCount/"+courseId,Integer.class);
    }


    public void increaseTraineeProgressCount(String courseId) {
        restTemplate.getForObject(mentorServiceUrl()+"increaseTraineeProgressCount/"+courseId,Integer.class);
    }

    public void makePayment(String courseId) {
        restTemplate.getForObject(mentorServiceUrl()+"makePayment/"+courseId,Integer.class);
    }

    public String getUsername(int mentorDetails) {
        return restTemplate.getForObject(mentorServiceUrl()+"getMentorUsername/"+mentorDetails,String.class);
    }

    public int getMentorId(String trainerName) {
        return restTemplate.getForObject(mentorServiceUrl()+"getMentorId/"+trainerName,Integer.class);
    }

    public List<String> getMentorCourses(int mentorId) {
        return restTemplate.exchange(mentorServiceUrl() + "/getMentorCourses/"+mentorId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() { }).getBody();
    }

    public void updateRating(String courseId, int rating) {
        restTemplate.getForObject(mentorServiceUrl()+"/updateCourseRating/"+courseId+"/"+rating,String.class);
    }
}
