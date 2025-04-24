package br.com.alura.refl;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.alura.Pessoa;

public class ObjectToJsonTester {

	public static void main(String... x) throws JsonProcessingException {
		Pessoa pessoa = new Pessoa(1, "Calebe", "12345");
		ObjectToJson objectToJson = new ObjectToJson();
		System.out.println(objectToJson.transform(pessoa));
	}

}
