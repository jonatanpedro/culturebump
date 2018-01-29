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
public class Director extends Person {
    private String localBirth;

    @Builder
    public Director(Long id, String name, Gender gender, LocalDate birthDay, String localBirth) {
        super(id, name, gender, birthDay);
        this.localBirth = localBirth;
    }
}
