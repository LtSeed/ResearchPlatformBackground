package cqu.mve.ResearchPlatformBackground.Project.Collaboration;

import cqu.mve.ResearchPlatformBackground.Records.AbilityStatus;
import cqu.mve.ResearchPlatformBackground.Evaluation.Assessable;
import cqu.mve.ResearchPlatformBackground.Message.MessageSystem;
import cqu.mve.ResearchPlatformBackground.Project.ResearchRequirement;
import cqu.mve.ResearchPlatformBackground.Review.Reviewable;
import cqu.mve.ResearchPlatformBackground.User.User;

// Research Requirement Browsing and Collaboration
public class Collaboration implements Assessable, Reviewable {
    private User collaborator;
    private State state;
    private ResearchRequirement requirement;
    private MessageSystem messageSystem;

    public void browseOpenRequirements() {
    }

    public void expressInterest() {
    }

    public void acceptCollaboration() {
    }

    public void submitProjectReport() {
    }

    @Override
    public AbilityStatus assess() {
        return null;
    }
}
