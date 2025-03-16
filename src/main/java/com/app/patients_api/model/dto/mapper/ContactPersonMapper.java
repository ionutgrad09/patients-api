package com.app.patients_api.model.dto.mapper;

import com.app.patients_api.model.dto.ContactPersonDto;
import com.app.patients_api.model.entities.ContactPerson;

public class ContactPersonMapper {

  public static ContactPerson toEntity(ContactPersonDto dto) {
    if (dto == null) {
      return null;
    }
    return ContactPerson.builder()
            .email(dto.getEmail())
            .firstName(dto.getFirstName())
            .lastName(dto.getLastName())
            .phoneNumber(dto.getPhoneNumber())
            .build();
  }

  public static ContactPersonDto toDto(ContactPerson entity) {
    if (entity == null) {
      return null;
    }
    return ContactPersonDto.builder()
            .email(entity.getEmail())
            .firstName(entity.getFirstName())
            .lastName(entity.getLastName())
            .phoneNumber(entity.getPhoneNumber())
            .build();
  }
}
