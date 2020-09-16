package app.dao;

import app.model.Recycle;
import app.model.Tasks;
import app.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TasksDaoUser implements TasksDao {

	private static final String INSERT_TASKS_SQL = "INSERT INTO tasks"
			+ "  (description, createDate, state,  userName, fileName) VALUES " + " (?, ?, ?, ?, ?);";
    private static final String INSERT_TASKS_TO_RECYCLE_SQL = "INSERT INTO recycle"
            + "  (description, createDate, state,  userName, fileName) VALUES " + " (?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_RECYCLES = "select * from recycle";
	private static final String SELECT_TASKS_BY_ID = "select id,description,createDate,state,userName,fileName from tasks where id =?";
	private static final String SELECT_ALL_TASKS = "select * from tasks";
	private static final String DELETE_TASKS_BY_ID = "delete from tasks where id = ?;";
	private static final String UPDATE_TASKS = "update tasks set description = ?, createDate= ?, state =?, userName =?, fileName = ? where id = ?;";

	public TasksDaoUser() {
	}

	@Override
	public void insertTasks(Tasks tasks) throws SQLException {
		System.out.println(INSERT_TASKS_SQL);
		try (Connection connection = JDBCUtils.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASKS_SQL)) {
			preparedStatement.setString(1, tasks.getDescription());
			preparedStatement.setDate(2, tasks.getCreateDate());
			preparedStatement.setBoolean(3, tasks.getState());
			preparedStatement.setString(4, tasks.getUserName());
			preparedStatement.setString(5, tasks.getfileName());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}

    @Override
    public void insertTasksToRecycle(Recycle recycle) throws SQLException {
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASKS_TO_RECYCLE_SQL)) {
            preparedStatement.setString(1, recycle.getDescription());
            preparedStatement.setDate(2, recycle.getCreateDate());
            preparedStatement.setBoolean(3, recycle.getState());
            preparedStatement.setString(4, recycle.getUserName());
            preparedStatement.setString(5, recycle.getFileName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
    }

    @Override
    public List<Recycle> selectAllRecycle() {
        List<Recycle> recycles = new ArrayList<>();

        try (Connection connection = JDBCUtils.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RECYCLES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("description");
                Date createDate = rs.getDate("createDate");
                boolean isDone = rs.getBoolean("state");
                String userName = rs.getString("userName");
                String fileName = rs.getString("fileName");
                recycles.add(new Recycle(id, description, createDate, isDone,  userName, fileName));
            }
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return recycles;
    }


    @Override
	public Tasks selectTasks(int id ) {
		Tasks tasks = null;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASKS_BY_ID);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Integer idTasks = rs.getInt("id");
				String description = rs.getString("description");
				Date createDate = rs.getDate("createDate");
				boolean state = rs.getBoolean("state");
				String userName = rs.getString("userName");
				String fileName = rs.getString("fileName");
				tasks = new Tasks(idTasks, description, createDate, state, userName, fileName);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return tasks;
	}

	@Override
	public List<Tasks> selectAllTasks() {

		List<Tasks> tasks = new ArrayList<>();

		try (Connection connection = JDBCUtils.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TASKS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int idTasks = rs.getInt("id");
				String description = rs.getString("description");
				Date createDate = rs.getDate("createDate");
				boolean isDone = rs.getBoolean("state");
				String userName = rs.getString("userName");
				String fileName = rs.getString("fileName");
				tasks.add(new Tasks(idTasks, description, createDate, isDone,  userName, fileName));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return tasks;
	}

    @Override
	public boolean deleteTasks(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TASKS_BY_ID);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	@Override
	public boolean updateTasks(Tasks tasks) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TASKS);) {
			statement.setLong(1, tasks.getId());
			statement.setString(2, tasks.getDescription());
			statement.setDate(3, tasks.getCreateDate());
			statement.setBoolean(4, tasks.getState());
			statement.setString(5, tasks.getUserName());
			statement.setString(6, tasks.getfileName());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
