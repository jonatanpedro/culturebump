package com.zeroquo.culturebump.domain.entity;

import com.zeroquo.culturebump.domain.entity.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String originalTitle;
    private String plot;
    private Integer year;
    private Genre genre;
    @OneToOne
    private Director director;
    @OneToMany
    private Set<Actor> cast;
}
