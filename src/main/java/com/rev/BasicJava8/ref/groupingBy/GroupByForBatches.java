package com.rev.BasicJava8.ref.groupingBy;
import com.rev.BasicJava8.ref.dm.Job;
import com.rev.BasicJava8.ref.dm.JobType;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class GroupByForBatches {

    private final static int BATCH_SIZE = 4;

    private final List<Job> jobs = getJobs();

    private List<Integer> jobIds = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);

    public GroupByForBatches() {
        List<Job>  allJobsFromIds = getJobsViaBatches(jobIds);
        System.out.println("Created a list of all jobs (17) via batches of job ids. Num jobs = " + allJobsFromIds.size());
    }

    private List<Job> getJobsViaBatches(List<Integer> jobIds) {
        if (isNull(jobIds) || jobIds.isEmpty()) {
            return Collections.emptyList();
        }

        final AtomicInteger counter = new AtomicInteger();
        final List<List<Integer>> batchedJobIds = new ArrayList<>(
            jobIds.stream().collect(Collectors.groupingBy(it -> counter.getAndIncrement() / BATCH_SIZE)).values());

        List<Job> fullJobList = batchedJobIds.stream().map(this::getBatchOfJobs).
                flatMap(List::stream).collect(Collectors.toList());

        return fullJobList;
    }


    private List<Job> getBatchOfJobs(List<Integer> jobIds) {
        return jobs.stream().filter(j -> jobIds.contains(j.getId())).collect(Collectors.toList());
    }

    private List<Job> getJobs() {
        return Arrays.asList(
                new Job(1, new JobType(1, "fairway")),
                new Job(2, new JobType(2, "green")),
                new Job(3, new JobType(3,"bunker")),
                new Job(4, new JobType(4, "green")),

                new Job(5, new JobType(1, "fairway")),
                new Job(6, new JobType(2, "green")),
                new Job(7, new JobType(3,"bunker")),
                new Job(8, new JobType(4, "green")),

                new Job(9, new JobType(1, "fairway")),
                new Job(10, new JobType(2, "green")),
                new Job(11, new JobType(3,"bunker")),
                new Job(12, new JobType(4, "green")),

                new Job(13, new JobType(1, "fairway")),
                new Job(14, new JobType(2, "green")),
                new Job(15, new JobType(3,"bunker")),
                new Job(16, new JobType(4, "green")),

                new Job(17, new JobType(5, "fairway")));
    }


}
