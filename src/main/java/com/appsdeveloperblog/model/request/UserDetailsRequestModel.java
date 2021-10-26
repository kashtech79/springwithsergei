package com.appsdeveloperblog.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class UserDetailsRequestModel {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String encryptedPassword;

}
