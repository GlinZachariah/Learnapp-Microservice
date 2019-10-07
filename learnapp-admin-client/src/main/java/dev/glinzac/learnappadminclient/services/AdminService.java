package dev.glinzac.learnappadminclient.services;

import dev.glinzac.learnappadminclient.entities.AdminEntity;
import dev.glinzac.learnappadminclient.entities.Technology;
import dev.glinzac.learnappadminclient.repository.AdminEntityRepository;
import dev.glinzac.learnappadminclient.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


//    TODO  =>  Authenticate admin Login


@Service
public class AdminService {

    @Autowired
    TechnologyRepository technologyRepository;

    @Autowired
    AdminEntityRepository adminEntityRepository;

    @Autowired
    MentorService mentorService;

//    getTechnology List
    public List<Technology> getTechnology(){
        return StreamSupport.stream(technologyRepository.findAll().spliterator(),false)
                    .collect(Collectors.toList());
    }
//        add New Technology
    public  void addTechnology(Technology technology){
        mentorService.addMentorSkill(technology.getSkillName());
        technologyRepository.save(technology);
    }
//    delete Technology
    public  void deleteTechnology(String technology){
      mentorService.deleteMentorSkill(technology);
        technologyRepository.deleteById(technology);
    }

    public void getAdminCredentials(AdminEntity adminEntity){
        adminEntityRepository.findById(adminEntity.getAdminName());
    }

}
