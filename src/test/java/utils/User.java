package utils;

public class User {
    private String fullName;
    private String login;
    private String password;

    private User(){}

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String fullName){
        this.fullName = fullName;
        this.login = login;
        this.password = password;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getFullName(){
        return fullName;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }

    public static class UserBuilder{
        private User user;

        public UserBuilder(){
            user = new User();
        }

        public UserBuilder withLogin(String login){
            user.login = login;
            return this;
        }

        public UserBuilder withPassword(String password){
            user.password = password;
            return this;
        }

        public UserBuilder withFullName(String fullName){
            user.fullName = fullName;
            return this;
        }

        public User build(){
            return user;
        }
    }
}
