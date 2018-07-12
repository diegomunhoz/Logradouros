package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public abstract class GenericDAO {
	public void excluir (Object object){
		Session sessao = null;
		Transaction transacao = null;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			
			sessao.delete(object);
			transacao.commit();
		}catch (Exception e){
			transacao.rollback();
		}finally{
			sessao.close();
		}
	}	
	
	@SuppressWarnings("finally")
	public boolean salvar (Object object){
		Session sessao = null;
		Transaction transacao = null;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			
			sessao.saveOrUpdate(object);
			transacao.commit();
		}catch (Exception e){
			transacao.rollback();
			sessao.close();
			return false;
		}finally{
			sessao.close();
			return true;
		}
	}
}
