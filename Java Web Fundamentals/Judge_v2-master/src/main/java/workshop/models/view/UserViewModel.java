package workshop.models.view;

public class UserViewModel {
    private String id;
    private String username;
    private String homeworks;
    private String email;
    private String git;

    public UserViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(String homeworks) {
        this.homeworks = homeworks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }
}
