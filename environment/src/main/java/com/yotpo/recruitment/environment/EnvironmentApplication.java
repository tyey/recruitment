package com.yotpo.recruitment.environment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class EnvironmentApplication {

    public static void main(String[] args) throws SQLException {
        startH2Server();
        SpringApplication.run(EnvironmentApplication.class, args);
    }

    private static void startH2Server() throws SQLException {
        // Start the H2 TCP server on a specific port (e.g., 9092)
        System.out.println("Starting H2 TCP server...");
        Server h2Server = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9090", "-ifNotExists").start();
        System.out.println("H2 TCP server started: "+ h2Server.getStatus());
    }
}
