package com.example.jpa.config;

import com.example.jpa.JpaRepositoryMaker;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackageClasses = {JpaRepositoryMaker.class})
@EntityScan(basePackageClasses = {JpaRepositoryMaker.class})
@EnableTransactionManagement
public class DataSourceConfig {}
