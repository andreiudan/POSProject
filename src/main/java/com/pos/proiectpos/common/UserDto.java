package com.pos.proiectpos.common;

public class UserDto {
    private String username;

    private Long id;

    private String firstName;

    private String lastName;

    private String position;

    public UserDto(String username, Long id, String firstName, String lastName, String position) {

        this.username = username;
        this.id = id;
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
