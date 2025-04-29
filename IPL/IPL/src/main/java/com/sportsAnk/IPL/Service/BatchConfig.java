package com.sportsAnk.IPL.Service;


import com.sportsAnk.IPL.model.Match;
import com.sportsAnk.IPL.model.MatchInput;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;


    @Autowired
    DataSource dataSource;

//    @Bean
//    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

  private  final String[] fieldNames = new String[]{
          "id","season","city","date","match_type","player_of_match","venue","team1","team2","toss_winner","toss_decision","winner",
          "result","result_margin","target_runs","target_overs","super_over","method","umpire1","umpire2"
  };
    @Bean
    public FlatFileItemReader<MatchInput> reader() {
        return new FlatFileItemReaderBuilder<MatchInput>()
                .name("personItemReader")
                .resource(new ClassPathResource("matches.csv"))
                .delimited()
                .names(fieldNames)
                .targetType(MatchInput.class)
                .build();
    }

    @Bean
    public MatchDataProcessor processor() {
        return new MatchDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Match>()
                .sql("INSERT INTO Match (id ,city ,date ,season ,matchNumber,team1,team2,venue,toss_winner,toss_decision ,super_over,target_runs,target_overs,winner,result,result_margin,method,player_of_match,Umpire1 ,umpire2 ,match_type)" +
                        " VALUES (:id ,:city ,:date ,:season ,:matchNumber,:team1,:team2,:venue,:toss_winner,:toss_decision ,:super_over,:target_runs,:target_overs,:winner,:result,:result_margin,:method,:player_of_match,:Umpire1 ,:umpire2 ,:match_type)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

    @Bean
    public Job importUserJob( Step step1, JobCompletionNotificationListener listener) {
        return new JobBuilder("importUserJob")
                .listener(listener)
                .start(step1)
                .build();
    }
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public Step step1( DataSourceTransactionManager transactionManager,
                      FlatFileItemReader<MatchInput> reader, MatchDataProcessor processor, JdbcBatchItemWriter<Match> writer) {
        return new StepBuilder("step1")
                .<MatchInput, Match>chunk(3)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
