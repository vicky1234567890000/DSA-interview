package java8_coding_interview_questions;

import core_java.Developer;

import java.util.List;

public class Dept {
    public Dept(Integer deptId, List<Developer> developerList) {
        this.deptId = deptId;
        this.developerList = developerList;
    }

    public Dept() {
    }

    private Integer deptId;
    private List<Developer> developerList;

    public Integer getDeptId() {
        return deptId;
    }

    public List<Developer> getDeveloperList() {
        return developerList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", developerList=" + developerList +
                '}';
    }
}
