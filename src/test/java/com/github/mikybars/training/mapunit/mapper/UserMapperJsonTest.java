package com.github.mikybars.training.mapunit.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mikybars.training.mapunit.domain.Genre;
import com.github.mikybars.training.mapunit.domain.Money;
import com.github.mikybars.training.mapunit.domain.User;
import com.github.mikybars.training.mapunit.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserMapperJsonTest {

  UserMapper userMapper;

  ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    userMapper = new UserMapperImpl();
    objectMapper = new ObjectMapper()
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
        .addMixIn(UserDto.class, UserDtoMixin.class);
  }

  @Test
  void asUserDto() throws JsonProcessingException {
    User user = new User()
        .name("Miguel")
        .genre(Genre.MALE)
        .balance(new Money()
            .amount(100)
        );

    UserDto mappedUser = userMapper.asUserDto(user);

    assertEquals(asJson(mappedUser), asJson(user));
  }

  String asJson(Object object) throws JsonProcessingException {
    return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
  }
}