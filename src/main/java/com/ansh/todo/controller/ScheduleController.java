package com.ansh.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableScheduling
public class ScheduleController {
    private JavaMailSender javaMailSender;

    @Autowired
    public ScheduleController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Scheduled(fixedRate = 50000) // this will send the email to notify the user in every 50 second that some Todo
                                  // item is pending
    @GetMapping("/runScheduler")
    public void greeting() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo("anshgupta8529@gmail.com");
        mailMessage.setSubject("Pending ToDo item"); // if we want to send the email for a particular todo item at some
                                                     // particular time, we can fetch the id of that item from the
                                                     // database and add an if clause when to send the mail
        mailMessage.setText("Check your to do list!");

        try {
            javaMailSender.send(mailMessage);
        } catch (MailException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }

}
