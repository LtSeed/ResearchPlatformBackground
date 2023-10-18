package cqu.mve.ResearchPlatformBackground.Project.Collaboration;

import cqu.mve.ResearchPlatformBackground.Project.Repo.CollaborationRepository;
import cqu.mve.ResearchPlatformBackground.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaborationService {
    @Autowired
    private CollaborationRepository collaborationRepository;

    public Collaboration createCollaboration(Collaboration collaboration) {
        collaboration.setCollaborationState(CollaborationState.INITIATION);
        for (User collaborator : collaboration.getCollaborators()) {
            List<Collaboration> collaborations = collaborator.getCollaborations();
            if(!collaborations.contains(collaboration))
                collaborations.add(collaboration);
            collaborator.setCollaborations(collaborations);
        }
        return collaborationRepository.save(collaboration);
    }

    public Collaboration publishPlan(Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        collaboration.setCollaborationState(CollaborationState.PLANNING);
        return collaborationRepository.save(collaboration);
    }

    public List<Collaboration> findCollaborationsByProjectId(Long projectId) {
        return collaborationRepository.findByProjectId(projectId);
    }

    public Collaboration startDiscussion(Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        collaboration.setCollaborationState(CollaborationState.EXECUTION);
        return collaborationRepository.save(collaboration);
    }

    public Collaboration closeProject(Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        collaboration.setCollaborationState(CollaborationState.CLOSURE);
        return collaborationRepository.save(collaboration);
    }

    public Collaboration startReview(Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        collaboration.setCollaborationState(CollaborationState.REVIEW);
        return collaborationRepository.save(collaboration);
    }

    public Collaboration completeProject(Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        collaboration.setCollaborationState(CollaborationState.COMPLETION);
        return collaborationRepository.save(collaboration);
    }

    public Collaboration monitorProgress(Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        collaboration.setCollaborationState(CollaborationState.MONITORING);
        return collaborationRepository.save(collaboration);
    }

    public Collaboration startExecution(Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        collaboration.setCollaborationState(CollaborationState.EXECUTION);
        return collaborationRepository.save(collaboration);
    }
}