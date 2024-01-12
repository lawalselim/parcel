package com.example.parcel.service;

public interface SendEmailService {
    void sendEmails(String to, String body, String topic);
    void sendEmailAllUser(String body, String topic);
}
