package com.entornos.p1.backuistudy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDataDTO {

    private Long id;

    private String username;

    private String fullName;

    private String role;

}
