package com.example.demo.dto.request.manager;

import com.example.demo.entity.enums.Role;

public class ChangeConsumerInfoRequest {

    private String id;
    private String token;//
    private String tc;
    private String name;//
    private String lastName;//
    private String phoneNumber;//
    private String email;//
    private Role role;
    private String password;


    public ChangeConsumerInfoRequest(String studentId, String token, String tc, String name, String lastName, String phoneNumber, String email, Role role, String password) {
        this.id = studentId;
        this.token = token;
        this.tc = tc;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public ChangeConsumerInfoRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return id;
    }

    public void setUserId(String studentId) {
        this.id = studentId;
    }
}
