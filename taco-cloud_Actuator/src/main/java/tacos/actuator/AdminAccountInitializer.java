/*package tacos.actuator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tacos.data.UserRepository;
import tacos.AppUser;

@Component
public class AdminAccountInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminAccountInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner createAdminUser() {
        return args -> {
            if (userRepository.findByUsername("admin") == null) {
                AppUser adminUser = new AppUser("admin", passwordEncoder.encode("password"), "Admin", "Admin Street", "Admin City", "Admin State", "12345", "123-456-7890");
              
                userRepository.save(adminUser);
            }
        };
    }
}*/
