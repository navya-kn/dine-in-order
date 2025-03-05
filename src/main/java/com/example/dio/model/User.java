package com.example.dio.model;

import com.example.dio.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="user_id")
    private long userid;
    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="phno")
    private String phno;
    @Column(name="create_at")
    private LocalDate createAt;
    @Column(name="last_modified_at")
    private LocalDate lastModifiedAt;
    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private UserRole role;


    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(LocalDate lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
