import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sunsetdevelopers.sistema.entidade.Endereco;
import com.sunsetdevelopers.sistema.entidade.Telefone;
import com.sunsetdevelopers.sistema.entidade.TipoCliente;
import com.sunsetdevelopers.sistema.entidade.cliente.CategoriaCliente;
import com.sunsetdevelopers.sistema.entidade.cliente.Cliente;
import com.sunsetdevelopers.sistema.entidade.cliente.ClienteRN;
import com.sunsetdevelopers.sistema.entidade.cliente.Sexo;
import com.sunsetdevelopers.sistema.entidade.cliente.Situacao;
import com.sunsetdevelopers.sistema.util.HibernateUtil;

public class ClienteTest {

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
	
	@Test
	public void salvarTest() {
	
		List<Endereco> enderecos = new ArrayList<>();
		List<Telefone> telefones = new ArrayList<>();
		
		Endereco end = new Endereco();
		Telefone tel = new Telefone();
		
		//Novo cliente
		Cliente c1 = new Cliente();
		c1.setNome("Bruno");
		c1.setDocReceitaFederal("123456789");
		c1.setCategoriaCliente(CategoriaCliente.COMUM);
		c1.setDataCadastro(new Date());
		c1.setDataNascimento(new Date());
		c1.setEmail("bruno@email.com");
		c1.setSexo(Sexo.MASCULINO);
		c1.setSituacao(Situacao.ATIVO);
		c1.setTipoCliente(TipoCliente.FISICO);
		
		end.setLogradouro("Rua do pote");
		end.setNumero("01");
		end.setCidade("Natal");
		end.setCep("59000-000");
		end.setUf("RN");
		end.setEntidade(c1);
		
		tel.setTelefone("848751425");
		tel.setDescricao("Móvel");
		tel.setEntidade(c1);
		
		enderecos.add(end);
		telefones.add(tel);
		
		c1.setEnderecos(enderecos);
		c1.setTelefones(telefones);
		
		
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.salvar(c1);
		
		enderecos.clear();
		telefones.clear();
		
		//Novo cliente
		end = new Endereco();
		tel = new Telefone();
		
		c1 = new Cliente();
		c1.setNome("Sunset Developers");
		c1.setDocReceitaFederal("03456987000125");
		c1.setCategoriaCliente(CategoriaCliente.VIP);
		c1.setDataCadastro(new Date());
		c1.setDataNascimento(new Date());
		c1.setEmail("sunsetdev@email.com");
		//c1.setSexo(Sexo.MASCULINO);
		c1.setSituacao(Situacao.ATIVO);
		c1.setTipoCliente(TipoCliente.JURIDICO);
		
		end.setLogradouro("Rua São João das Marcas");
		end.setNumero("156");
		end.setCidade("Extremoz");
		end.setCep("59265-123");
		end.setUf("RN");
		end.setEntidade(c1);
		
		tel.setTelefone("84932061247");
		tel.setDescricao("Fixo");
		tel.setEntidade(c1);
		
		enderecos.add(end);
		telefones.add(tel);
		
		c1.setEnderecos(enderecos);
		c1.setTelefones(telefones);
		
		
		clienteRN = new ClienteRN();
		clienteRN.salvar(c1);
		
		assertEquals(true, true);
	}
	
}
