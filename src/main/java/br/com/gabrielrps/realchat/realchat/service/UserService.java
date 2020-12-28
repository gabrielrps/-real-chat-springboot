package br.com.gabrielrps.realchat.realchat.service;

import br.com.gabrielrps.realchat.realchat.model.User;
import br.com.gabrielrps.realchat.realchat.model.UserOnline;
import br.com.gabrielrps.realchat.realchat.payload.LoginRequest;
import br.com.gabrielrps.realchat.realchat.payload.LoginResponse;
import br.com.gabrielrps.realchat.realchat.payload.UserRequest;
import br.com.gabrielrps.realchat.realchat.repo.UserOnlineRepository;
import br.com.gabrielrps.realchat.realchat.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserOnlineRepository userOnlineRepository;

    public UserService(UserRepository userRepository, UserOnlineRepository userOnlineRepository) {
        this.userRepository = userRepository;
        this.userOnlineRepository = userOnlineRepository;
    }

    public LoginResponse save(UserRequest userRequest) {

        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());

        User saved = userRepository.save(user);

        return new LoginResponse(saved.getUsername(), "linkAvatar");


    }

    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());

        LoginResponse loginResponse = new LoginResponse();
        if(user.isPresent()){
            loginResponse.setUsername(user.get().getUsername());
            loginResponse.setAvatar("linkAvatar");
            userOnlineRepository.deleteAllByUserUsername(user.get().getUsername());
            userOnlineRepository.save(new UserOnline(user.get()));
        }else {
            loginResponse.setUsername("");
            loginResponse.setAvatar("");
        }

        return loginResponse;

    }

    public Boolean deleteOnline(String username) {
        userOnlineRepository.deleteAllByUserUsername(username);

        return true;
    }
}
