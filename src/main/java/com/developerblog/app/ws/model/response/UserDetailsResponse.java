package com.developerblog.app.ws.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetailsResponse {

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
