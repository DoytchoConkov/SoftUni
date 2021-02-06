package TeamworkProjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<ProjectName> projectsName = new ArrayList<>();
        List<TeamworkProjects> teamworkProjects = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] token = scan.nextLine().split("-");
            boolean flag = true;
            for (ProjectName projectName : projectsName) {
                if (token[1].equals(projectName.getProjectName())) {
                    System.out.printf("Team %s was already created!%n", token[1]);
                    flag = false;
                } else if (token[0].equals(projectName.getCreator())) {
                    System.out.printf("%s cannot create another team!%n", token[0]);
                    flag = false;
                }
            }
            if (flag) {
                ProjectName project = new ProjectName(token[1], token[0], 1);
                TeamworkProjects team = new TeamworkProjects(token[0], token[1]);
                System.out.printf("Team %s has been created by %s!%n", token[1], token[0]);
                projectsName.add(project);
                teamworkProjects.add(team);
            }
        }

        String input = scan.nextLine();
        while (!"end of assignment".equals(input)) {
            String[] tokens = input.split("->");
            boolean isExistProject = false;
            boolean isExistPerson = false;

            for (ProjectName project : projectsName) {
                if (tokens[1].equals(project.getProjectName())) {
                    isExistProject = true;
                }
            }

            for (TeamworkProjects person : teamworkProjects) {
                if (tokens[0].equals(person.getName())) {
                    isExistPerson = true;
                }
            }

            if (isExistProject && !isExistPerson) {
                for (ProjectName project : projectsName) {
                    if (tokens[1].equals(project.getProjectName())) {
                        project.setMembers(project.getMembers() + 1);
                    }
                }
                TeamworkProjects person = new TeamworkProjects(tokens[0], tokens[1]);
                teamworkProjects.add(person);
            } else if (isExistPerson) {
                System.out.printf("Member %s cannot join team %s!%n", tokens[0], tokens[1]);
            } else if (isExistProject) {
                System.out.printf("Team %s does not exist!%n", tokens[1]);
            }
            input = scan.nextLine();
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < projectsName.size() - 1; i++) {
                if (projectsName.get(i).getMembers() < projectsName.get(i + 1).getMembers()) {
                    projectsName.add(i, projectsName.get(i + 1));
                    projectsName.remove(i + 2);
                    flag = true;
                }
            }
        }
        teamworkProjects.sort((p1, p2) -> (p1.getName().compareTo(p2.getName())));
        for (ProjectName project : projectsName) {
            if (project.getMembers() > 1) {
                System.out.printf("%s%n", project.getProjectName());
                System.out.printf("- %s%n", project.getCreator());
                for (TeamworkProjects person : teamworkProjects) {
                    if (project.getProjectName().equals(person.getProjectName()) && !project.getCreator().equals(person.getName())) {
                        System.out.printf("-- %s%n", person.getName());
                    }
                }
            }
        }
        System.out.println("Teams to disband:");
        projectsName.sort((p1, p2) -> (p1.getProjectName().compareTo(p2.getProjectName())));
        for (ProjectName project : projectsName) {
            if (project.getMembers() == 1) {
                System.out.println(project.getProjectName());
            }
        }
    }
}