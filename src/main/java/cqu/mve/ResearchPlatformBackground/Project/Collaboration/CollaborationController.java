package cqu.mve.ResearchPlatformBackground.Project.Collaboration;

import cqu.mve.ResearchPlatformBackground.Project.Repo.CollaborationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collaborations")
public class CollaborationController {
    @Autowired
    private CollaborationService collaborationService;
    @Autowired
    private CollaborationRepository collaborationRepository;

    @PostMapping("/create")
    public ResponseEntity<Collaboration> createCollaboration(@RequestBody Collaboration collaboration) {
        if (!collaboration.check())
            return ResponseEntity.unprocessableEntity().build();
        return ResponseEntity.ok(collaborationService.createCollaboration(collaboration));
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Collaboration>> getCollaborationsByProjectId(@PathVariable Long projectId) {

        return ResponseEntity.ok(collaborationService.findCollaborationsByProjectId(projectId));
    }

    @PostMapping("/{collaborationId}/publish")
    public ResponseEntity<Collaboration> publishPlan(@PathVariable Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        if (!collaboration.check())
            return ResponseEntity.unprocessableEntity().build();
        return ResponseEntity.ok(collaborationService.publishPlan(collaborationId));
    }

    // 开始项目讨论
    @PostMapping("/{collaborationId}/start-discussion")
    public ResponseEntity<Collaboration> startDiscussion(@PathVariable Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        if (!collaboration.check())
            return ResponseEntity.unprocessableEntity().build();
        return ResponseEntity.ok(collaborationService.startDiscussion(collaborationId));
    }

    // 开始执行项目
    @PostMapping("/{collaborationId}/start-execution")
    public ResponseEntity<Collaboration> startExecution(@PathVariable Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        if (!collaboration.check())
            return ResponseEntity.unprocessableEntity().build();
        return ResponseEntity.ok(collaborationService.startExecution(collaborationId));
    }

    // 监控项目进度
    @PostMapping("/{collaborationId}/monitor-progress")
    public ResponseEntity<Collaboration> monitorProgress(@PathVariable Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        if (!collaboration.check())
            return ResponseEntity.unprocessableEntity().build();
        return ResponseEntity.ok(collaborationService.monitorProgress(collaborationId));
    }

    // 完成项目
    @PostMapping("/{collaborationId}/complete")
    public ResponseEntity<Collaboration> completeProject(@PathVariable Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        if (!collaboration.check())
            return ResponseEntity.unprocessableEntity().build();
        return ResponseEntity.ok(collaborationService.completeProject(collaborationId));
    }

    // 开始项目审阅
    @PostMapping("/{collaborationId}/start-review")
    public ResponseEntity<Collaboration> startReview(@PathVariable Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        if (!collaboration.check())
            return ResponseEntity.unprocessableEntity().build();
        return ResponseEntity.ok(collaborationService.startReview(collaborationId));
    }

    // 结束项目
    @PostMapping("/{collaborationId}/close")
    public ResponseEntity<Collaboration> closeProject(@PathVariable Long collaborationId) {
        Collaboration collaboration = collaborationRepository.getReferenceById(collaborationId);
        if (!collaboration.check())
            return ResponseEntity.unprocessableEntity().build();
        return ResponseEntity.ok(collaborationService.closeProject(collaborationId));
    }



}