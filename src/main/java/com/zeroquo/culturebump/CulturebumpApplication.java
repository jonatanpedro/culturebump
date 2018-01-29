package com.zeroquo.culturebump;

import com.zeroquo.culturebump.domain.entity.Actor;
import com.zeroquo.culturebump.domain.entity.Director;
import com.zeroquo.culturebump.domain.entity.Movie;
import com.zeroquo.culturebump.domain.entity.User;
import com.zeroquo.culturebump.domain.entity.enums.Genre;
import com.zeroquo.culturebump.domain.repository.ActorRepository;
import com.zeroquo.culturebump.domain.repository.DirectorRepository;
import com.zeroquo.culturebump.domain.repository.MovieRepository;
import com.zeroquo.culturebump.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.zeroquo.culturebump.domain.entity.enums.Gender.FEMALE;
import static com.zeroquo.culturebump.domain.entity.enums.Gender.MALE;

@SpringBootApplication
public class CulturebumpApplication {

	public static void main(String[] args) {
		SpringApplication.run(CulturebumpApplication.class, args);
	}

    @Bean
    public CommandLineRunner loadUserData(UserRepository rep) {
        return args -> rep.save(User
                .builder()
                .name("Jonatan Pedro da Silva")
                .birthDay(LocalDate.of(1982,9,1))
                .gender(MALE)
                .email("jp@email.com")
                .login("jp")
                .build());
    }

    @Bean
    public CommandLineRunner loadActorData(ActorRepository rep) {
        return args -> {
            rep.save(Actor
                    .builder()
                    .aka("Edward Norton")
                    .birthDay(LocalDate.of(1969,8,18))
                    .name("Edward Harrison Norton")
                    .gender(MALE)
                    .build());
            rep.save(Actor
                    .builder()
                    .aka("Brad Pitt")
                    .birthDay(LocalDate.of(1963,12,18))
                    .name("William Bradley Pitt")
                    .gender(MALE)
                    .build());
            rep.save(Actor
                    .builder()
                    .aka("Helena Bonham Carter")
                    .birthDay(LocalDate.of(1966,5,26))
                    .name("Helena Bonham Carter")
                    .gender(FEMALE)
                    .build());
        };
    }

    @Bean
    public CommandLineRunner loadDirectorData(DirectorRepository rep) {
        return args -> rep.save(Director
                .builder()
                .name("David Fincher")
                .localBirth("US")
                .gender(MALE)
                .birthDay(LocalDate.of(1962,8,28))
                .build());
    }

    @Bean
    public CommandLineRunner loadMovieData(MovieRepository mrep, DirectorRepository drep, ActorRepository arep) {
        return args -> {

            Set<Actor> cast = new HashSet<>(arep.findAll());

            Director director = drep.findOne(Example.of(Director
                        .builder()
                        .name("David Fincher")
                        .localBirth("US")
                        .gender(MALE)
                        .birthDay(LocalDate.of(1962, 8, 28))
                        .build()))
                    .orElse(null);

            mrep.save(Movie
                    .builder()
                    .title("Fight Club")
                    .genre(Genre.DRAMA)
                    .originalTitle("Fight Club")
                    .plot("Some plot")
                    .year(1999)
                    .director(director)
                    .cast(cast)
                    .build());
        };
    }
}
