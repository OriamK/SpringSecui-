package com.mario.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mario.pojo.Administrador;
import com.mario.pojo.Direccion;

@Transactional
@Repository
public class DireccionDaoImpl implements DireccionDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Direccion direccion) {
	
		getSession().save(direccion);
		
	}

	@Override
	public List<Direccion> selectAll(Administrador administrador) {
		
		Criteria criteria = getSession().createCriteria(Direccion.class).
				setFetchMode("administrador", FetchMode.JOIN).
				add(Restrictions.eq("administrador.idAd", administrador.getIdAd())).
				setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		
		return criteria.list();
	}

	
	
}
