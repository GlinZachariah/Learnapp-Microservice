package dev.glinzac.learnappmentorclient.controller;

import dev.glinzac.learnappmentorclient.entities.Skills;
import dev.glinzac.learnappmentorclient.models.*;
import dev.glinzac.learnappmentorclient.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentorController {

    @Autowired
    MentorService mentorService;

    //*	signUp Mentor
    @RequestMapping(value = "/signUp" ,method = RequestMethod.POST)
    public void signUpMentor(@RequestBody SignUpModel signUp) {
        mentorService.signUp(signUp);
    }

    //	addCourse
    @RequestMapping(value = "/addCourse",method = RequestMethod.POST)
    public void addCourse(@RequestBody CourseModel course) {
        mentorService.addCourse(course);
    }

    //	getCoursesList
    @RequestMapping(value = "/getCoursesList/{mentorUsername}",method = RequestMethod.GET)
    public List<CourseModel> getCourseList(@PathVariable String mentorUsername){
        int mentorId = mentorService.findMentorId(mentorUsername);
        return mentorService.getCourses(mentorId);
    }

    //	deleteCourse
    @RequestMapping(value = "/deleteCourse/{courseId}",method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String courseId) {
        mentorService.deleteCourse(courseId);
    }

    //	mentorCalendar add
    @RequestMapping(value = "/addCalendar",method = RequestMethod.POST)
    public void addCalendar(@RequestBody CalendarModel calendarData) {
        mentorService.saveCalendar(calendarData);
    }

    //	mentorCalendar delete
    @RequestMapping(value = "/deleteCalendar",method = RequestMethod.PUT)
    public void deleteCalendar(@RequestBody CalendarModel calendar) {
        mentorService.removeCalendar(calendar);
    }

    //	getMentorCalendar
    @RequestMapping(value = "/findCalendar/{mentorUsername}",method = RequestMethod.GET)
    public List<CalendarModel> findCalendarByMentor(@PathVariable String mentorUsername) {
        int mentorId = mentorService.findMentorId(mentorUsername);
        return mentorService.findCalendar(mentorId);
    }

    //	getDetails
    @RequestMapping(value = "/getMentorDetails/{mentorUsername}",method = RequestMethod.GET)
    public SignUpModel getMentorDetails(@PathVariable String mentorUsername) {
        int mentorId = mentorService.findMentorId(mentorUsername);
        return mentorService.getMentorDetails(mentorId);
    }

    //	updateDetails
    @RequestMapping(value = "/updateMentorDetails/",method = RequestMethod.PUT)
    public void updateMentorDetails(@RequestBody SignUpModel mentorDetails) {
        mentorService.updateMentorDetails(mentorDetails);
    }

    //*	getMentorSkills
    @RequestMapping(value = "/getMentorSkills/{mentorUsername}",method = RequestMethod.GET)
    public List<Skills> getSkills(@PathVariable  String mentorUsername){
        int mentorId = mentorService.findMentorId(mentorUsername);
        return mentorService.getSkills(mentorId);
    }

    //*	updateMentorSkills
    @RequestMapping(value = "/updateMentorSkills",method = RequestMethod.PUT)
    public void updateSkills(@RequestBody SkillsModel mentorSkill){
        mentorService.updateSkills(mentorSkill);
    }

    //	viewHistory
    @RequestMapping(value = "/viewMentorHistory/{mentorUsername}",method = RequestMethod.GET)
    public List<MentorHistoryModel> viewMentorHistory(@PathVariable  String mentorUsername){
        int mentorId = mentorService.findMentorId(mentorUsername);
        return mentorService.viewHistory(mentorId);
    }

    //	InProgress
//    @RequestMapping(value = "/viewMentorProgress/{mentorUsername}",method = RequestMethod.GET)
//    public List<MentorProgressModel> viewMentorProgress(@PathVariable  String mentorUsername){
//        int mentorId = mentorService.findMentorId(mentorUsername);
//        return mentorService.viewProgress(mentorId);
//    }

    //	updateInProgress
//    @RequestMapping(value = "/updateMentorProgress",method = RequestMethod.PUT)
//    public void updateMentorProgress(@RequestBody MentorProgressModel mentorCourse){
//        mentorService.updateProgress(mentorCourse);
//    }




//    addSkill
    @RequestMapping(value = "/addSkill/{technology}",method = RequestMethod.GET)
    public void addSkills(@PathVariable(value = "technology")  String skill){
        mentorService.saveSkill(skill);
    }

    //    deleteSkill
    @RequestMapping(value = "/deleteSkill/{technology}",method = RequestMethod.GET)
    public void deleteSkill(@PathVariable(value = "technology")  String skillName){
        mentorService.deleteSkill(skillName);
    }

//    getCourseDetails
    @RequestMapping(value = "/getCourseDetails/{courseId}",method = RequestMethod.GET)
    public  CourseModel getCourseDetails(@PathVariable(value = "courseId")  String courseid){
        return mentorService.getCourseDetails(courseid);
    }

    //    addToCompleted Count
    @RequestMapping(value = "/addCourseCompletedCount/{courseId}",method = RequestMethod.GET)
    public  void addCourseCompleted(@PathVariable(value = "courseId")  String courseid){
        mentorService.addToCompleted(courseid);
    }

    //    addToTotalTraineeCount
    @RequestMapping(value = "/increaseTraineeCount/{courseId}",method = RequestMethod.GET)
    public  void increaseTraineeCount(@PathVariable(value = "courseId")  String courseid){
        mentorService.increaseTraineeCount(courseid);
    }

    @RequestMapping(value = "/increaseTraineeProgressCount/{courseId}",method = RequestMethod.GET)
    public  void increaseTraineeProgressCount(@PathVariable(value = "courseId")  String courseid){
        mentorService.increaseTraineeProgressCount(courseid);
    }

    @RequestMapping(value = "/makePayment/{courseId}",method = RequestMethod.GET)
    public  void makePayment(@PathVariable(value = "courseId")  String courseid){
        mentorService.makePayment(courseid);
    }

    //	searchCourses
    @RequestMapping(value = "/searchCourse",method = RequestMethod.POST)
    public List<SearchCourseResponseModel> searchCourse(@RequestBody SearchCourseRequestModel requestData) {
        return mentorService.findAllCourses(requestData);
    }

//    getCommissionList
    @RequestMapping(value = "/getCommissionList",method = RequestMethod.GET)
    public List<CommissionModel> getCommissionList() {
        return mentorService.getCommissionList();
    }

    //    updateCommission
    @RequestMapping(value = "/updateCommission/{courseid}/{newCommissionValue}",method = RequestMethod.GET)
    public void updateCommission(@PathVariable(value = "courseid") String courseId,@PathVariable(value = "newCommissionValue") String newCommission) {
        mentorService.updateCommission(courseId,Double.parseDouble(newCommission));
    }

    //  generate Report
    @RequestMapping(value = "/getReport/{mentorUsername}",method = RequestMethod.GET)
    public List<PaymentModel> getMentorCourses(@PathVariable(name = "mentorUsername") String mentorUsername){
        return mentorService.getMentorCourse(mentorUsername);
    }

//    getMentorUsername
    @RequestMapping(value = "/getMentorUsername/{mentorId}",method = RequestMethod.GET)
    public String getMentorUsername(@PathVariable(name = "mentorId") String mentorId){
        return mentorService.getMentorUsername(Integer.parseInt(mentorId));
    }

//    getMentorId
    @RequestMapping(value = "/getMentorId/{mentorUsername}",method = RequestMethod.GET)
    public int getMentorId(@PathVariable(name = "mentorUsername") String mentorUsername){
        return mentorService.getMentorId(mentorUsername);
    }

//    getMentorCourses
    @RequestMapping(value = "/getMentorCourses/{mentorId}",method = RequestMethod.GET)
    public List<String> getMentorCourseId(@PathVariable(name = "mentorId") String mentorId){
        return mentorService.getMentorCourseId(Integer.parseInt(mentorId));
    }

//    Evalaluated Controlleres

    //	withdrawAmount
    @RequestMapping(value = "/withdrawAmount",method = RequestMethod.PUT)
    public MentorProgressModel withdrawMentorProgress(@RequestBody MentorProgressModel mentorCourse){
        return mentorService.withdrawProgressAmount(mentorCourse);
    }
}
