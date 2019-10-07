package dev.glinzac.learnappmentorclient.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import dev.glinzac.learnappmentorclient.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    @Qualifier(value = "eurekaClient")
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    public String userServiceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("USERS", false);
        return instance.getHomePageUrl();
    }

    public void saveUserDetails(UserModel user) {
            restTemplate.postForEntity(userServiceUrl()+"/signUpUser",user,UserModel.class);
    }

    public UserModel getUserDetails(String username){
        return  restTemplate.getForEntity(userServiceUrl()+"/getUserDetails/"+username,UserModel.class).getBody();
    }

    public void save(UserModel userModel){
        restTemplate.postForEntity(userServiceUrl()+"/signUpUser",userModel,UserModel.class);
    }

    public List<MentorProgressModel> getMentorProgress(int mentorId) {
        return  restTemplate.exchange(userServiceUrl() + "/getMentorCourseDetails"+mentorId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MentorProgressModel>>() { }).getBody();
    }

    public void updateProgress(MentorProgressModel mentorCourse) {
        restTemplate.postForEntity(userServiceUrl()+"/updateMentorProgress",mentorCourse,MentorProgressModel.class);
    }

    public int getTotalCount(MentorProgressModel mentorCourse) {
        return restTemplate.getForObject(userServiceUrl()+"/getTotalCount/"+mentorCourse.getCourseId()+"/"+mentorCourse.getUsername(),Integer.class);
    }

    public int getWithdrawCount(MentorProgressModel mentorCourse) {
        return restTemplate.getForObject(userServiceUrl()+"/getWithdrawCount/"+mentorCourse.getCourseId()+"/"+mentorCourse.getUsername(),Integer.class);
    }

    public void updateMentorProgressAmount(MentorProgressModel mentorCourse) {
        restTemplate.postForEntity(userServiceUrl()+"/updateMentorProgressAmount",mentorCourse,MentorProgressModel.class);
    }

    public List<PaymentModel> getMentorCourses(){
        return  restTemplate.exchange(userServiceUrl() + "/getPaymentLog",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PaymentModel>>() { }).getBody();
    }
}
