package pl.oskarpolak.phonebook.models.services;


import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@Service
@EnableEmailTools
public class NotificationService {

    private EmailService emailService;

    @Autowired
    public NotificationService(EmailService emailService){
        this.emailService = emailService;
    }

    public void sendMessageToAdmin(String message){
        try {
            Email email = DefaultEmail.builder()
                    .from(new InternetAddress("oskarfivarto@gmail.com", "Oskar Polak"))
                    .subject("Ktoś zapisał się do księgi")
                    .to(Arrays.asList(new InternetAddress("oskarfivarto@gmail.com", "Oskar Polak")))
                    .encoding("UTF-8")
                    .body(message)
                    .build();

            emailService.send(email);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
