package br.com.gabrielrps.realchat.realchat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users_online")
public class UserOnline {

    @Id
    private String id;

    private User user;

    public UserOnline(){}

    public UserOnline(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
