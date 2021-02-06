package TeamworkProjects;

public class ProjectName {
    private String projectName;
    private String creator;
    private int members;

    public ProjectName(String projectName, String creator, int members) {
        this.projectName = projectName;
        this.creator = creator;
        this.members = members;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getCreator() {
        return creator;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }
}
