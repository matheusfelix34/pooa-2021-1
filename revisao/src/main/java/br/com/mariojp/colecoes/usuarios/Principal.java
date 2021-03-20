package br.com.mariojp.colecoes.usuarios;

import java.util.List;

import br.com.mariojp.colecoes.usuarios.controller.UsuarioController;
import br.com.mariojp.colecoes.usuarios.model.Usuario;
import br.com.mariojp.colecoes.usuarios.persistencia.BancoDAO;
import br.com.mariojp.colecoes.usuarios.persistencia.UsuarioListDAO;
import br.com.mariojp.colecoes.usuarios.persistencia.UsuarioMapDAO;
import br.com.mariojp.colecoes.usuarios.persistencia.UsuarioSetDAO;
import br.com.mariojp.colecoes.usuarios.view.UsuarioConsole;
import br.com.mariojp.colecoes.usuarios.view.UsuarioDesktop;

/**
 * 
 * Cadastro de *usuarios* para um sistema. Um *usuario* vai possuir 
 * *nome*, *email*, *perfil* e uma *senha*.
 * A senha deve ser criptografada.
 * Os *perfis* devem ser *USUARIO* e *ADMINISTRADOR*.
 * O sitema deve possuir autenticação que deve ser feita pelo email e senha.
 * Apenas o ADMIN pode ver a lista de de usuarios.
 *
 *
 * Um usuario do sistema com perfil de ADMIN acessa o sistema
 * passando o email e a senha. Depois ele acessa pede a lista
 * de Usuarios cadastrados.
 * 
 * Tarefas
 * - Criar a Funcionalidade de autenticação.
 * - Criar a Funcionalidade de Listar Usuario.
 *
 * 
 * Cadastro de Usuarios
 * 
 * Model View Controller 
 * 
 * @author mariojp
 *
 */
public class Principal {
	
	
	public static void main(String[] args) {
		
		//Inversao de Controle IoC
		BancoDAO dao;
		if(args.length> 0 && args[0].equals("map")){
			dao = new UsuarioMapDAO();
		}else if(args.length> 0 && args[0].equals("list")) {
			dao = new UsuarioListDAO();
		}else {
			dao = new UsuarioSetDAO();
		}


		UsuarioController controller =  new UsuarioController(dao);
		
		//UsuarioDesktop desktop = new UsuarioDesktop(controller);
		
		UsuarioConsole console = new UsuarioConsole(controller);
		
		//
		

		
//		Usuario usuario = new Usuario("Pedro","pedro@email.com", "1234","ADMINISTRADOR");
//		dao.salvar(usuario);
//		
//
//		usuario = new Usuario("Maria","maria@email.com","1234");
//
//		dao.salvar(usuario);
//		
//		List<Usuario> usuarios2 = dao.lista();
//		Usuario x = new Usuario("joao", "joa","123");
//		//dao.salvar(x);
//		usuarios2.add(x);
//		
//		System.out.println("LISTAR");
//		for (Usuario u : dao.lista()) {
//			System.out.println(u);
//		}
//		
		
	}

}
