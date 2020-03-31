package ge.cse.lms.services.impl;

import ge.cse.lms.DTOs.webinar.AssignAppUserWebinarInput;
import ge.cse.lms.DTOs.webinar.CreateWebinarInput;
import ge.cse.lms.models.AppUser;
import ge.cse.lms.models.Webinar;
import ge.cse.lms.repositories.AppUserRepository;
import ge.cse.lms.repositories.WebinarRepository;
import ge.cse.lms.services.WebinarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebinarServiceImpl implements WebinarService {

    @Autowired
    WebinarRepository webinarRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public void createWebinar(CreateWebinarInput createWebinarInput) {
        Webinar webinar = new Webinar();
        webinar.setTitle(createWebinarInput.getTitle());
        webinar.setStartDate(createWebinarInput.getStartDate());
        webinar.setEndDate(createWebinarInput.getEndDate());
        webinar.setLink(createWebinarInput.getLink());
        webinarRepository.save(webinar);
    }

    @Override
    public void assignAppUser(AssignAppUserWebinarInput assignAppUserWebinarInput) {
        AppUser appUser = appUserRepository.findByUsername(assignAppUserWebinarInput.getUsername());
        if (appUser != null) {
            Webinar webinar = webinarRepository.getOne(assignAppUserWebinarInput.getWebinarId());
            if (webinar != null) {
                appUser.getWebinars().add(webinar);
                appUserRepository.save(appUser);
                System.out.println("save");
            }
        }
    }

}
