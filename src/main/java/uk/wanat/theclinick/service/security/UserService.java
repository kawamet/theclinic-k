package uk.wanat.theclinick.service.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import uk.wanat.theclinick.model.User;
import uk.wanat.theclinick.model.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
