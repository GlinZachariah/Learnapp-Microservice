package dev.glinzac.learnappmentorclient.services;

import dev.glinzac.learnappmentorclient.entities.CalendarEntity;
import dev.glinzac.learnappmentorclient.entities.CourseDetails;
import dev.glinzac.learnappmentorclient.entities.MentorDetails;
import dev.glinzac.learnappmentorclient.entities.Skills;
import dev.glinzac.learnappmentorclient.models.*;
import dev.glinzac.learnappmentorclient.repository.CalendarEntityRepository;
import dev.glinzac.learnappmentorclient.repository.CourseDetailsRepository;
import dev.glinzac.learnappmentorclient.repository.MentorDetailsRepository;
import dev.glinzac.learnappmentorclient.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorService {

    @Autowired
    MentorDetailsRepository mentorDetailsRepository;

    @Autowired
    CourseDetailsRepository courseDetailsRepository;

    @Autowired
    CalendarEntityRepository calendarEntityRepository;

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    UserService userService;

//    signUp new Mentor
    public void signUp(SignUpModel signUp) {
        UserModel user = new UserModel();
        user.setUserName(signUp.getUserName());
        user.setAccountStatus(signUp.getAccountStatus());
        user.setFullName(signUp.getFullName());
        user.setUserPassword(signUp.getUserPassword());
        user.setUserRole(signUp.getUserRole());
        userService.saveUserDetails(user);


        MentorDetails mentor = new MentorDetails();
        mentor.setUserDetails(user.getUserName());
        mentor.setCourseTypeBlog(signUp.isCourseTypeBlog());
        mentor.setCourseTypeVideo(signUp.isCourseTypeVideo());
        mentor.setCourseTypePPT(signUp.isCourseTypePPT());
        mentor.setCourseTypeDemo(signUp.isCourseTypeDemo());
        mentor.setExperience(signUp.getExperience());
        mentor.setLinkedInURL(signUp.getLinkedInURL());
        mentor.setSkills(signUp.getSkills());
        mentor.setTimeSlot(signUp.getTimeslot());
        mentor.setTimezoneId(signUp.getTimezone());
        mentorDetailsRepository.save(mentor);

    }

    //	add new course
    public void addCourse(CourseModel course) {
        CourseDetails newCourse = new CourseDetails();
        newCourse.setAverageRating(0);
        newCourse.setCharges(course.getCharges());
        newCourse.setCommission(0.1D);
        newCourse.setCourseId(course.getCourseid());
        newCourse.setCourseName(course.getCourseName());

        newCourse.setSkills(course.getTechnology().getSkillName());
        newCourse.setTotalTraineeCount(0);
        newCourse.setTraineeCompleted(0);
        newCourse.setTraineeInProgress(0);
        newCourse.setTotalTime(course.getTotalTime());
        newCourse.setTotalRevenue(0.0D);
        newCourse.setMentorEarned(0.0D);
        int id = mentorDetailsRepository.findMentorId(course.getTrainerName()).orElse(0);
        if(id!=0) {
            MentorDetails mentor = mentorDetailsRepository.findById(id).get();
            newCourse.setMentorDetails(mentor);
            courseDetailsRepository.save(newCourse);
        }
    }

    public int findMentorId(String username) {
        return mentorDetailsRepository.findMentorId(username).get();
    }

    public List<CourseModel> getCourses(int mentorId) {
        return  courseDetailsRepository.findByMentorId(mentorId)
                .stream()
                .map(courses->new CourseModel(
                        courses.getCourseId(),
                        courses.getCourseName(),
                        courses.getMentorDetails().getUserDetails(),
                        new Skills(courses.getSkills()),
                        courses.getCharges(),
                        courses.getCommission(),
                        courses.getTotalTime()
                )).collect(Collectors.toList());
    }

    public void deleteCourse(String courseId) {
        courseDetailsRepository.deleteById(courseId);
    }

    public void saveCalendar(CalendarModel calendarData) {
        CalendarEntity data = new CalendarEntity();
        data.setFromDate(calendarData.getFromDate());
        data.setTillDate(calendarData.getTillDate());
        data.setMentorDetails(mentorDetailsRepository.findById(mentorDetailsRepository.findMentorId(calendarData.getMentorName()).get()).get() );
        data.setStatus(calendarData.getStatus());
        data.setTimeSlot(calendarData.getTimeSlot());
        calendarEntityRepository.save(data);
    }

    public void removeCalendar(CalendarModel calendar) {
        int mentorId = findMentorId(calendar.getMentorName());
        CalendarEntity  cal = calendarEntityRepository.getMentorCalendar(calendar.getFromDate(),calendar.getTillDate(),calendar.getTimeSlot(),mentorId).get();
        calendarEntityRepository.deleteById(cal.getCalendarId());
    }

    public List<CalendarModel> findCalendar(int mentorId) {
        List<CalendarEntity>  mentorCalendarData = calendarEntityRepository.findMentorCalendar(mentorId).orElse(null);
        List<CalendarModel> result = new ArrayList<CalendarModel>();
        if(mentorCalendarData != null) {
            mentorCalendarData.forEach(data->{
                CalendarModel newData = new CalendarModel();
//				newData.setCalendarId(data.getCalendarId());
                newData.setMentorName(data.getMentorDetails().getUserDetails());
                newData.setStatus(data.getStatus());
                newData.setTimeSlot(data.getTimeSlot());
                newData.setFromDate(data.getFromDate());
                newData.setTillDate(data.getTillDate());
                result.add(newData);
            });
        }
        return result;
    }

    public SignUpModel getMentorDetails(int mentorId) {
        System.out.println("The mentor id => "+mentorId);
        MentorDetails mentor = mentorDetailsRepository.findById(mentorId).get();
        SignUpModel result = new SignUpModel();
        result.setUserName(mentor.getUserDetails());
        UserModel user = userService.getUserDetails(mentor.getUserDetails());
        result.setFullName(user.getFullName());
        result.setUserPassword(user.getUserPassword());
        result.setAccountStatus(user.getUserPassword());
        result.setCourseTypeBlog(mentor.isCourseTypeBlog());
        result.setCourseTypeVideo(mentor.isCourseTypeVideo());;
        result.setCourseTypePPT(mentor.isCourseTypePPT());
        result.setCourseTypeDemo(mentor.isCourseTypeDemo());
        result.setExperience(mentor.getExperience());
        result.setUserRole(user.getUserRole());
        result.setTimeslot(mentor.getTimeSlot());
        result.setTimezone(mentor.getTimezoneId());
        result.setLinkedInURL(mentor.getLinkedInURL());
        result.setSkills(getSkills(mentorId));
        return result;
    }

    public List<Skills> getSkills(int mentorId) {
        return mentorDetailsRepository.findMentorSkills(mentorId);
    }

    public void updateMentorDetails(SignUpModel mentorDetails) {
        int mentorId = mentorDetailsRepository.findMentorId(mentorDetails.getUserName()).get();
        MentorDetails mentor = mentorDetailsRepository.findById(mentorId).get();
        UserModel user =userService.getUserDetails(mentorDetails.getUserName());
        user.setUserName(mentorDetails.getUserName());
        user.setAccountStatus(mentorDetails.getAccountStatus());
        user.setFullName(mentorDetails.getFullName());
        user.setUserPassword(mentorDetails.getUserPassword());
        user.setUserRole(mentorDetails.getUserRole());
        userService.save(user);

        mentor.setUserDetails(user.getUserName());
        mentor.setCourseTypeBlog(mentorDetails.isCourseTypeBlog());
        mentor.setCourseTypeVideo(mentorDetails.isCourseTypeVideo());
        mentor.setCourseTypePPT(mentorDetails.isCourseTypePPT());
        mentor.setCourseTypeDemo(mentorDetails.isCourseTypeDemo());
        mentor.setExperience(mentorDetails.getExperience());
        mentor.setLinkedInURL(mentorDetails.getLinkedInURL());
//		mentor.setSkills(mentorDetails.getSkills());
        mentor.setTimeSlot(mentorDetails.getTimeslot());
        mentor.setTimezoneId(mentorDetails.getTimezone());
        mentorDetailsRepository.save(mentor);
    }

    public void updateSkills(SkillsModel mentorSkill) {
        int mentorId = mentorSkill.getMentorId();
        List<Skills> skills= mentorSkill.getSkills();
        MentorDetails mentor = mentorDetailsRepository.findById(mentorId).get();
        mentor.setSkills(skills);
        mentorDetailsRepository.save(mentor);
    }

    public List<MentorHistoryModel> viewHistory(int mentorId) {
        List<MentorHistoryModel> result= new ArrayList<MentorHistoryModel>();
        List<CourseDetails> courses = courseDetailsRepository.findByMentorId(mentorId);
        courses.forEach(course->{
            MentorHistoryModel resultItem = new MentorHistoryModel();
            resultItem.setCourseActive(course.getTraineeInProgress());
            resultItem.setCourseCompleted(course.getTraineeCompleted());
            resultItem.setCourseId(course.getCourseId());
            resultItem.setCourseRating(course.getAverageRating());
            resultItem.setTotalTraineeCount(course.getTotalTraineeCount());
            resultItem.setMentorEarned(course.getMentorEarned());
            resultItem.setRevenueEarned(course.getTotalRevenue());
            resultItem.setTechnology(course.getSkills());
            result.add(resultItem);
        });
        return result;
    }

//    public List<MentorProgressModel> viewProgress(int mentorId) {
//        return userService.getMentorProgress(mentorId);
//    }
//
//    public void updateProgress(MentorProgressModel mentorCourse) {
//       userService.updateProgress(mentorCourse);
//    }

    public MentorProgressModel withdrawProgressAmount(MentorProgressModel mentorCourse) {
//        UserProgress user = progressRepo.findCourse(mentorCourse.getUsername(), mentorCourse.getCourseId()).get();
        int totalCount =userService.getTotalCount(mentorCourse);
        int withdrawCount = userService.getWithdrawCount(mentorCourse);
        int change=0;
        if(totalCount >0) {
            CourseDetails course  = courseDetailsRepository.findById(mentorCourse.getCourseId()).get();
            course.setMentorEarned(course.getMentorEarned()+ (course.getCharges()/4));
            courseDetailsRepository.save(course);
                change=1;
//            user.setWithdrawCount(withdrawCount+1);
//            user.setTotalCount(totalCount-1);
            userService.updateMentorProgressAmount(mentorCourse);
        }
        mentorCourse.setTotalCount(totalCount+change);
        mentorCourse.setWithdrawCount(withdrawCount-change);
//        progressRepo.save(user);
        return mentorCourse;
    }


    public void saveSkill(String skill) {
        skillsRepository.save(new Skills(skill));
    }


    public void deleteSkill(String skillName) {
        skillsRepository.deleteById(skillName);
    }

    public CourseModel getCourseDetails(String courseid) {
        CourseModel courseModel = new CourseModel();
        CourseDetails course = courseDetailsRepository.findById(courseid).get();
        courseModel.setCharges(course.getCharges());
        courseModel.setCourseid(course.getCourseId());
        courseModel.setCourseName(course.getCourseName());
        courseModel.setTrainerName(course.getMentorDetails().getUserDetails());
        courseModel.setTotalTime(course.getTotalTime());
        courseModel.setTechnology(new Skills(course.getSkills()));
        courseModel.setCommission(course.getCommission());
        return courseModel;
    }

    public void addToCompleted(String courseid) {
        CourseDetails courseDetails = courseDetailsRepository.findById(courseid).get();
        courseDetails.setTraineeCompleted(courseDetails.getTraineeCompleted()+1);
        courseDetails.setTraineeInProgress(courseDetails.getTraineeInProgress()-1);
        courseDetailsRepository.save(courseDetails);
    }

    public void increaseTraineeCount(String courseid) {
        CourseDetails courseDetails = courseDetailsRepository.findById(courseid).get();
        courseDetails.setTotalTraineeCount(courseDetails.getTotalTraineeCount()+1);
        courseDetailsRepository.save(courseDetails);
    }

    public void increaseTraineeProgressCount(String courseid) {
        CourseDetails courseDetails = courseDetailsRepository.findById(courseid).get();
        courseDetails.setTraineeInProgress(courseDetails.getTraineeInProgress()+1);
        courseDetailsRepository.save(courseDetails);
    }

    public void makePayment(String courseid) {
        CourseDetails courseDetails = courseDetailsRepository.findById(courseid).get();
        Double oldRevenue = courseDetails.getTotalRevenue();
        Double coursePayment = (courseDetails.getCharges()*courseDetails.getCommission())+courseDetails.getCharges();
        Double newRevenue = oldRevenue + coursePayment;
        courseDetails.setTotalRevenue(newRevenue);
        courseDetailsRepository.save(courseDetails);
    }

    public List<SearchCourseResponseModel> findAllCourses(SearchCourseRequestModel requestData) {
        Iterable<CourseDetails> courses = courseDetailsRepository.findTrainingInProgress(requestData.getTechnology());
        List<SearchCourseResponseModel> result = new ArrayList<SearchCourseResponseModel>();
        courses.forEach(course->{
            SearchCourseResponseModel newData = new SearchCourseResponseModel();
            List<CalendarEntity> calendarData = calendarEntityRepository.findMentorCalendar(course.getMentorDetails().getMentorId()).orElse(null);
            if(calendarData != null) {
                calendarData.forEach(data->{
                    boolean beforeDate = requestData.getStartDate().after(data.getFromDate());
                    boolean afterDate = requestData.getStartDate().before(data.getTillDate());
                    boolean timeslotAvailable = (requestData.getTimeSlot() == data.getTimeSlot());

                    if(beforeDate && afterDate && timeslotAvailable) {
                        SearchCourseResponseModel newDataItem = new SearchCourseResponseModel();
                        newDataItem.setCourseId(course.getCourseId());
                        newDataItem.setCourseName(course.getCourseName());
                        newDataItem.setExperience(course.getMentorDetails().getExperience());
                        newDataItem.setMaterialBlog(course.getMentorDetails().isCourseTypeBlog());
                        newDataItem.setMaterialVideo(course.getMentorDetails().isCourseTypeVideo());
                        newDataItem.setMaterialPPT(course.getMentorDetails().isCourseTypePPT());
                        newDataItem.setMaterialDemo(course.getMentorDetails().isCourseTypeDemo());
//						calculate service charge correctly
                        newDataItem.setServiceCharges(course.getCommission()*100);
                        newDataItem.setTrainingCharges(course.getCharges());
                        newDataItem.setTechnology(requestData.getTechnology());
                        newDataItem.setTotalTime(course.getTotalTime());
                        newDataItem.setTrainerName(course.getMentorDetails().getUserDetails());
                        newDataItem.setTotalCount(course.getTotalTraineeCount());
                        newDataItem.setActiveCount(course.getTraineeInProgress());
                        newDataItem.setCompletedCount(course.getTraineeCompleted());
                        newDataItem.setAvgCourseRating(course.getAverageRating());
                        newDataItem.setTimeSlot(requestData.getTimeSlot());
                        newDataItem.setStartDate(requestData.getStartDate());
                        result.add(newDataItem);
                    }
                });
            }
        });
        return result;
    }


    public List<CommissionModel> getCommissionList() {
        Iterable<CourseDetails> courseIterable = courseDetailsRepository.findAll();
        List<CommissionModel> result =new ArrayList<CommissionModel>();
        courseIterable.forEach(item->{
            CommissionModel resultItem= new CommissionModel();
            resultItem.setCommission(item.getCommission());
            resultItem.setCourseCharge(item.getCharges());
            resultItem.setCourseId(item.getCourseId());
            resultItem.setMentorId(item.getMentorDetails().getMentorId());
            resultItem.setTrainerName(item.getMentorDetails().getUserDetails());
            result.add(resultItem);
        });
        return result;
    }

    public void updateCommission(String courseId, double newComm) {
        CourseDetails course= courseDetailsRepository.findById(courseId).get();
        course.setCommission(newComm);
        courseDetailsRepository.save(course);
    }

    public List<PaymentModel> getMentorCourse(String mentorUsername) {
        return  userService.getMentorCourses()
                .stream()
                .filter(user->user.getTrainerName().equals(mentorUsername))
                .collect(Collectors.toList());
    }

    public String getMentorUsername(int mentorId) {
        return mentorDetailsRepository.findById(mentorId).get().getUserDetails();
    }

    public int getMentorId(String mentorUsername) {
        return mentorDetailsRepository.findMentorId(mentorUsername).get();
    }

    public List<String> getMentorCourseId(int mentorId) {
       return courseDetailsRepository.findByMentorId(mentorId)
               .stream()
               .map(course->course.getCourseId())
               .collect(Collectors.toList());
    }
}
