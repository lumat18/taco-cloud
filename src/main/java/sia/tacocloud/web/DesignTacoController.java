package sia.tacocloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacocloud.Ingredient;
import sia.tacocloud.Taco;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = Arrays.asList(new Ingredient("FLTO", "wheat", Ingredient.Type.WRAP),
                new Ingredient("COTO", "corn", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "ground beef", Ingredient.Type.MEAT),
                new Ingredient("CARN", "pulled pork", Ingredient.Type.MEAT),
                new Ingredient("TMTO", "tomatos", Ingredient.Type.VEGGIE),
                new Ingredient("LETC", "lettuce", Ingredient.Type.VEGGIE),
                new Ingredient("CHED", "cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "monterey jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "salsa picante", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "sour cream", Ingredient.Type.SAUCE));
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type:types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type){
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors){
        if(errors.hasErrors()) return "design";

        log.info("Processing taco design " + design);
        return "redirect:/orders/current";
    }
}
