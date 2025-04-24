package br.com.alura.refl;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.Endereco;
import br.com.alura.Pessoa;
import br.com.alura.PessoaDTO;

public class TransformatorTest {

	Pessoa pessoa = new Pessoa(1, "Calebe", "000000");

	Endereco endereco = new Endereco("Rua Onofra Aurelina", 26);

	@Test
	public void shouldTransform() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		Transformator transformator = new Transformator();
		PessoaDTO dto = transformator.transform(pessoa);

		Assertions.assertInstanceOf(PessoaDTO.class, dto);
		Assertions.assertEquals(pessoa.getNome(), dto.getNome());
		Assertions.assertEquals(pessoa.getCpf(), dto.getCpf());
	}

	@Test
	public void shouldNotTransform() {
		Assertions.assertThrows(ClassNotFoundException.class, () -> {
			Transformator transformator = new Transformator();
			transformator.transform(endereco);
		});

	}

	@Test
	public void shouldTransformWhenSomeFieldsIsNull() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Pessoa pessoaSemCpf = new Pessoa( "Calebe");
		Transformator transformator = new Transformator();
		PessoaDTO pessoaDTOSemCpf = transformator.transform(pessoaSemCpf);
		
		Assertions.assertEquals(pessoa.getNome(), pessoaDTOSemCpf.getNome());
		Assertions.assertNull(pessoaSemCpf.getCpf());
		
	}

}
