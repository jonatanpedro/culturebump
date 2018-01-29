package com.zeroquo.culturebump.domain.repository;

import com.zeroquo.culturebump.domain.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
