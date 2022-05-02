package com.toyp.web.Dto;

import com.toyp.config.EnumRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemDto {
    private String nameMem;
    private String password;
    private EnumRole role;
    private String jwt;

}
