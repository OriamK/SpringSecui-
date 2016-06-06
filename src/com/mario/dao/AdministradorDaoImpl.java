package com.mario.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mario.pojo.Administrador;
import com.mario.pojo.AdministradorRowMapper;

@Transactional
@Repository
public class AdministradorDaoImpl implements AdministradorDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Administrador administrador) {

		getSession().save(administrador);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrador> selectAll() {

		Query query = getSession().createQuery("from Administrador"); // select
																		// *
																		// from
																		// administrador

		return query.list();
	}

	@Override
	public Administrador findById(int id) {

		Criteria crit = getSession().createCriteria(Administrador.class);
		crit.add(Restrictions.eq("idAd", id));

		return (Administrador) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrador> findByNombre(String nombre) {

		Criteria crit = getSession().createCriteria(Administrador.class);
		crit.add(Restrictions.like("nombre", "%" + nombre + "%"));

		return crit.list();
	}

	@Override
	public void update(Administrador administrador) {
		
		getSession().update(administrador);
		

	}

	@Override
	public void delete(Administrador administrador) {
		getSession().delete(administrador);
		
	}

}
