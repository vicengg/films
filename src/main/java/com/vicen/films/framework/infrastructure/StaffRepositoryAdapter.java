package com.vicen.films.framework.infrastructure;

import com.vicen.films.application.repository.StaffRepository;
import com.vicen.films.domain.people.StaffMember;
import com.vicen.films.framework.errors.ErrorUtils;
import com.vicen.films.framework.errors.InternalError;
import com.vicen.films.framework.errors.NotFoundError;
import com.vicen.films.framework.infrastructure.jpa.StaffJpaRepository;
import com.vicen.films.framework.infrastructure.jpa.dto.StaffMemberJpaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class StaffRepositoryAdapter implements StaffRepository {

    private final StaffJpaRepository staffJpaRepository;

    @Autowired
    public StaffRepositoryAdapter(StaffJpaRepository staffJpaRepository) {
        this.staffJpaRepository = staffJpaRepository;
    }

    @Override
    public List<StaffMember> getStaff() {
        return staffJpaRepository.findAll().stream().map(StaffMember.class::cast).collect(Collectors.toList());
    }

    @Override
    public StaffMember getStaffMember(UUID staffMemberId) {
        return staffJpaRepository.findById(staffMemberId).orElseThrow(NotFoundError::new);
    }

    @Override
    @Transactional
    public StaffMember createStaffMember(StaffMember staffMember) {
        StaffMemberJpaDto jpaDto = ErrorUtils.rethrow(() -> StaffMemberJpaDto.of(staffMember), InternalError::new);
        return staffJpaRepository.save(jpaDto);
    }

}
