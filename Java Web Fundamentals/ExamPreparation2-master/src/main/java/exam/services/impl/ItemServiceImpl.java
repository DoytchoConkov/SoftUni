package exam.services.impl;

import exam.models.entities.Category;
import exam.models.entities.Item;
import exam.models.service.CategoryServiceModel;
import exam.models.service.ItemServiceModel;
import exam.models.views.ItemViewModel;
import exam.repositories.ItemRepository;
import exam.services.CategoryService;
import exam.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        Item item = modelMapper.map(itemServiceModel, Item.class);
        Category category = this.categoryService.findByCategoryName(itemServiceModel.getCategory().getName());
        item.setCategory(category);
        this.itemRepository.save(item);
    }

    @Override
    public List<ItemViewModel> allItems() {
        return this.itemRepository.findAll().stream().map(item -> {
            ItemViewModel itemViewModel = modelMapper.map(item, ItemViewModel.class);
            itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName()));
            return itemViewModel;
        }).collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {
        Item item = this.itemRepository.findById(id).get();
        ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);
        itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName()));
        return itemViewModel;
    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteById(id);
    }
}
