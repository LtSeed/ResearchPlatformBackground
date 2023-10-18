package cqu.mve.ResearchPlatformBackground.Project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import java.util.Date;

// Research Requirement Publishing
@Entity
public class ResearchRequirement {

    @jakarta.persistence.Id
    @GeneratedValue
    @Id
    private Long id;
    private String title;
    private String description;
    private Date expectedCompletionTime;
    private String category;

    public void createRequirement() {
    }

    public void editRequirement() {
    }

    public void deleteRequirement() {
    }

    public boolean check() {
        //todo 检查这个对象的各个属性是否正确被加载
        return true;
    }
}
