package com.cyberlabs.mycyberlabs.Project;

/**
 * Created by HadianR on 27/10/2016.
 */

public class Project {
    private String id_project,project,deadline,assigned;

    public Project(String project,String deadline,String assigned){
        project = project;
        deadline = deadline;
        assigned = assigned;
    }

    public String getAssigned(){
        return assigned;
    }
    public String getProject(){
        return project;
    }
    public String getDeadline(){
        return deadline;
    }
    public void setProject(String project){
        this.project = project;
    }
    public void setDeadline(String deadline){
        this.deadline = deadline;
    }
    public void setAssigned(String assigned){
        this.assigned = assigned;
    }
}
