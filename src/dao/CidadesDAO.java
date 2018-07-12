package dao;

import java.util.ArrayList;
import model.Cidades;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;



public class CidadesDAO extends GenericDAO{
	
	public Cidades buscarPorCodigo (int cidade_id) throws Exception{
		Session sessao = null;
		Cidades cidade = null;

		sessao = HibernateUtil.getSessionFactory().openSession();
		cidade = (Cidades) sessao.get(Cidades.class, cidade_id);

		return cidade;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cidades> buscarTodos() throws Exception{
		ArrayList<Cidades> listaRetorno = new ArrayList<Cidades>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Cidades.class);
		
		criteria.addOrder (Order.asc("cidade_id"));
		
		listaRetorno = (ArrayList<Cidades>) criteria.list();
		
		return listaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cidades> pesquisarPorNome(String desc_cidade) throws Exception{
		ArrayList<Cidades> listaRetorno = new ArrayList<Cidades>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Cidades.class);

		criteria.add(Restrictions.ilike("desc_cidade", "%" + desc_cidade + "%"));

		criteria.addOrder(Order.asc("desc_cidade"));
		
		listaRetorno = (ArrayList<Cidades>) criteria.list();
		
		return listaRetorno;
	}
}