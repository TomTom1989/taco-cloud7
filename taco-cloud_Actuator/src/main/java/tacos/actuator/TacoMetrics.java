package tacos.actuator;
import java.util.List;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;
import io.micrometer.core.instrument.MeterRegistry;
import tacos.Ingredient;
import tacos.Taco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class TacoMetrics extends AbstractRepositoryEventListener<Taco> {
    private static final Logger log = LoggerFactory.getLogger(TacoMetrics.class);
	
	
 private MeterRegistry meterRegistry;
 public TacoMetrics(MeterRegistry meterRegistry) {
 this.meterRegistry = meterRegistry;
 }
 @Override
public void onAfterCreate(Taco taco) {
	 log.info("onAfterCreate - Taco created: {}", taco);
	 
	 List<Ingredient> ingredients = taco.getIngredients();
	    for (Ingredient ingredient : ingredients) {
	        log.info("Incrementing counter for ingredient: {}", ingredient.getId());
	        meterRegistry.counter("tacocloud", "ingredient", ingredient.getId()).increment();
	    }
	}
}

//CURL COMMANDS:
//curl localhost:8081/actuator/metrics/tacocloud

//curl localhost:8081/actuator/metrics/tacocloud?tag=ingredient:FLTO