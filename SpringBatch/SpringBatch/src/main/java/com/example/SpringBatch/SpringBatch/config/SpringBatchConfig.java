package com.example.SpringBatch.SpringBatch.config;

import com.example.SpringBatch.SpringBatch.model.Person;
import com.example.SpringBatch.SpringBatch.repository.PersonRepo;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.batch.infrastructure.item.data.RepositoryItemWriter;
import org.springframework.batch.infrastructure.item.database.JpaItemWriter;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.infrastructure.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.infrastructure.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SpringBatchConfig {

    @Autowired
    PersonRepo personRepo;

    @Bean
    public FlatFileItemReader<Person> reader() {

        BeanWrapperFieldSetMapper<Person> fieldSetMapper =
                new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Person.class);

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        tokenizer.setStrict(false);
        tokenizer.setNames("person_id","login_name","first_name","last_name","email","phone","address");

        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        FlatFileItemReader<Person> reader = new FlatFileItemReader<>(lineMapper);
        reader.setName("personItemReader");
        reader.setResource(new ClassPathResource("persons.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper);
        return reader;
    }

    @Bean
    public ItemProcessor<Person, Person> processor() {
        return person -> {
            person.setFirst_name(person.getFirst_name().toUpperCase());
            person.setLast_name(person.getLast_name().toUpperCase());
            return person;
        };
    }

    @Bean
    public RepositoryItemWriter<Person> writer() {
        RepositoryItemWriter<Person> writer = new RepositoryItemWriter<>(personRepo);
       writer.setRepository(personRepo);
       writer.setMethodName("save");
        return writer;
    }


    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("importPersonJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("import person step",jobRepository)
                .<Person, Person>chunk(1000)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .transactionManager(transactionManager)
                .build();
    }
}
