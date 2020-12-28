package br.com.gabrielrps.realchat.realchat.service;

import br.com.gabrielrps.realchat.realchat.model.User;
import br.com.gabrielrps.realchat.realchat.model.UserOnline;
import br.com.gabrielrps.realchat.realchat.repo.UserOnlineRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOnlineService {

    private final UserOnlineRepository userOnlineRepository;

    public UserOnlineService(UserOnlineRepository userOnlineRepository) {
        this.userOnlineRepository = userOnlineRepository;
    }


    public List<User> getUsersConnect(String username) {
        List<UserOnline> list = userOnlineRepository.findAllByUserUsernameNot(username);

        List<User> users = new ArrayList<>();
        users.add(new User("Global"));

        if (!list.isEmpty()) {
            for (UserOnline u : list) {
                users.add(u.getUser());
            }
        }
        return users;
    }

}
