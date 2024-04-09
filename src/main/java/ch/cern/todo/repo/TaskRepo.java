package ch.cern.todo.repo;

import ch.cern.todo.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

@Repository
public interface TaskRepo extends JpaRepository<Tasks,Long> {

}
