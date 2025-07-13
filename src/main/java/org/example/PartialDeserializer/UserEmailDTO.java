package org.example.PartialDeserializer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEmailDTO {
    private String email;

    public UserEmailDTO() {}

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "UserEmailDTO{email='" + email + "'}";
    }
}

