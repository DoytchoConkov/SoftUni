package exam.services;

import exam.models.service.ItemServiceModel;
import exam.models.views.ItemViewModel;

import java.util.List;

public interface ItemService {

    void addItem(ItemServiceModel itemServiceModel);
    List<ItemViewModel> allItems();

    ItemViewModel findById(String id);

    void delete(String id);
}
