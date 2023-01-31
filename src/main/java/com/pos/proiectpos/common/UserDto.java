package com.pos.proiectpos.common;

public class UserDto {
    private String username;

    private Long id;

    private String firstName;

    private String lastName;

    private String position;

    private boolean validation;

    public UserDto(Long id,String username, String firstName, String lastName, String position, boolean validation) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.validation = validation;
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

    public boolean getValidation() {
        return validation;
    }
}
