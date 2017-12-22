package com.epam.lab.spring.khokhliatskii.evernote.transformer;

import com.epam.lab.spring.khokhliatskii.evernote.dto.UserDto;
import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer implements Transformer<User, UserDto> {

    @Autowired
    private UserService userService;

    @Qualifier("fakePasswordEncoder")
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto unbind(User source) {
        UserDto userDto = new UserDto();
        userDto.setId(source.getId());
        userDto.setEmail(source.getEmail());
        userDto.setRole(source.getRole());
        return userDto;
    }

    @Override
    public User bind(UserDto source) {
        User user = userService.findById(source.getId());
        if (user == null) {
            user = new User();
        }
        user.setEmail(source.getEmail());
        user.setRole("ROLE_USER");

        if (StringUtils.isNotBlank(source.getPassword())) {
            user.setPassword(passwordEncoder.encode(source.getPassword()));
        }
        return user;
    }
}
