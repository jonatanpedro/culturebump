package com.zeroquo.culturebump.domain.entity;

import com.zeroquo.culturebump.domain.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends Person{
    private String login;
    private String email;


    @Builder
    public User(Long id, String name, Gender gender, LocalDate birthDay, String login, String email) {
        super(id, name, gender, birthDay);
        this.login = login;
        this.email = email;
    }
}
