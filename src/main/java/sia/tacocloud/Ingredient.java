package sia.tacocloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {
    private final Long id;
    private final String name;
    private final Type type;

    private enum Type {
        MEAT, SAUCE, VEGGIE, WRAP, CHEESE
    }
}
