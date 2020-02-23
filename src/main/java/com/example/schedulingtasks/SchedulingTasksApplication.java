package com.example.schedulingtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableScheduling
public class SchedulingTasksApplication {

	private static final Logger log = LoggerFactory.getLogger(SchedulingTasksApplication.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


	public static void main(String[] args) {

		//this is application context because I am using method to run my application.
		ApplicationContext applicationContext = SpringApplication.run(SchedulingTasksApplication.class, args);


		//At this point you would have all your queryId and queryes
		int queryId = 45;
		String query = "Some query";
		long period = 5000; //time to schedule. in miliseconds . 5000 = 5sec.

		//Getting an object of service. In your case this should come from @autowired.
		ScheduleTaskService scheduleTaskService = applicationContext.getBean(ScheduleTaskService.class);
		scheduleTaskService.addTaskToScheduler(1, new Runnable(){
			//this is the method which is being scheduled
			public void run(){
				log.info("The time is now {}", dateFormat.format(new Date()));
			}
		}, period);

		// U can run loop from 34 to 46 for every queryId, query  and period.






	}

}
