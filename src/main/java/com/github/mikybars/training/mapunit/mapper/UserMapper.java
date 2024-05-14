package com.github.mikybars.training.mapunit.mapper;

import com.github.mikybars.training.mapunit.domain.Money;
import com.github.mikybars.training.mapunit.domain.User;
import com.github.mikybars.training.mapunit.dto.MoneyDto;
import com.github.mikybars.training.mapunit.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

  @Mapping(target = "firstName", source = "name")
  UserDto asUserDto(User user);

  @Mapping(target = "currency", ignore = true)
  MoneyDto asMoneyDto(Money money);
}
