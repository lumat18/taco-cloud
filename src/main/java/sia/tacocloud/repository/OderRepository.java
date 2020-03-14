package sia.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.Order;

public interface OderRepository extends CrudRepository<Order, Long> {
}
