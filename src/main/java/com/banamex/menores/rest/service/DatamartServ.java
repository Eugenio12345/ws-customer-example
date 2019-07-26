package com.banamex.menores.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banamex.menores.rest.component.BobTrMenores;
import com.banamex.menores.rest.repository.DatamartDao;

@Service
public class DatamartServ {

	@Autowired
	private DatamartDao datamartDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveResolucion(BobTrMenores bobTrMenores) {
		datamartDao.saveInfoMenor(bobTrMenores);
		;
	}
}
