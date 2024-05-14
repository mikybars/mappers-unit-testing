package com.github.mikybars.training.mapunit.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class UserDtoMixin {

  @JsonProperty("name")
  String firstName;
}
