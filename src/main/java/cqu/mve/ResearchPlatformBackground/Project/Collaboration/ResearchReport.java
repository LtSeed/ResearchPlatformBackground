package cqu.mve.ResearchPlatformBackground.Project.Collaboration;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.File;

@Entity
public class ResearchReport {

    @Id
    @GeneratedValue
    Long id;

    File report;

    public boolean check() {
        //todo 检查这个对象的各个属性是否正确被加载
        return true;
    }
}
