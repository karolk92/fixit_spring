package com.sellions.fixit.category.service;

import com.sellions.fixit.category.entity.Category;
import com.sellions.fixit.category.repository.CategoryRepository;
import com.sellions.fixit.device.entity.Device;
import com.sellions.fixit.device.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private DeviceService deviceService;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void insertCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
