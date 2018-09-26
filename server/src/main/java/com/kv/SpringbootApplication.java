package com.kv;

import com.kv.model.Role;
import com.kv.model.User;
import com.kv.repository.CustomerRepository;
import com.kv.repository.RoleRepository;
import com.kv.repository.UserRepository;
import com.kv.service.CustomUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringbootApplication {

    @Autowired
    public CustomerRepository repository;

    @Autowired
    public CustomUserDetailService customUserDetailService;

    private static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

    private final Environment env;

    public SpringbootApplication(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) {
        Environment env = SpringApplication.run(SpringbootApplication.class, args).getEnvironment();

        String protocol = "http";

        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port")
        );
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository) {

        return args -> {

            if( roleRepository.findAll().size() == 0) {
                Role newAdminRole = new Role();
                newAdminRole.setRole("ADMIN");
                roleRepository.save(newAdminRole);


                Role newUserRole = new Role();
                newUserRole.setRole("USER");
                roleRepository.save(newUserRole);
            }

            if (userRepository.findAll().size() == 0) {
                User user = new User();
                user.setEmail("vanvibig@gmail.com");
                user.setEnabled(true);
                user.setPassword("1319");
                user.setFullname("Kudo Vi");
                customUserDetailService.saveUser(user);
            }
        };
    }
}
