package sia.tacocloud.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    @Enumerated(EnumType.STRING)
    private final Type type;

    public enum Type {
        MEAT, SAUCE, VEGGIE, WRAP, CHEESE
    }
}
