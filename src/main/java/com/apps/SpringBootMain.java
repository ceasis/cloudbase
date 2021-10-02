package com.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringBootMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }

    @EventListener({ ApplicationReadyEvent.class })
    public void applicationReadyEvent() {

        // Add code here that will run when the spring boot app completed initializing.
        System.out.println("****************************************************");
        System.out.println("* STARTING YOUR APPLICATION ...                    *");
        System.out.println("****************************************************");
    }
}
