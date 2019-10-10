package dev.glinzac.learnappadminclient.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import dev.glinzac.learnappadminclient.entities.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MentorService {

    @Autowired
    private RestTemplate restTemplate;

    public String mentorServiceUrl() {
        return "http://mentor/";
    }

    public void addMentorSkill(String technology){
        restTemplate.getForEntity(mentorServiceUrl()+"/addSkill/"+technology,Technology.class);
    }

    public void deleteMentorSkill(String technology){
        restTemplate.getForEntity(mentorServiceUrl()+"/deleteSkill/"+technology,Technology.class);
    }


}
