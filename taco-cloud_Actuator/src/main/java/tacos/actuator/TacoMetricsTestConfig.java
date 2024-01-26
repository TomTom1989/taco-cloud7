/*package tacos.actuator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tacos.actuator.TacoMetrics;
import tacos.Taco;
import tacos.Ingredient;

@Configuration
public class TacoMetricsTestConfig {

    @Bean
    public CommandLineRunner testTacoMetrics(TacoMetrics tacoMetrics) {
        return args -> {
            // Create a dummy Taco object for testing
            Taco dummyTaco = new Taco();
            dummyTaco.setName("Test Taco");

            // Add some dummy ingredients
            dummyTaco.addIngredient(new Ingredient("ING1", "Ingredient 1", Ingredient.Type.WRAP));
            dummyTaco.addIngredient(new Ingredient("ING2", "Ingredient 2", Ingredient.Type.PROTEIN));
            dummyTaco.addIngredient(new Ingredient("ING1", "Ingredient 1", Ingredient.Type.WRAP));

            // Manually invoke the onAfterCreate method
            tacoMetrics.onAfterCreate(dummyTaco);

            // Check your console logs to see if the TacoMetrics logic is executed
        };
    }
}*/
