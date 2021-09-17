package com.server.TRDN.mapper;

import com.server.TRDN.DTO.AppointmentDTO;
import com.server.TRDN.model.Appointment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAppointmentFromDto(AppointmentDTO dto, @MappingTarget Appointment entity);

    AppointmentDTO toDto(Appointment appointment);
    Appointment toEntity(AppointmentDTO dto);
}

