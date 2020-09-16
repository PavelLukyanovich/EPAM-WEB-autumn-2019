package app.web;

import app.dao.TasksDao;
import app.dao.TasksDaoUser;
import app.model.Recycle;
import app.model.Tasks;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/")
public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TasksDao tasksDAO;

	public void init() {
		tasksDAO = new TasksDaoUser();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertTask(request, response);
				break;
			case "/delete":
				deleteTask(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateTask(request, response);
				break;
			case "/list":
				listTask(request, response);
				break;
			case "/recycle":
				insertTaskToRecycle(request, response);
				break;
            case "/recycleList":
                listRecycle(request, response);
                break;
            case "/editToRecycle":
                showEditFormRecycle(request, response);
                break;
//			case "/list with date":
//				listTasksWithDate(request, response);
//				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

    private void listRecycle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Recycle> list = tasksDAO.selectAllRecycle();
        request.setAttribute("listRecycle", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("recycle/recycle.jsp");
        dispatcher.forward(request, response);
    }

    private void listTask(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Tasks> listTasks = tasksDAO.selectAllTasks();
		request.setAttribute("listTasks", listTasks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("task/task-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("task/task-form.jsp");
		dispatcher.forward(request, response);
	}
    private void showEditFormRecycle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Tasks existingTasks = tasksDAO.selectTasks(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("task/recycle-form.jsp");
        request.setAttribute("tasks", existingTasks);
        dispatcher.forward(request, response);
    }

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Tasks existingTasks = tasksDAO.selectTasks(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("task/task-form.jsp");
		request.setAttribute("tasks", existingTasks);
		dispatcher.forward(request, response);

	}
    private void insertTaskToRecycle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String description = request.getParameter("description");
        String fileName = request.getParameter("fileName");
        String userName = request.getParameter("userName");


        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        Recycle newRecycle = new Recycle(description, Date.valueOf(LocalDate.now()), isDone, userName, fileName);
        tasksDAO.insertTasksToRecycle(newRecycle);
        response.sendRedirect("recycleList");
    }



    private void insertTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String fileName = request.getParameter("fileName");
		String userName = request.getParameter("userName");
		String description = request.getParameter("description");

		boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
		Tasks newTasks = new Tasks(fileName, userName, description, Date.valueOf(LocalDate.now()), isDone);
		tasksDAO.insertTasks(newTasks);
		response.sendRedirect("list");
	}

	private void updateTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String fileName = request.getParameter("fileName");
		String userName = request.getParameter("userName");
		String description = request.getParameter("description");
		Date createDate = Date.valueOf(request.getParameter("createDate"));
		
		boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
		Tasks updateTasks = new Tasks(id, fileName, userName, description, createDate, isDone);
		
		tasksDAO.updateTasks(updateTasks);
		
		response.sendRedirect("list");
	}

	private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		tasksDAO.deleteTasks(id);
		response.sendRedirect("list");
	}
}
