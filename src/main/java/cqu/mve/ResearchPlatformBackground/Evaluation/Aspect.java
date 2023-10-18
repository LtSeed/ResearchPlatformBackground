package cqu.mve.ResearchPlatformBackground.Evaluation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aspect {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String projectComplexity;
    private String innovativeness;
    private String teamworkLeadership;
    private String learningAbility;
    private String projectManagement;
    private String communicationSkills;
    // Getters and setters...
}
