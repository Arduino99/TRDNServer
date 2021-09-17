package com.server.TRDN.mapper;

import com.server.TRDN.DTO.PatientProfileDTO;
import com.server.TRDN.model.PatientProfile;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PatientProfileMapper {

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updatePatientProfileFromDto(PatientProfileDTO dto, @MappingTarget PatientProfile entity);

  PatientProfileDTO toDto(PatientProfile patient);

  PatientProfile toEntity(PatientProfileDTO dto);
}
