package cqu.mve.ResearchPlatformBackground.Evaluation;

import cqu.mve.ResearchPlatformBackground.User.User;

import java.util.List;

/**记录一个评价
 *
 */
public class Evaluation {
    private User evaluator;
    private User evaluatee;
    private Assessable collaboration;
    private List<String> aspects; // e.g. work quality, communication
    private int rating;

    public void evaluateUser() {
    }
}
