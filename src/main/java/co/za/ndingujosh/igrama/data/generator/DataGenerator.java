package co.za.ndingujosh.igrama.data.generator;

import co.za.ndingujosh.igrama.data.Role;
import co.za.ndingujosh.igrama.data.entity.Noun;
import co.za.ndingujosh.igrama.data.entity.User;
import co.za.ndingujosh.igrama.data.service.NounRepository;
import co.za.ndingujosh.igrama.data.service.UserRepository;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(PasswordEncoder passwordEncoder, UserRepository userRepository,
            NounRepository nounRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (userRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 2 User entities...");
            User user = new User();
            user.setName("John Normal");
            user.setUsername("user");
            user.setHashedPassword(passwordEncoder.encode("user"));
            user.setProfilePictureUrl(
                    "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
            user.setRoles(Collections.singleton(Role.USER));
            userRepository.save(user);
            User admin = new User();
            admin.setName("Emma Powerful");
            admin.setUsername("admin");
            admin.setHashedPassword(passwordEncoder.encode("admin"));
            admin.setProfilePictureUrl(
                    "https://images.unsplash.com/photo-1607746882042-944635dfe10e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
            admin.setRoles(Stream.of(Role.USER, Role.ADMIN).collect(Collectors.toSet()));
            userRepository.save(admin);
            logger.info("... generating 100 Noun entities...");
            ExampleDataGenerator<Noun> nounRepositoryGenerator = new ExampleDataGenerator<>(Noun.class,
                    LocalDateTime.of(2021, 12, 29, 0, 0, 0));
            nounRepositoryGenerator.setData(Noun::setId, DataType.ID);
            nounRepositoryGenerator.setData(Noun::setNounPrefix, DataType.WORD);
            nounRepositoryGenerator.setData(Noun::setRoot, DataType.WORD);
            nounRepositoryGenerator.setData(Noun::setNounClass, DataType.NUMBER_UP_TO_10);
            nounRepositoryGenerator.setData(Noun::setTranslations, DataType.TWO_WORDS);
            nounRepositoryGenerator.setData(Noun::setIsPlural, DataType.BOOLEAN_50_50);
            nounRepository.saveAll(nounRepositoryGenerator.create(100, seed));

            logger.info("Generated demo data");
        };
    }

}