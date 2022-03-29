public class User {
    private String fullName;
    private String login;
    private String password;

    public User(String fullName, String login, String password){
        this.fullName = fullName;
        this.login = login;
        this.password = password;
    }

    public String getFullname(){
        return fullName;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }

}
