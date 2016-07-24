import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sunsetdevelopers.sistema.produto.Categoria;
import com.sunsetdevelopers.sistema.produto.Produto;
import com.sunsetdevelopers.sistema.produto.UnidadeMedida;
import com.sunsetdevelopers.sistema.util.HibernateUtil;

public class ProdutoTeste {

	private static Session sessao;
	private static Transaction transacao;

	@BeforeClass
	public static void abreConexao() {
		sessao = HibernateUtil.getSession().getCurrentSession();
		transacao = sessao.beginTransaction();
	}

	@AfterClass
	public static void fecharConexao() {

		try {

			transacao.commit();

		} catch (Throwable e) {

			System.out.println("Deu problema no commit: " + e.getMessage());

		} finally {

			try {

				if (sessao.isOpen()) {
					sessao.close();
				}

			} catch (Exception ex) {
				System.out.println("Deu problema no fechamento da conexão: " + ex.getMessage());
			}
		}
	}

	@Before
	public void setup() {

		Produto p1 = new Produto("Cachorro Quente", UnidadeMedida.UNIDADE, 3.0f, 10, Categoria.LANCHE);
		Produto p2 = new Produto("Hangurguer", UnidadeMedida.UNIDADE, 5.0f, 8, Categoria.LANCHE);
		Produto p3 = new Produto("Refrigerante", UnidadeMedida.LATA, 2.0f, 5, Categoria.BEBIDAS);
		Produto p4 = new Produto("Pudim de Leite", UnidadeMedida.QUILO, 2.5f, 2, Categoria.SOBREMESA);
		Produto p5 = new Produto("Almoço (PF)", UnidadeMedida.UNIDADE, 8.0f, 10, Categoria.REFEICAO);

		sessao.save(p1);
		sessao.save(p2);
		sessao.save(p3);
		sessao.save(p4);
		sessao.save(p5);
	}
	
	@After
	public void limpaBanco() {
		Criteria lista = sessao.createCriteria(Produto.class);
		@SuppressWarnings("unchecked")
		List<Produto> produtos = lista.list();
		
		for(Produto produto : produtos) {
			sessao.delete(produto);
		}
	}

	@Test
	public void salvarProdutoTeste() {

		Query consulta = pesquisar("Han");
		Produto produtoPesquisado = (Produto) consulta.uniqueResult();

		assertEquals(UnidadeMedida.UNIDADE, produtoPesquisado.getUnidadeMedida());
	}

	@Test
	public void listaProdutoTest() {

		Criteria lista = sessao.createCriteria(Produto.class);
		@SuppressWarnings("unchecked")
		List<Produto> produtos = lista.list();

		assertEquals(5, produtos.size());
	}

	@Test
	public void excluirProdutoTest() {
		Query consulta = pesquisar("Pud");
		Produto produtoDeletado = (Produto) consulta.uniqueResult();
		sessao.delete(produtoDeletado);

		produtoDeletado = (Produto) consulta.uniqueResult();

		assertNull(produtoDeletado);
	}

	@Test
	public void alteracaoProdutoTest() {
		Query consulta = pesquisar("Al");
		Produto produtoAlterado = (Produto) consulta.uniqueResult();
		produtoAlterado.setQuantidadeEstoque(100);

		sessao.update(produtoAlterado);

		produtoAlterado = (Produto) consulta.uniqueResult();

		assertEquals(100, produtoAlterado.getQuantidadeEstoque());
	}

	private Query pesquisar(String parametro) {
		String sql = "from Produto p where p.nomeProduto like :nomeProduto";
		Query consulta = sessao.createQuery(sql);
		consulta.setString("nomeProduto", "%" + parametro + "%");
		return consulta;
	}
}
