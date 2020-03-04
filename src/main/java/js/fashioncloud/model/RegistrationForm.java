package js.fashioncloud.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public User mapToUser(PasswordEncoder passwordEncoder){

        return new User(
                this.username,
                passwordEncoder.encode(this.password),
                this.fullname,
                this.street,
                this.city,
                this.state,
                this.zip,
                this.phoneNumber
        );
    }
}
