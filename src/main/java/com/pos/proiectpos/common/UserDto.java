package com.pos.proiectpos.common;

public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String position;
    public UserDto(Long id,String username,String password, String firstName, String lastName, String position) {
        this.id = id;
        this.username = username;
        this.password=password;
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

    public String getPassword() {
        return password;
    }
}
