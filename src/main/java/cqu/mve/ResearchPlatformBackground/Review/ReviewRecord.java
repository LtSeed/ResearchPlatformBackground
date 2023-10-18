package cqu.mve.ResearchPlatformBackground.Review;


import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ReviewRecord {

    @Id
    @GeneratedValue
    Long id;

    Long reviewerId;

    @ManyToOne
    Collaboration collaboration;

    int reviewedCompletingTime;

    String note;

    boolean accepted;

    public boolean check() {
        //todo 检查这个对象的各个属性是否正确被加载
        return true;
    }
}
