package com.server.TRDN.mapper;

import com.server.TRDN.DTO.ClinicDTO;
import com.server.TRDN.model.Clinic;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ClinicMapper {

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateClinicFromDto(ClinicDTO dto, @MappingTarget Clinic entity);

  ClinicDTO toDto(Clinic clinic);

  Clinic toEntity(ClinicDTO dto);
}
