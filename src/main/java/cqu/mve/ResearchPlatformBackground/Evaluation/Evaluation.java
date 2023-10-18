package cqu.mve.ResearchPlatformBackground.Evaluation;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**记录一个评价
 *
 */
@Entity
@Getter
@Setter
public class Evaluation {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User evaluator;
    @ManyToOne
    private User evaluatee;
    @ManyToOne
    private Collaboration collaboration;
    @ManyToOne
    private Aspect aspects;
    private int rating;

    public void evaluateUser() {
    }

    public boolean check() {

        //todo 检查这个对象的各个属性是否正确被加载
        return true;
    }
}
