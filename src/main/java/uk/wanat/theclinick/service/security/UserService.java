package uk.wanat.theclinick.service.security;

import uk.wanat.theclinick.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
