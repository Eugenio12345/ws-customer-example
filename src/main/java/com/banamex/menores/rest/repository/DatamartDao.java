package com.banamex.menores.rest.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.banamex.menores.rest.component.BobTrMenores;

@Repository
public class DatamartDao {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DatamartDao.class);

	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void saveInfoMenor(BobTrMenores bobTrMenores) {

		try {
			getTemplate().getSessionFactory().getCurrentSession()
					.beginTransaction();
			getTemplate().saveOrUpdate(bobTrMenores);
			getTemplate().getSessionFactory().getCurrentSession().flush();
			getTemplate().getSessionFactory().getCurrentSession()
					.getTransaction().commit();
			LOGGER.info("guardando bobTrMenores en BD");
		} catch (Exception e) {
			getTemplate().getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
			LOGGER.info("Error al guardar bobTrMenores en BD");
			LOGGER.error("Error al guardar bobTrMenores en BD", e);
		}

	}

}