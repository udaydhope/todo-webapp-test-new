package src.main.java.ch.cern.todo.service;

import java.util.List;
import java.util.Optional;

public class TaskCategoryService {

    @Autowired
    private ch.cern.todo.repo.TaskCategoriesRepo taskCategoryRepository;

    public List<ch.cern.todo.model.TaskCategories> getAllCategories() {
        return taskCategoryRepository.findAll();
    }

    public ch.cern.todo.model.TaskCategories getCategoryById(Long id) {
        Optional<ch.cern.todo.model.TaskCategories> categoryOptional = taskCategoryRepository.findById(id);
        return categoryOptional.orElse(null);
    }

    public ch.cern.todo.model.TaskCategories createCategory(ch.cern.todo.model.TaskCategories category) {
        return taskCategoryRepository.save(category);
    }

    public ch.cern.todo.model.TaskCategories updateCategory(Long id, ch.cern.todo.model.TaskCategories category) {
        if (!taskCategoryRepository.existsById(id)) {
            return null;
        }
        category.setId(id);
        return taskCategoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        taskCategoryRepository.deleteById(id);
    }



}
