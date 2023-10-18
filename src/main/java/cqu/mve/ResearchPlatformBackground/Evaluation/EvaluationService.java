package cqu.mve.ResearchPlatformBackground.Evaluation;

import cqu.mve.ResearchPlatformBackground.Evaluation.Repo.EvaluationRepository;
import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {
    //todo 一键导出为EXCEL
    @Autowired
    private EvaluationRepository evaluationRepository;

    public Evaluation saveEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public List<Evaluation> getEvaluationsByEvaluator(User evaluator) {
        return evaluationRepository.findByEvaluator(evaluator);
    }

    public List<Evaluation> getEvaluationsByEvaluatee(User evaluatee) {
        return evaluationRepository.findByEvaluatee(evaluatee);
    }

    public List<Evaluation> getEvaluationsByCollaboration(Collaboration collaboration) {
        return evaluationRepository.findByCollaboration(collaboration);
    }

    public Optional<Evaluation> getEvaluationById(Long id) {
        return evaluationRepository.findById(id);
    }

    public void deleteEvaluation(Long id) {
        evaluationRepository.deleteById(id);
    }
}

