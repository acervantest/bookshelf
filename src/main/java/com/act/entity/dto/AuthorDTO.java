package com.act.entity.dto;

public class AuthorDTO {

    private int authorId;
    private String authorFirstName;
    private String authorMiddleName;
    private String authorLastName;
    private String authorAbout;

    public AuthorDTO() { }

    public AuthorDTO(int authorId, String authorFirstName, String authorMiddleName, String authorLastName, String authorAbout) {
        this.authorId = authorId;
        this.authorFirstName = authorFirstName;
        this.authorMiddleName = authorMiddleName;
        this.authorLastName = authorLastName;
        this.authorAbout = authorAbout;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorMiddleName() {
        return authorMiddleName;
    }

    public void setAuthorMiddleName(String authorMiddleName) {
        this.authorMiddleName = authorMiddleName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorAbout() {
        return authorAbout;
    }

    public void setAuthorAbout(String authorAbout) {
        this.authorAbout = authorAbout;
    }
}
