package cqu.mve.ResearchPlatformBackground.Project.Collaboration;

import cqu.mve.ResearchPlatformBackground.Evaluation.Evaluation;
import cqu.mve.ResearchPlatformBackground.Project.Project;
import cqu.mve.ResearchPlatformBackground.Records.AbilityStatus;
import cqu.mve.ResearchPlatformBackground.Project.ResearchRequirement;
import cqu.mve.ResearchPlatformBackground.Review.ReviewRecord;
import cqu.mve.ResearchPlatformBackground.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

// Research Requirement Browsing and Collaboration
@Entity
@Getter
@Setter
public class Collaboration {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Project project;
    @ManyToOne
    private User owner;
    @ManyToMany
    private List<User> collaborators = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private CollaborationState collaborationState;
    @ManyToOne
    private ResearchRequirement requirement;
    @ManyToOne
    private ResearchReport researchReport;
    @ManyToMany
    private List<Evaluation> evaluations;

    @ManyToOne
    private ReviewRecord reviewRecord;

    public void browseOpenRequirements() {
    }
    public void expressInterest() {
    }
    public void acceptCollaboration() {
    }
    public void submitProjectReport() {
    }

    public boolean check() {
        boolean check = true;
        switch (this.collaborationState) {
            case CLOSURE:
                check = reviewRecord.check();
            case REVIEW:
                for (User collaborator : collaborators) {
                    boolean isThisCollaboratorSubmitted = false;
                    for (Evaluation evaluation : evaluations) {
                        if(evaluation.getEvaluator().equals(this.owner)&&
                            evaluation.getEvaluatee().equals(collaborator)) {
                            isThisCollaboratorSubmitted = true;
                            break;
                        }
                    }
                    boolean isThisCollaboratorEvaluated = false;
                    for (Evaluation evaluation : evaluations) {
                        if(evaluation.getEvaluatee().equals(this.owner)&&
                                evaluation.getEvaluator().equals(collaborator)) {
                            isThisCollaboratorEvaluated = true;
                            break;
                        }
                    }
                    check = check && isThisCollaboratorSubmitted && isThisCollaboratorEvaluated;
                }
                check = check && evaluations.stream().allMatch(Evaluation::check);
            case EXECUTION:
            case MONITORING:
            case COMPLETION:
                check = check && researchReport.check();
            case PLANNING:
                check = check && requirement.check();
            case INITIATION:
                check = check && project.check();
                check = check && collaborators.isEmpty();
        }

        return check;
    }
}
