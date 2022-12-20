package com.rev.BasicJava8.ref.dm;

public class Job {

    private int id;
    private JobType type;

    public Job(int id, JobType type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

}
