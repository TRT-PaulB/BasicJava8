package com.rev.BasicJava8.ref.groupingBy;
import com.rev.BasicJava8.ref.dm.Job;
import com.rev.BasicJava8.ref.dm.JobType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

public class GroupByGroundsmanJob {

    public GroupByGroundsmanJob() {

    }
    private List<JobType> j8GroupingBy() {
        var golfJobs = Arrays.asList(
                new Job(1, new JobType(1, "fairway")),
                new Job(2, new JobType(2, "green")),
                new Job(3, new JobType(3,"bunker")),
                new Job(2, new JobType(4, "green")),
                new Job(1, new JobType(5, "fairway")));

        var golfJobsById = golfJobs.stream().collect(groupingBy(Job::getId));

        var results = new ArrayList<JobType>();
        golfJobsById.forEach((id, jobs) -> results.add(jobs.get(0).getType()));

        System.out.println("\nGold jobs UNSORTED");
        results.forEach(jType -> System.out.println(jType.getType()));

        return results;
    }

    private void golfJobComparator() {
        var uniqueGolfJobsList = j8GroupingBy();

        System.out.println("\nGolf jobs SORTED alphabetically");
        var sortedJobTypeList =
                uniqueGolfJobsList.stream().sorted(Comparator.comparing(JobType::getType)).collect(Collectors.toList());
        sortedJobTypeList.forEach(jType -> System.out.println(jType.getType()));
    }

}
