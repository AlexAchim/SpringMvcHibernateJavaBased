package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Answers;

public interface AnswersDAO {
	public List<Answers> list();
	
	public Answers getAnswers(int id);
	
	public void saveOrUpdateAnswers(Answers answers);
	
	public void deleteAnswer(int id);
}
