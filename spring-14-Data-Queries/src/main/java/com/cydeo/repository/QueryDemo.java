package com.cydeo.repository;

import org.springframework.boot.CommandLineRunner;

public class QueryDemo implements CommandLineRunner {
    private final RegionRepository regionRepository;

    public QueryDemo(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @Override
    public void run(String... args) throws Exception {


        System.out.println("findByCountry" + regionRepository.findByCountry("Canada"));

    }
}
