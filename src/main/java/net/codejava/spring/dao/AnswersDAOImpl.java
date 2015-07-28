package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Answers;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;

@Repository
public class AnswersDAOImpl implements AnswersDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public AnswersDAOImpl(){
		
	}
	
	public AnswersDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Answers> list(){
		@SuppressWarnings("unchecked")
		List<Answers> listAnswers = (List<Answers>) sessionFactory.getCurrentSession()
										.createCriteria(Answers.class)										
										.list();
		
		return listAnswers;
	}
	
	@Override
	@Transactional
	public void saveOrUpdateAnswers(Answers answers){
		sessionFactory.getCurrentSession().saveOrUpdate(answers);
	}
	
	@Override
	@Transactional
	public void deleteAnswer(int id){
		Answers answersToDelete = new Answers();
		answersToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(answersToDelete);
	}
	
	@Override
	@Transactional
	public Answers getAnswers(int id){
		String hql = "from answers"; // where id =" +id ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Answers> listAnswers = (List<Answers>) query.list();
		
		if(listAnswers != null && !listAnswers.isEmpty()){
			return (Answers) listAnswers;
		}
		return null;
	}
}
