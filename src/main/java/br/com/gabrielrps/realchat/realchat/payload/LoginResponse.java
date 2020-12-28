package br.com.gabrielrps.realchat.realchat.payload;

public class LoginResponse {

    private String username;
    private String avatar;

    public LoginResponse(String username, String avatar) {
        this.username = username;
        this.avatar = avatar;
    }

    public LoginResponse(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
