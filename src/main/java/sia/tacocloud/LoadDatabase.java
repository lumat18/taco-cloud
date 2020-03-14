package sia.tacocloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sia.tacocloud.domain.Ingredient;
import sia.tacocloud.repository.IngredientRepository;

import java.util.List;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(IngredientRepository ingredientRepository) {
        return args -> {
            log.info("Preloading ingredient database");
            List<Ingredient> ingredients = List.of(
                    new Ingredient("FLTO", "wheat", Ingredient.Type.WRAP),
                    new Ingredient("COTO", "corn", Ingredient.Type.WRAP),
                    new Ingredient("GRBF", "ground beef", Ingredient.Type.MEAT),
                    new Ingredient("CARN", "pulled pork", Ingredient.Type.MEAT),
                    new Ingredient("TMTO", "tomatos", Ingredient.Type.VEGGIE),
                    new Ingredient("LETC", "lettuce", Ingredient.Type.VEGGIE),
                    new Ingredient("CHED", "cheddar", Ingredient.Type.CHEESE),
                    new Ingredient("JACK", "monterey jack", Ingredient.Type.CHEESE),
                    new Ingredient("SLSA", "salsa picante", Ingredient.Type.SAUCE),
                    new Ingredient("SRCR", "sour cream", Ingredient.Type.SAUCE));

            ingredientRepository.saveAll(ingredients);
        };
    }
}
