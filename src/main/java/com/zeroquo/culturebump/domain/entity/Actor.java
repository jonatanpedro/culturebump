package com.zeroquo.culturebump.domain.entity;

import com.zeroquo.culturebump.domain.entity.enums.Gender;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Actor extends Person{
    private String aka;

    @Builder
    public Actor(Long id, String name, Gender gender, LocalDate birthDay, String aka) {
        super(id, name, gender, birthDay);
        this.aka = aka;
    }
}
