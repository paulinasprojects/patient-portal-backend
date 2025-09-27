package com.paulinasprojects.patientportal.mappers;

import com.paulinasprojects.patientportal.dtos.PatientRequestDTO;
import com.paulinasprojects.patientportal.dtos.PatientResponseDTO;
import com.paulinasprojects.patientportal.dtos.UpdatePatientRequestDTO;
import com.paulinasprojects.patientportal.dtos.UpdatePatientResponseDTO;
import com.paulinasprojects.patientportal.entities.Patient;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface PatientMapper {

  @Mapping(target = "dateOfBirth", source = "dateOfBirth", qualifiedByName = "stringToLocalDate")
  @Mapping(target = "registeredDate", source = "registeredDate", qualifiedByName = "stringToLocalDateOrNow")
  Patient toEntity(PatientRequestDTO dto);

  @Mapping(target = "dateOfBirth", source = "dateOfBirth", qualifiedByName = "localDateToString")
  @Mapping(target = "registeredDate", source = "registeredDate", qualifiedByName = "localDateToString")
  PatientResponseDTO toDto(Patient patient);

  UpdatePatientResponseDTO toUpdateDto(Patient patient);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntityFromDto(UpdatePatientRequestDTO dto, @MappingTarget Patient patient);

  @Named("stringToLocalDate")
  static LocalDate stringToLocalDate(String date) {
    return (date != null) ? LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE) : null;
  }

  @Named("stringToLocalDateOrNow")
  static LocalDate stringToLocalDateOrNow(String date) {
    return (date != null) ? LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE) : LocalDate.now();
  }

  @Named("localDateToString")
  static String localDateToString(LocalDate date) {
    return (date != null) ? date.toString() : null;
  }
}
