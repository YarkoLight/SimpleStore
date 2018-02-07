package com.SimpleStore.Service;

/**
 * Created by HOME on 05.07.2017.
 */
public interface MailSenderService {


    void sendMail(String theme, String mailBody, String email);
}
