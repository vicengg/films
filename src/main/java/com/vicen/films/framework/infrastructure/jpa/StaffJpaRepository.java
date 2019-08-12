package com.vicen.films.framework.infrastructure.jpa;

import com.vicen.films.framework.infrastructure.jpa.dto.StaffMemberJpaDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface StaffJpaRepository extends CrudRepository<StaffMemberJpaDto, UUID> {

    @Override
    List<StaffMemberJpaDto> findAll();

}
