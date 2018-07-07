package projeto1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AlunoTest {

	@Test
	public void deveMudarParaMaiúsculo() {
		Aluno aluno = new Aluno("rian");
		
		assertTrue(aluno.toUpperCase().equals("RIAN"));
	}
}