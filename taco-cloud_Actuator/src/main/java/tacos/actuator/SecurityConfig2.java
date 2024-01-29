package tacos.actuator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
public class SecurityConfig2 {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        RequestMatcher actuatorEndpoints = new AntPathRequestMatcher("/actuator/**");
        RequestMatcher otherEndpoints = new AndRequestMatcher(
           // new AntPathRequestMatcher("/api/ingredients", HttpMethod.POST.toString()),
            new AntPathRequestMatcher("/api/ingredients", HttpMethod.GET.toString()),
            new AntPathRequestMatcher("/api/show-submission-form")
           
        );

        http
            .authorizeRequests(authorizeRequests -> authorizeRequests
                .requestMatchers(actuatorEndpoints).hasRole("ADMIN")
                .requestMatchers(otherEndpoints).authenticated()
              
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().permitAll()
            )
            .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetails user() {
        return User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
    }

    @Bean
    public UserDetails admin() {
        return User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMIN")
            .build();
    }
}



