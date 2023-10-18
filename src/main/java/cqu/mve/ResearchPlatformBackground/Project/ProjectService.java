package cqu.mve.ResearchPlatformBackground.Project;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.Project.Repo.ProjectRepository;
import cqu.mve.ResearchPlatformBackground.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        User owner = project.getOwner();
        List<Project> projects = owner.getProjects();
        if(!projects.contains(project))
            projects.add(project);
        owner.setProjects(projects);
        return projectRepository.save(project);
    }

    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    public Optional<Project> findProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }



}