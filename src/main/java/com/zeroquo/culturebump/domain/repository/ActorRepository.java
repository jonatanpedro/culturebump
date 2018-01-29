package com.zeroquo.culturebump.domain.repository;

import com.zeroquo.culturebump.domain.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
