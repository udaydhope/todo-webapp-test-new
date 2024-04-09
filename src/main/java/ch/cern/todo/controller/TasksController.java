package ch.cern.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasksController")
public class TasksController {


    @Autowired
    private ch.cern.todo.service.TasksService tasksService;

    @GetMapping
    public List<ch.cern.todo.model.Tasks> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ch.cern.todo.model.Tasks getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public ch.cern.todo.model.Tasks createTask(@RequestBody ch.cern.todo.model.Tasks task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public ch.cern.todo.model.Tasks updateTask(@PathVariable Long id, @RequestBody ch.cern.todo.model.Tasks task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
