package cqu.mve.ResearchPlatformBackground.Project;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.User.User;

import java.util.List;

public class Project {
    private String topic;
    private User owner;
    private List<ResearchRequirement> requirements;
    private List<Collaboration> collaborations;

    public void createProject() {
    }
}
