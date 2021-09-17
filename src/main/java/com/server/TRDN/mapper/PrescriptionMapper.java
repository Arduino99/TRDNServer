package com.server.TRDN.mapper;

import com.server.TRDN.DTO.PrescriptionDTO;
import com.server.TRDN.model.Prescription;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePrescriptionFromDto(PrescriptionDTO dto, @MappingTarget Prescription entity);

    PrescriptionDTO toDto(Prescription prescription);

    Prescription toEntity(PrescriptionDTO dto);
}


