package com.paulinasprojects.patientportal.mappers;

import com.paulinasprojects.patientportal.dtos.DoctorRequestDTO;
import com.paulinasprojects.patientportal.dtos.DoctorResponseDTO;
import com.paulinasprojects.patientportal.dtos.UpdateDoctorRequestDTO;
import com.paulinasprojects.patientportal.dtos.UpdateDoctorResponseDTO;
import com.paulinasprojects.patientportal.entities.Doctor;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

  @Mapping(target = "dateOfBirth", source = "dateOfBirth", qualifiedByName = "stringToLocalDate")
  @Mapping(target = "registeredDate", source = "registeredDate", qualifiedByName = "stringToLocalDateOrNow")
  Doctor toEntity(DoctorRequestDTO dto);

  @Mapping(target = "dateOfBirth", source = "dateOfBirth", qualifiedByName = "localDateToString")
  @Mapping(target = "registeredDate", source = "registeredDate", qualifiedByName = "localDateToString")
  DoctorResponseDTO toDto(Doctor doctor);

  UpdateDoctorResponseDTO toUpdateDto(Doctor doctor);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntityFromDto(UpdateDoctorRequestDTO dto, @MappingTarget Doctor doctor);

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
