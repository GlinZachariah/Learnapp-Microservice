package dev.glinzac.learnappuserclient.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import dev.glinzac.learnappuserclient.models.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}
