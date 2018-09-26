package com.kv;

import com.kv.config.ApplicationProperties;
import com.kv.model.Customer;
import com.kv.repositorie.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class SpringbootApplication{

    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

    private final Environment env;

    public SpringbootApplication(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) {
        Environment env = SpringApplication.run(SpringbootApplication.class, args).getEnvironment();

        String protocol = "http";
        String hostAddress = "localhost";

        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port")
        );
    }
}
