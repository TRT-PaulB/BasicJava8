package com.rev.BasicJava8.ref.optional;

import com.rev.BasicJava8.ref.dm.Job;
import com.rev.BasicJava8.ref.dm.JobType;

import java.util.*;

public class OptionalOpter {

    public OptionalOpter() {
        getFirstMaxValue();
    }

    private void getFirstMaxValue() {
        try {
            Job maxJob = cheekyMaxOrElseThrow(getJobs());
            System.out.println("Max job priority = " + maxJob.getPriority());

            System.out.println("Now try with no jobs in the list, so no max is possible");
            cheekyMaxOrElseThrow(new ArrayList<Job>());
        } catch(IllegalStateException e) {
            System.out.println("oops.... " + e.getMessage());
        }
    }

    private Job cheekyMaxOrElseThrow(List<Job> jobs) {
        Optional<Job> maxResult = jobs.stream().max(Comparator.comparing(Job::getPriority));
        return maxResult.orElseThrow(() -> new IllegalStateException("Failed to map jobs by priority"));
    }

    private List<Job> getJobs() {
        return Arrays.asList(
                new Job(1, new JobType(1, "fairway"), 4),
                new Job(2, new JobType(2, "green"), 8),
                new Job(3, new JobType(3,"bunker"), 1),
                new Job(4, new JobType(4, "green"), 2),

                new Job(5, new JobType(1, "fairway"), 9),
                new Job(6, new JobType(2, "green"), 15),
                new Job(7, new JobType(3,"bunker"), 4),
                new Job(8, new JobType(4, "green"), 6),

                new Job(9, new JobType(1, "fairway"), 15),
                new Job(10, new JobType(2, "green"), 3),
                new Job(11, new JobType(3,"bunker"), 9),
                new Job(12, new JobType(4, "green"), 1),

                new Job(13, new JobType(1, "fairway"), 1),
                new Job(14, new JobType(2, "green"), 7),
                new Job(15, new JobType(3,"bunker"), 3),
                new Job(16, new JobType(4, "green"), 3),

                new Job(17, new JobType(5, "fairway")));
    }

}
