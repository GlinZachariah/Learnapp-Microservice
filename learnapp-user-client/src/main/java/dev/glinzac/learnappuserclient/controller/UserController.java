package dev.glinzac.learnappuserclient.controller;

import dev.glinzac.learnappuserclient.models.*;
import dev.glinzac.learnappuserclient.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    //	*performAuthentication
    @RequestMapping(value="/performAuth",method= RequestMethod.POST)
    public AuthModel performAuth(@RequestBody CredentialModel credentialModel) {
        return userService.performAuth(credentialModel);
    }


    //	getUserRole
    @RequestMapping(value="/getRole/{username}",method= RequestMethod.GET)
    public String getRole(@PathVariable String username) {
        return userService.getRole(username);
    }

    //	* saveCardDetails | UpdateCardDetails
    @RequestMapping(value="/updateCardDetails",method= RequestMethod.PUT)
    public void updateCardDetails(@RequestBody CardDetailsModel cardDetails) {
        userService.updateCard(cardDetails);
    }

    //	getCardDetails
    @RequestMapping(value = "/getCardDetails/{username}",method = RequestMethod.GET)
    public CardDetailsModel getCardDetails(@PathVariable String username) {
        return userService.getCardDetails(username);
    }

    //	getCompletedTrainingDetails
    @RequestMapping(value = "/getCompletedTrainingDetails/{username}",method = RequestMethod.GET)
    public List<UserCompletedTrainingModel> getCompletedTraining(@PathVariable String username){
        return userService.getTrainingCompleted(username);
    }

    //addToCompleted
    @RequestMapping(value = "/addCompletedTrainingDetails",method = RequestMethod.POST)
    public void addToCompleted(@RequestBody UserCompletedTrainingModel userData) {
        userService.addToCompleted(userData);
    }

    //getProgressTrainingDetails
    @RequestMapping(value="/getProgressTraining/{username}",method = RequestMethod.GET)
    public List<UserProgressTrainingModel> getProgressTraining(@PathVariable String username) {
        return userService.getCurrentTraining(username);
    }

    //addProgressTrainingDetails | updateProgressTrainingDetails
    @RequestMapping(value="/updateProgressTraining",method = RequestMethod.PUT)
    public void updateProgressTrainingDetails(@RequestBody UserProgressTrainingModel data) {
        System.out.println("The Update Progress Training is working Here");
        userService.updateProgressTraining(data);
    }

    //	* signUpUser
    @RequestMapping(value="/signUpUser",method = RequestMethod.POST)
    public void signUpUser(@RequestBody UserModel user) {
        userService.addUser(user);
    }

// *   getUsers
    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public List<UserModel> getUsers(){
        return  userService.getUsers();
    }

//*    updateUser
    @RequestMapping(value = "/updateUser/{username}",method = RequestMethod.GET)
    public void updateUser(@PathVariable(value = "username") String username){
        userService.updateUserPermission(username);
    }

//    getPaymentLog
      @RequestMapping(value = "/getPaymentLog",method = RequestMethod.GET)
      public List<PaymentModel> getPaymentModel(){
           return userService.getPayments();
       }

//       get User Details
    @RequestMapping(value = "/getUserDetails/{username}",method = RequestMethod.GET)
     public UserModel getUserDetails(@PathVariable(value = "username") String username){
            return  userService.getUserDetails(username);
     }

    //       getMentorCourseDetails
    @RequestMapping(value = "/getMentorCourseDetails/{mentorUsername}",method = RequestMethod.GET)
    public List<MentorProgressModel> getMentorCourseDetails(@PathVariable(value = "mentorUsername") String mentorUsername){
        Integer mentorId = userService.getMentorId(mentorUsername);
        return  userService.getMentorCourseDetails(mentorId);
    }

//    updateMentorCourseDetails
    @RequestMapping(value = "/updateMentorCourseDetails",method = RequestMethod.PUT)
    public void updateMentorCourseDetails(@RequestBody MentorProgressModel mentorData){
        userService.updateMentorCourseDetails(mentorData);
    }

//    getTotalCount
    @RequestMapping(value = "/getTotalCount/{courseId}/{username}",method = RequestMethod.GET)
    public int getTotalCount(@PathVariable String courseId,@PathVariable String username){
        return userService.getTotalCount(courseId,username);
    }

//    getWithdrawCount
    @RequestMapping(value = "/getWithdrawCount/{courseId}/{username}",method = RequestMethod.GET)
    public int getWithdrawCount(@PathVariable String courseId,@PathVariable String username){
        return userService.getWithdrawCount(courseId,username);
    }

//    updateMentorProgressAmount
    @RequestMapping(value = "/updateMentorProgressAmount",method = RequestMethod.POST)
    public void updateMentorProgressAmount(@RequestBody MentorProgressModel mentorProgressModel){
        userService.updateMentorProgressAmount(mentorProgressModel);
    }

//    changePassword  newValue
        @RequestMapping(value = "/newValue/{loggedUser}",method = RequestMethod.POST)
        public void setNewPwd(@PathVariable String loggedUser,@RequestBody String newPwd){
            userService.setNewPwd(loggedUser,newPwd);
        }

}
