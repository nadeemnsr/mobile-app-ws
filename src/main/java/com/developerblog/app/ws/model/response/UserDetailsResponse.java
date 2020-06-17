package com.developerblog.app.ws.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetailsResponse {

    @NotNull(message = "First Name can not be null")
    private String firstName;

    @NotNull(message = "Lsst Name can not be null")
    private String lastName;

    @NotNull(message = "Email can not be null")
    @Email
    private String email;

    @NotNull(message = "Password can not be null")
    @Size(min = 8,max =16, message ="Password must be grater than 8 character and less than 16 character")
    private String password;
}
