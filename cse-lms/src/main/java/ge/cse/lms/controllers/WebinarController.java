package ge.cse.lms.controllers;

import ge.cse.lms.DTOs.webinar.AssignAppUserWebinarInput;
import ge.cse.lms.DTOs.webinar.CreateWebinarInput;
import ge.cse.lms.services.WebinarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebinarController {
    @Autowired
    WebinarService webinarService;

    @PostMapping("/createwebinar")
    public void createWebinar(@RequestBody CreateWebinarInput createWebinarInput) {
        webinarService.createWebinar(createWebinarInput);
    }

    @PostMapping("/assignappUser")
    public void assignAppUser(@RequestBody AssignAppUserWebinarInput assignAppUserWebinarInput) {
        webinarService.assignAppUser(assignAppUserWebinarInput);
    }

}
