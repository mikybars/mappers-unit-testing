package com.github.mikybars.training.mapunit.mapper;

import com.github.mikybars.training.mapunit.domain.Genre;
import com.github.mikybars.training.mapunit.domain.Money;
import com.github.mikybars.training.mapunit.domain.User;
import com.github.mikybars.training.mapunit.dto.UserDto;
import org.approvaltests.JsonApprovals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserMapperApprovalTest {

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

    JsonApprovals.verifyAsJson(mappedUser);
  }
}