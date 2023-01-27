package com.pos.proiectpos.common;

public class UserDto {
    private String username;
    private String email;
    private Long id;


    public UserDto(String username, String email, Long id) {

        this.username = username;
        this.email = email;
        this.id=id;



    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
