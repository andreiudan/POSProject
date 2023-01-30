package com.pos.proiectpos.common;

public class UserDto {
    private String username;

    private Long id;

    private String firstName;

    private String lastName;

    private String position;

    public UserDto(Long id,String username, String firstName, String lastName, String position) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }
}
