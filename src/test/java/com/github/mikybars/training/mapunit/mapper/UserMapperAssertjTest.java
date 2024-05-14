package com.github.mikybars.training.mapunit.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.mikybars.training.mapunit.domain.Genre;
import com.github.mikybars.training.mapunit.domain.Money;
import com.github.mikybars.training.mapunit.domain.User;
import com.github.mikybars.training.mapunit.dto.UserDto;
import java.util.Objects;
import java.util.function.BiPredicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserMapperAssertjTest {

  static final BiPredicate<String, Enum<?>> STRING_ENUM_EQUALS =
      (String s, Enum<?> e) -> Objects.equals(s, e.name());

  UserMapper userMapper;

  @BeforeEach
  void setUp() {
    userMapper = new UserMapperImpl();
  }

  @Test
  void asUserDto() {
    User user = new User()
        .name("Miguel")
        .genre(Genre.MALE)
        .balance(new Money()
            .amount(100)
        );

    UserDto mappedUser = userMapper.asUserDto(user);

    assertThat(mappedUser)
        .usingRecursiveComparison()
        .ignoringAllOverriddenEquals()
        .ignoringFields("firstName", "balance.currency")
        .withEqualsForFields(STRING_ENUM_EQUALS, "genre")
        .isEqualTo(user);
    assertThat(mappedUser.getFirstName()).as("name").isEqualTo(user.getName());
  }
}