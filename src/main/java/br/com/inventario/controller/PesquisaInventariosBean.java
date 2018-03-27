package br.com.inventario.controller;

import br.com.inventario.model.Inventario;
import br.com.inventario.service.InventarioService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named("pesquisaInventariosBean")
@SessionScoped
public class PesquisaInventariosBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Inventario> inventarios;
	private Inventario inventario;
	
	@Inject
	private InventarioService service;

	public void init() {
		this.inventarios = service.listarTodos();
	}
	
	public String informacoesInventario(Inventario inventario) {
		this.inventario = service.buscarPorId(inventario);
		return "InformacoesInventario?faces-redirect=true";
	}
	
	public List<Inventario> getInventarios() {
		return inventarios;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

}
