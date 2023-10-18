package cqu.mve.ResearchPlatformBackground.Evaluation;

import cqu.mve.ResearchPlatformBackground.Records.AbilityStatus;
import cqu.mve.ResearchPlatformBackground.User.User;
import jakarta.persistence.Entity;

public interface Assessable {

    AbilityStatus assess(User user);
}
