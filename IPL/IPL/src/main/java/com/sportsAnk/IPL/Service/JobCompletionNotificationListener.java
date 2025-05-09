package com.sportsAnk.IPL.Service;

import com.sportsAnk.IPL.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class JobCompletionNotificationListener  implements  JobExecutionListener{



        private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

        private final JdbcTemplate jdbcTemplate;

        public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
        public void afterJob(JobExecution jobExecution) {
            if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
                log.info("!!! JOB FINISHED! Time to verify the results");

                jdbcTemplate
                        .query("SELECT team1, team2, date FROM Match", new DataClassRowMapper<>(Match.class))
                        .forEach(match -> log.info("Found in the database.{} {} {}", match.getDate(),match.getTeam1(),match.getTeam2()));
            }
        }

}
