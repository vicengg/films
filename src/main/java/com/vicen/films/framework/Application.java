package com.vicen.films.framework;

import com.vicen.films.application.repository.FilmRepository;
import com.vicen.films.application.repository.StaffRepository;
import com.vicen.films.application.service.FilmService;
import com.vicen.films.application.service.FilmServiceImpl;
import com.vicen.films.application.service.StaffService;
import com.vicen.films.application.service.StaffServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public StaffService staffService(StaffRepository staffRepository) {
        return new StaffServiceImpl(staffRepository);
    }

    @Bean
    public FilmService filmService(FilmRepository filmRepository, StaffRepository staffRepository) {
        return new FilmServiceImpl(filmRepository, staffRepository);
    }

}