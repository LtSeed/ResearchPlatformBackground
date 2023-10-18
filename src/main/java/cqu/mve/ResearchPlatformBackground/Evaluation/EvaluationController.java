package cqu.mve.ResearchPlatformBackground.Evaluation;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @PostMapping
    public ResponseEntity<Evaluation> createEvaluation(@RequestBody Evaluation evaluation) {
        return ResponseEntity.ok(evaluationService.saveEvaluation(evaluation));
    }

    @GetMapping("/evaluator/{evaluatorId}")
    public ResponseEntity<List<Evaluation>> getEvaluationsByEvaluator(@PathVariable Long evaluatorId) {
        User evaluator = new User();
        evaluator.setId(evaluatorId);
        return ResponseEntity.ok(evaluationService.getEvaluationsByEvaluator(evaluator));
    }

    @GetMapping("/evaluatee/{evaluateeId}")
    public ResponseEntity<List<Evaluation>> getEvaluationsByEvaluatee(@PathVariable Long evaluateeId) {
        User evaluatee = new User();
        evaluatee.setId(evaluateeId);
        return ResponseEntity.ok(evaluationService.getEvaluationsByEvaluatee(evaluatee));
    }

    @GetMapping("/collaboration/{collaborationId}")
    public ResponseEntity<List<Evaluation>> getEvaluationsByCollaboration(@PathVariable Long collaborationId) {
        Collaboration collaboration = new Collaboration();
        collaboration.setId(collaborationId);
        return ResponseEntity.ok(evaluationService.getEvaluationsByCollaboration(collaboration));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluationById(@PathVariable Long id) {
        Optional<Evaluation> evaluation = evaluationService.getEvaluationById(id);
        return evaluation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id) {
        evaluationService.deleteEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
