package br.com.inventario.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "PRODUTO_INSERIDO")
public class ProdutoInserido implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(sequenceName = "SEQ_ID_PRODUTO_INSERIDO", name = "SEQ_ID_PRODUTO_INSERIDO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID_PRODUTO_INSERIDO")
    @Column(name = "ID_PRODUTO_INSERIDO")
    private BigInteger id;

    @OneToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;

    @Column(name = "QUANTIDADE_PRODUTO_INSERIDO")
    private Integer quantidade;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoInserido other = (ProdutoInserido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}    
}
