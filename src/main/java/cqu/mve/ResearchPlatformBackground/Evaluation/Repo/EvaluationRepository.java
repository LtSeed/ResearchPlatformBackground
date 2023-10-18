package cqu.mve.ResearchPlatformBackground.Evaluation.Repo;

import cqu.mve.ResearchPlatformBackground.Evaluation.Evaluation;
import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findByEvaluator(User evaluator);
    List<Evaluation> findByEvaluatee(User evaluatee);
    List<Evaluation> findByCollaboration(Collaboration collaboration);
}
