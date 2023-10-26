package com.entornos.p1.backuistudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDTO {

        String username;

        String fullName;

        String studentCode;

        String email;

        String password;

}
