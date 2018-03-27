package br.com.inventario.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;

import br.com.inventario.model.Produto;

public class DaoImp<T extends Serializable> implements Dao<T> {
	private static final long serialVersionUID = 1L;
	
	@Inject
    private Session session;

	private Class<T> entidade;

    @Override
    public void salvar(T entidade) throws Exception {
        session.persist(entidade);
    }

    @Override
	public void alterar(T entidade) throws Exception {
    	session.merge(entidade);	
	}
    
    @Override
    public void remover(T entidade) throws Exception {
        session.delete(entidade);
    }

    @Override
    public List<T> listar(Class<T> classe) {
        return session.createQuery("FROM " + classe.getName()).list();
    }

	@Override
	public T obterPorId(Class<T> classe, Object id) throws Exception {
    	this.entidade = classe;
		return (T) session.get(entidade, (Serializable) id);

//		return (T) session.createQuery("SELECT o FROM " + classe.getName()
//				+ " o WHERE o.id = " + id.toString()).uniqueResult();
	}

	@Override
	public Produto obterProduto(Produto produto) throws Exception {
		Produto produtoEncontrado = (Produto) session.createQuery("SELECT p FROM Produto p where 1=1 " 
				+ montarWherePesquisaProduto(produto)).uniqueResult();
		
		if(produtoEncontrado == null) {
			throw new Exception("Produto não encontrado.");
		}
		
		return produtoEncontrado;
	}
	
	private String montarWherePesquisaProduto(Produto produto) throws Exception {
		String query = "";
		if(produto.getId() != null) {
			query += "AND p.id = " + produto.getId(); 
		} else if(produto.getNome() != null) {
			query += "AND UPPER(p.nome) = UPPER('" + produto.getNome() + "')";
		} else {
			throw new Exception("Id ou Nome deve ser preenchido");
		}
		return query;
	}

	@Override
	public List<String> obterNomeProdutos() {
		return session.createQuery("SELECT p.nome FROM Produto p").list();
	}	
}