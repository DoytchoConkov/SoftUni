package workshop.models.bindingModels;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String git;

    public UserRegisterBindingModel() {
    }

    @NotBlank(message = "Username can not be empty")
    @Size(min = 3, message = "Username length must be more than two characters.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Password can not be empty")
    @Size(min = 3, message = "Password length must be more than two characters.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank
    @Pattern(regexp = "https:\\/github.com\\/.+\\/SpringTestData\\/.*",message = "Please enter valit GIThub address!")
    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
