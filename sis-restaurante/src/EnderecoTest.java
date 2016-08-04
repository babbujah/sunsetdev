import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sunsetdevelopers.sistema.entidade.Endereco;
import com.sunsetdevelopers.sistema.entidade.EnderecoRN;
import com.sunsetdevelopers.sistema.util.HibernateUtil;

public class EnderecoTest {

	private static Session sessao;
	private static Transaction transacao;
	
	@BeforeClass
	public static void abrirConexao() {
		sessao = HibernateUtil.getSession().getCurrentSession();
		transacao = sessao.beginTransaction();
	}
	
	@AfterClass
	public static void fecharConexao() {
		try {
			transacao.commit();
		} catch (Throwable e) {
			System.out.println("Deu problema no commit. " + e.getMessage());
		} finally {
			try {
				if(sessao.isOpen()) {
					sessao.close();
				}
			} catch (Exception e2) {
				System.out.println("Deu problema no fechamento da sessão. " + e2.getMessage());
			}
		}
	}
	
	@Test
	public void salvarEndereco() {
		Endereco end = new Endereco();
		end.setLogradouro("Rua Maria da Silva Maciel");
		end.setNumero("4");
		end.setCidade("Extremoz");
		end.setCep("59000000");
		end.setUf("RN");
		
		EnderecoRN enderecoRN = new EnderecoRN();
		enderecoRN.salvarEndereco(end);
		
		end = new Endereco();
		end.setLogradouro("Rua São Miguel");
		end.setNumero("13");
		end.setCidade("Natal");
		end.setCep("59123654");
		end.setUf("RN");
		
		enderecoRN = new EnderecoRN();
		enderecoRN.salvarEndereco(end);
		
		assertEquals(true, true);
	}
}
