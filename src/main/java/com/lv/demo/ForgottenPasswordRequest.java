package com.lv.demo;

public class ForgottenPasswordRequest {
    private String fromAddress;
    private String fromName;
    private String subject;
    private String text;
    private String emailAddress;

    public void setFromAddress(final String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromName(final String fromName) {
        this.fromName = fromName;
    }

    public String getFromName() {
        return fromName;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
