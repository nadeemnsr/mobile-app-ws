package com.developerblog.app.ws.model.request;

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
public class UpdateUserDetailsModel {

    @NotNull(message = "First Name can not be null")
    private String firstName;

    @NotNull(message = "Lsst Name can not be null")
    private String lastName;

}
