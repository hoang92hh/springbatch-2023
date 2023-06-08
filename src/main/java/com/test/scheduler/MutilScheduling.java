package com.test.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class MutilScheduling {

    private SchedulerFactory schedulerFactory;
    private List<Scheduler> schedulerList;


    @Autowired
    SchedulingProperties schedulingProperties;

    @PostConstruct
    public void start() throws SchedulerException, ClassNotFoundException {

        schedulerFactory = new StdSchedulerFactory();
        schedulerList = new ArrayList<>();


        String jobExeClass = schedulingProperties.getExeClass().get(0);
        String jobCronExpression = schedulingProperties.getCronExpression().get(0);
        String jobDescription = schedulingProperties.getDescription().get(0);


        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        Class<? extends Job> jobIsExecute = (Class <? extends Job> ) Class.forName(jobExeClass);
        JobDetail jobDetail =JobBuilder.newJob(jobIsExecute).withIdentity("Job1").build();

        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(jobCronExpression)).build();

        scheduler.scheduleJob(jobDetail, trigger);


    }

}
