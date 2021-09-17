package com.server.TRDN.mapper;

import com.server.TRDN.DTO.DoctorProfileDTO;
import com.server.TRDN.model.DoctorProfile;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DoctorProfileMapper {

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateDoctorProfileFromDto(DoctorProfileDTO dto, @MappingTarget DoctorProfile entity);

  DoctorProfileDTO toDto(DoctorProfile doctor);

  DoctorProfile toEntity(DoctorProfileDTO dto);
}
