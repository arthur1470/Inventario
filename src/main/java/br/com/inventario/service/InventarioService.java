package br.com.inventario.service;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import br.com.inventario.dao.Dao;
import br.com.inventario.model.Inventario;
import br.com.inventario.util.hibernate.Transactional;
import br.com.inventario.util.jsf.FacesUtil;

public class InventarioService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Dao<Inventario> dao;
	
	@Transactional
	public void salvar(Inventario inventario) {
		try {
			dao.salvar(inventario);
			FacesUtil.addInfoMessage("Sucesso!");
		} catch (Exception e) {
			FacesUtil.addErrorMessage("Error!" + e.getMessage());
		}
	}
	
	public List<Inventario> listarTodos(){
		return dao.listar(Inventario.class);
	}
	
	public Inventario buscarPorId(Inventario inventario) {
		try {
			return dao.obterPorId(Inventario.class, inventario.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
