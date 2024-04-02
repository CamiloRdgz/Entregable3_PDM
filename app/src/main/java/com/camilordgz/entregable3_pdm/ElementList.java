package com.camilordgz.entregable3_pdm;

public class ElementList {
    public String fullName, title, subject, body, time;
    public Integer avatarPicture;
    public Boolean seen;

    public ElementList(String fullName, String title, String subject, String body, String time, Integer avatarPicture, Boolean seen) {
        this.fullName = fullName;
        this.title = title;
        this.subject = subject;
        this.body = body;
        this.time = time;
        this.avatarPicture = avatarPicture;
        this.seen = seen;
    }


    public String getFullName() {
        return fullName;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getTime() {
        return time;
    }

    public Integer getAvatarPicture() {
        return avatarPicture;
    }

    public Boolean getSeenStatus() {
        return seen;
    }

    public void setSeenStatus(Boolean status) {
        this.seen = status;
    }

}
