package app.dao;

import java.sql.SQLException;
import java.util.List;

import app.model.Recycle;
import app.model.Tasks;

public interface TasksDao {

	void insertTasks(Tasks tasks) throws SQLException;

	void insertTasksToRecycle(Recycle recycle) throws SQLException;

    List<Recycle> selectAllRecycle();

	Tasks selectTasks(int id);

	List<Tasks> selectAllTasks();

	boolean deleteTasks(int id) throws SQLException;

	boolean updateTasks(Tasks tasks) throws SQLException;

}