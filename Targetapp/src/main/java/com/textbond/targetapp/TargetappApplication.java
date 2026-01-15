package com.textbond.targetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication// This annotation is a combination of three annotation which is
/*
1,@Configuration -> this means this has the spring Rules it tells spring this class contains CONFIGURATION INSTRUCTION
2,@EnableAutoConfiguration -> well here Spring automatically set all the dependency we say it in XML
3,@ComponentScan->This say spring to create a IOC for all the class we say it to create Bean

 */
public class TargetappApplication {

    public static void main(String[] args) {
        SpringApplication.run(TargetappApplication.class, args);
        /*
        Important
        SpringApplication.run() What this does is it Create the IOC(Application Container)
        and this where all the Beans live
        Finds all the componentScan(in sort finds all the class where it should create the bean)
        it enables @EnableAutoConfiguration sets DB,server,securitys etc
        Starts tomcat Servers(Which is inside savalet)
        In short
        @SpringBootApplication → defines WHAT to load
        SpringApplication.run → actually LOADS and RUNS it

         */
    }

}
