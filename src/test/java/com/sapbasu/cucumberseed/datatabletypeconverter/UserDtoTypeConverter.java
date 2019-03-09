package com.sapbasu.cucumberseed.datatabletypeconverter;

import java.util.Locale;
import java.util.Map;

import com.sapbasu.cucumberseed.dto.UserDto;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

public class UserDtoTypeConverter implements TypeRegistryConfigurer {
  
  @Override
  public void configureTypeRegistry(TypeRegistry registry) {
    
    registry.defineDataTableType(
        new DataTableType(UserDto.class, new TableEntryTransformer<UserDto>() {
          @Override
          public UserDto transform(Map<String,String> entry) {
            return new UserDto(entry.get("username"), entry.get("password"));
          }
        }));
  }
  
  @Override
  public Locale locale() {
    return Locale.getDefault();
  }
  
}