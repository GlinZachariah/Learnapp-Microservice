package dev.glinzac.learnappadminclient.controller;

import dev.glinzac.learnappadminclient.entities.AdminEntity;
import dev.glinzac.learnappadminclient.entities.Technology;
import dev.glinzac.learnappadminclient.models.AuthModel;
import dev.glinzac.learnappadminclient.models.CredentialModel;
import dev.glinzac.learnappadminclient.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//   TODO =>  perform authentication using JWT

@RestController
public class AdminController {
        @Autowired
    AdminService adminService;

// *       get Technology List
        @RequestMapping(value = "/getTechnologies",method = RequestMethod.GET)
        public List<Technology> getTechnologies(){
            return adminService.getTechnology();
        }

// *       add new Technology
    @RequestMapping(value = "/addTechnology",method = RequestMethod.PUT)
    public void addTech(@RequestBody Technology technology){
        adminService.addTechnology(technology);
    }

// *   delete Technology
    @RequestMapping(value = "/deleteTechnology/{technology}",method = RequestMethod.DELETE)
    public void deleteTech(@PathVariable(name = "technology") String technology){
        adminService.deleteTechnology(technology);
    }

    //	*performAuthentication
    @RequestMapping(value="/performAuth",method= RequestMethod.POST)
    public AuthModel performAuth(@RequestBody CredentialModel credentialModel) {
        return adminService.performAuth(credentialModel);
    }



}
