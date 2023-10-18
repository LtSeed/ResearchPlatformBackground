package cqu.mve.ResearchPlatformBackground.Project;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Getter
@Setter
public class Project {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String expectedCompletionTime;
    private String category;

    @ManyToOne
    private User owner;
    @ManyToMany
    private List<Collaboration> collaborations;

    public boolean check() {
        //todo 检查这个对象的各个属性是否正确被加载
        return true;
    }


    // ... other fields, getters, setters, etc.
}