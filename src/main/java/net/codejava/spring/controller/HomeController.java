package net.codejava.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.codejava.spring.dao.AnswersDAO;
import net.codejava.spring.dao.AnswersDAOImpl;
import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.Answers;
import net.codejava.spring.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserDAO userDao;
	@Autowired
	private AnswersDAO answersDAO;	
	
	/*
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<User> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("userList", listUsers);
		return model;
	}
	*/
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<Answers> answersList = answersDAO.list();
		ModelAndView model = new ModelAndView("AnswersList");
		model.addObject("answersList", answersList);
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", new User());
		return model;		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userDao.get(userId);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", user);
		return model;		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		userDao.delete(userId);
		return new ModelAndView("redirect:/");		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		userDao.saveOrUpdate(user);
		return new ModelAndView("redirect:/");
	}
	
	//@RequestMapping(value = "/answers", method = RequestMethod.GET)
	//@Path("/answers")
	//@GET
	//@Produces(MediaType.APPLICATION_JSON)
	
	@RequestMapping(value = "/answers", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON)
	// @ResponseBody
	public ModelAndView answers() throws Exception {
		List<Answers> answersList = answersDAO.list();
		ModelAndView model = new ModelAndView("answers");
		model.addObject("answers", answersList);
		return model;
	}
	
}
