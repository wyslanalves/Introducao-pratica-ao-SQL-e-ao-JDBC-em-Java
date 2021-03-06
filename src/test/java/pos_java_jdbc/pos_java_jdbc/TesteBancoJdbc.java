package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() { // metodo de insert

		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("tiago");
		userposjava.setEmail("tiago@gmail.com");

		userPosDAO.salvar(userposjava);

	}

	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();

		try {
			List<Userposjava> list = dao.listar();
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("-----------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(1L);
			System.out.println(userposjava);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void initAtualizar() {

		try {
			UserPosDAO dao = new UserPosDAO();
			Userposjava objetoBanco = dao.buscar(3L);

			objetoBanco.setNome("pedro");
			objetoBanco.setEmail("pedro@gmail.com");

			dao.atualizar(objetoBanco);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void initDeleta() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(1L);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(83) 98888-5566");
		telefone.setTipo("Casa");
		telefone.setUsuario(6L);

		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
	}

	@Test
	public void testeCarregaFonesUser() {
		UserPosDAO dao = new UserPosDAO();

		List<BeanUserFone> beanUserFones = dao.listaUserFone(6L);

		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("-----------------------------------------------------------------------------");
		}
	}
	@Test
	public void testeDeleteUserFone() {
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(6L);
	}
}
