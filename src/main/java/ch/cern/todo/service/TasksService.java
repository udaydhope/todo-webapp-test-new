package ch.cern.todo.service;

import ch.cern.todo.model.Tasks;
import ch.cern.todo.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    @Autowired
    TaskRepo taskRepository;

    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    public Tasks getTaskById(Long id) {
        Optional<Tasks> taskOptional = taskRepository.findById(id);
        return taskOptional.orElse(null);
    }

    public Tasks createTask(Tasks task) {
        return taskRepository.save(task);
    }

    public Tasks updateTask(Long id, Tasks task) {
        if (!taskRepository.existsById(id)) {
            return null;
        }
        task.setId(id);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
