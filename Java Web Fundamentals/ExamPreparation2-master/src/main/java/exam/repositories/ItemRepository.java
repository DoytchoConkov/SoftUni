package exam.repositories;

import exam.models.entities.Item;
import exam.models.views.ItemViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {
}
