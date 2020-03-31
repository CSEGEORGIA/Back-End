package ge.cse.lms.services;

import ge.cse.lms.DTOs.webinar.AssignAppUserWebinarInput;
import ge.cse.lms.DTOs.webinar.CreateWebinarInput;

public interface WebinarService {

    void createWebinar(CreateWebinarInput createWebinarInput);
    void  assignAppUser(AssignAppUserWebinarInput assignAppUserWebinarInput);

}
