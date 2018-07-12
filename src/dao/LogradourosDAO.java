package dao;

import java.util.ArrayList;
import model.Logradouros;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;



public class LogradourosDAO extends GenericDAO{
	
	public Logradouros buscarPorCodigo (int num_cep) throws Exception{
		Session sessao = null;
		Logradouros logradouro = null;

		sessao = HibernateUtil.getSessionFactory().openSession();
		logradouro = (Logradouros) sessao.get(Logradouros.class, num_cep);

		return logradouro;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Logradouros> buscarTodos() throws Exception{
		ArrayList<Logradouros> listaRetorno = new ArrayList<Logradouros>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Logradouros.class);
		
		criteria.addOrder (Order.asc("num_cep"));
		
		listaRetorno = (ArrayList<Logradouros>) criteria.list();
		
		return listaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Logradouros> pesquisarPorNome(String nome) throws Exception{
		ArrayList<Logradouros> listaRetorno = new ArrayList<Logradouros>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Logradouros.class);

		criteria.add(Restrictions.ilike("desc_logradouro", "%" + nome + "%"));

		criteria.addOrder(Order.asc("desc_logradouro"));
		
		listaRetorno = (ArrayList<Logradouros>) criteria.list();
		
		return listaRetorno;
	}
}