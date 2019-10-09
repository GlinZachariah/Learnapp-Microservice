package dev.glinzac.learnappuserclient.services;

import dev.glinzac.learnappuserclient.entities.*;
import dev.glinzac.learnappuserclient.models.*;
import dev.glinzac.learnappuserclient.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    CardDetailsRepository cardDetailsRepository;

    @Autowired
    UserCompletedRepository userCompletedRepository;

    @Autowired
    UserProgressRepository userProgressRepository;

    @Autowired
    PaymentLogRepository paymentLogRepository;

    @Autowired
    MentorService mentorService;

    public String getRole(String username) {
        UserDetails user=  userDetailsRepository.getUserRole(username).get();
        return user.getUserRole();
    }

    public void updateCard(CardDetailsModel cardDetail) {
        String username =cardDetail.getUsername();
        int count = cardDetailsRepository.checkCardDetails(username);
        if (count == 1) {
            int id = cardDetailsRepository.findCardId(username).get();
            CardDetails card  = cardDetailsRepository.findById(id).orElse(null);
            card.setCardNo(cardDetail.getCardNo());
            card.setMM(cardDetail.getmM());
            card.setYY(cardDetail.getyY());
            card.setCV(cardDetail.getcV());
            cardDetailsRepository.save(card);
        }else {
            CardDetails card = new CardDetails();
            card.setCardNo(cardDetail.getCardNo());
            card.setMM(cardDetail.getmM());
            card.setYY(cardDetail.getyY());
            card.setCV(cardDetail.getcV());
            card.setUserDetails(userDetailsRepository.findById(username).get());
            cardDetailsRepository.save(card);
        }
    }

    public CardDetailsModel getCardDetails(String username) {
        int id = cardDetailsRepository.findCardId(username).orElse(0);
        CardDetailsModel card = new CardDetailsModel();
        if(id != 0) {
            CardDetails cardData = cardDetailsRepository.findById(id).get();
            if(cardData != null) {
                card.setCardNo(cardData.getCardNo());
                card.setmM(cardData.getMM());
                card.setyY(cardData.getYY());
                card.setcV(cardData.getCV());
                card.setUsername(cardData.getUserDetails().getUserName());
                return card;
            }
        }
        card.setCardNo("");
        card.setUsername("");
        card.setcV(0);
        card.setmM(0);
        card.setyY(0);
        return card;
    }

    public List<UserCompletedTrainingModel> getTrainingCompleted(String username) {
        Iterable<UserCompleted> userIterable= userCompletedRepository.findAll();
        List<UserCompletedTrainingModel> userCompletedData = new ArrayList<UserCompletedTrainingModel>();
        userIterable.forEach(user->{
            UserCompletedTrainingModel newData = new UserCompletedTrainingModel();
            newData.setCourseId(user.getCourseDetails());
            newData.setUserName(user.getUserDetails().getUserName());
            newData.setTimeSlot(user.getTimeslot());
            newData.setStartDate(user.getStartDate());
            newData.setEndDate(user.getEndDate());
            newData.setRating(user.getRating());
            CourseModel courseModel = mentorService.getCourseDetails(user.getCourseDetails());
            newData.setTrainerName(courseModel.getTrainerName());
            newData.setCharges(courseModel.getCharges());
            newData.setTechnology(courseModel.getTechnology().getSkillName());
            userCompletedData.add(newData);
        });

        return userCompletedData;
    }

    public void addToCompleted(UserCompletedTrainingModel userData) {
        CourseModel courseData = mentorService.getCourseDetails(userData.getCourseId());
        mentorService.addToCourseCompleted(courseData.getCourseid());
        UserCompleted user = new UserCompleted();
        user.setUserDetails(userDetailsRepository.findById(userData.getUserName()).get());
        user.setCourseDetails(userData.getCourseId());
        user.setEndDate(userData.getEndDate());
        user.setRating(userData.getRating());
        user.setStartDate(userData.getStartDate());
        user.setTimeslot(userData.getTimeSlot());
        userCompletedRepository.save(user);
        mentorService.updateRating(userData.getCourseId(),userData.getRating());
    }

    public List<UserProgressTrainingModel> getCurrentTraining(String username) {
        List<UserProgress> data = userProgressRepository.findTrainingInProgress(username);
        List<UserProgressTrainingModel> currentData = new ArrayList<UserProgressTrainingModel>();
        data.forEach(user->{
            UserProgressTrainingModel newUser = new UserProgressTrainingModel();
            newUser.setCourseId(user.getCourseDetails());
            newUser.setCourseStatus(user.getCourseStatus());
            newUser.setPaymentStatus(user.getPaymentStatus());
            newUser.setProgress(user.getProgress());
            newUser.setRating(user.getRating());
            newUser.setStartDate(user.getStartDate());
            newUser.setTimeSlot(user.getTimeslot());
            newUser.setUserName(user.getUserDetails().getUserName());
            CourseModel courseModel = mentorService.getCourseDetails(user.getCourseDetails());
            newUser.setCourseName(courseModel.getCourseName());
            newUser.setTechnology(courseModel.getTechnology().getSkillName());
            newUser.setTrainerName(courseModel.getTrainerName());
            currentData.add(newUser);
        });
        return currentData;
    }

    public void updateProgressTraining(UserProgressTrainingModel data) {

        int count = userProgressRepository.findProgressCourse(data.getUserName(),data.getCourseId()).orElse(0);
        UserProgress newData;

        if( count != 0) {
            newData = userProgressRepository.findCourse(data.getUserName(), data.getCourseId()).get();

        }else {
            newData = new UserProgress();
            newData.setTotalCount(0);
            mentorService.increaseTraineeCount(data.getCourseId());

        }

        newData.setCourseDetails(data.getCourseId());
        newData.setCourseStatus(data.getCourseStatus());
        newData.setPaymentStatus(data.getPaymentStatus());
        if(data.getCourseStatus().equals("On Going")) {

            int progress = data.getProgress();
            int initCount=0;
            if(progress <= 25) {
                initCount+=1;
            }else if(progress > 25 && progress <= 50) {
                initCount+=2;
            }else if(progress > 50 && progress < 75) {
                initCount+=3;
            }else {
                initCount+=4;
            }
            newData.setTotalCount(initCount-newData.getWithdrawCount());
        }
        if(data.getPaymentStatus().equals("Paid") && data.getCourseStatus().equals("Approved")) {

            newData.setCourseStatus("On Going");
            mentorService.increaseTraineeProgressCount(data.getCourseId());

            PaymentLog payment = new PaymentLog();
            mentorService.makePayment(data.getCourseId());
            CourseModel courseModel = mentorService.getCourseDetails(data.getCourseId());
            payment.setCommission(courseModel.getCommission());
            payment.setCourseDetails(courseModel.getCourseid());
            Calendar caldr = Calendar.getInstance();
            SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = Date.valueOf(smf.format(caldr.getTime()));
            payment.setDate(date);
            payment.setMentorDetails(mentorService.getMentorId(courseModel.getTrainerName()));
            payment.setPaymentAmount(courseModel.getCharges());
            payment.setUserDetails(userDetailsRepository.findById(data.getUserName()).get());
            paymentLogRepository.save(payment);
        }

        newData.setProgress(data.getProgress());
        newData.setRating(data.getRating());
        newData.setStartDate(data.getStartDate());
        newData.setTimeslot(data.getTimeSlot());
        newData.setUserDetails(userDetailsRepository.findById(data.getUserName()).get());
        if(newData.getProgress() == 100.0D) {

            userProgressRepository.deleteById(newData.getProgressId());
        }else {

            userProgressRepository.save(newData);
        }
    }

    public void addUser(UserModel user) {
        UserDetails newUser = new UserDetails();
        newUser.setAccountStatus(user.getAccountStatus());
        newUser.setFullName(user.getFullName());
        newUser.setUserName(user.getUserName());
        newUser.setUserRole(user.getUserRole());
        newUser.setUserPassword(user.getUserPassword());
        userDetailsRepository.save(newUser);
    }

    public AuthModel performAuth(CredentialModel loginData) {
        AuthModel userDetailsModel = new AuthModel();
        UserDetails user = userDetailsRepository.findById(loginData.getUsername()).orElse(null);
        if(user !=null && user.getUserPassword().equals(loginData.getPassword()) && user.getAccountStatus().equals("unlocked")) {
            userDetailsModel.setAuth(true);
            userDetailsModel.setRole(user.getUserRole());
            userDetailsModel.setFullname(user.getFullName());
            return userDetailsModel;
        }else {
            userDetailsModel.setAuth(false);
            userDetailsModel.setRole("");
            userDetailsModel.setFullname("");
            return userDetailsModel;
        }
    }

    public List<UserModel> getUsers() {
        return userDetailsRepository.getUsers()
                .stream()
                .map(
                        user->new UserModel(
                                user.getUserName(),
                                user.getFullName(),
                                "",
                                user.getUserRole(),
                                user.getAccountStatus()
                        )
                ).collect(Collectors.toList());
    }

    public void updateUserPermission(String username) {
        UserDetails userDetails =userDetailsRepository.findById(username).get();
        String status =userDetails.getAccountStatus();
        if(status.equals("locked")){
            userDetails.setAccountStatus("unlocked");
        }else {
            userDetails.setAccountStatus("locked");
        }
        userDetailsRepository.save(userDetails);
    }

    public List<PaymentModel> getPayments() {
        return paymentLogRepository.getPaymentLog()
                .stream()
                .map(payment->new PaymentModel(
                        payment.getDate(),
                        payment.getUserDetails().getUserName(),
                        mentorService.getUsername(payment.getMentorDetails()),
                        payment.getCourseDetails(),
                        payment.getPaymentAmount(),
                        payment.getCommission()
                ))
                .collect(Collectors.toList());
    }

    public UserModel getUserDetails(String username) {
        UserDetails userDetails = userDetailsRepository.findById(username).get();
        return  new UserModel(
                userDetails.getUserName(),
                userDetails.getFullName(),
                userDetails.getUserPassword(),
                userDetails.getUserRole(),
                userDetails.getAccountStatus()
        );
    }

    public List<MentorProgressModel> getMentorCourseDetails(int mentorId) {
         List<String> mentorCousesList  = mentorService.getMentorCourses(mentorId);
         List<MentorProgressModel> result = userProgressRepository.findMentorInProgress()
                 .stream()
                 .filter(course->mentorCousesList.contains(course.getCourseDetails()) && !course.getCourseStatus().equals("Rejected"))
                 .map(course->new MentorProgressModel(
                         course.getStartDate(),
                         course.getUserDetails().getUserName(),
                         course.getCourseDetails(),
                         course.getCourseStatus(),
                         course.getPaymentStatus(),
                         course.getTimeslot(),
                         course.getProgress(),
                         course.getWithdrawCount(),
                         course.getTotalCount()
                 ))
                 .collect(Collectors.toList());
         result.addAll(
           userCompletedRepository.findMentorInCompleted()
           .stream()
           .filter(course->mentorCousesList.contains(course.getCourseDetails()))
           .map( course-> new MentorProgressModel(
                   course.getStartDate(),
                   course.getUserDetails().getUserName(),
                   course.getCourseDetails(),
                   "Completed",
                   "Paid",
                   course.getTimeslot(),
                   100,
                   course.getWithdrawCount(),
                   course.getTotalCount()
           ))
           .collect(Collectors.toList())
         );
        return  result;
    }

    public Integer getMentorId(String mentorUsername) {
        return mentorService.getMentorId(mentorUsername);
    }

    public void updateMentorCourseDetails(MentorProgressModel mentorData) {
        UserProgress userProgress = userProgressRepository.findCourse(mentorData.getUsername(),mentorData.getCourseId()).get();
        userProgress.setCourseStatus(mentorData.getCourseStatus());
        userProgressRepository.save(userProgress);
    }

    public int getTotalCount(String courseId, String username) {
        UserProgress userProgress =userProgressRepository.findCourse(username,courseId).orElse(null);
        if(userProgress!= null) {
            return userProgress.getTotalCount();
        }
        return  userCompletedRepository.findCourse(username,courseId).get().getTotalCount();
    }



    public int getWithdrawCount(String courseId, String username) {
        UserProgress userProgress =userProgressRepository.findCourse(username,courseId).orElse(null);
        if(userProgress!= null) {
            return userProgress.getWithdrawCount();
        }
        return  userCompletedRepository.findCourse(username,courseId).get().getWithdrawCount();
    }

    public void updateMentorProgressAmount(MentorProgressModel mentorProgressModel) {
        UserProgress userProgress = userProgressRepository.findCourse(mentorProgressModel.getUsername(),mentorProgressModel.getCourseId()).orElse(null);
        if(userProgress != null && userProgress.getWithdrawCount()<4){
            userProgress.setWithdrawCount(userProgress.getWithdrawCount()+1);
            userProgress.setTotalCount(userProgress.getTotalCount()-1);
            userProgressRepository.save(userProgress);
        }else {
            UserCompleted userCompleted = userCompletedRepository.findCourse(mentorProgressModel.getUsername(),mentorProgressModel.getCourseId()).get();
            if(userCompleted.getWithdrawCount()<4){
                userCompleted.setWithdrawCount(userCompleted.getWithdrawCount()+1);
                userCompleted.setTotalCount(userProgress.getTotalCount()-1);
                userCompletedRepository.save(userCompleted);
            }
        }
    }

    public void setNewPwd(String loggedUser,String newPwd) {
        UserDetails user= userDetailsRepository.findById(loggedUser).get();
        user.setUserPassword(newPwd);
        userDetailsRepository.save(user);
    }

    public String getUserFullName(String username) {
        return userDetailsRepository.findById(username).get().getFullName();
    }
}
