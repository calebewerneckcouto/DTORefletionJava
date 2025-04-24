# 🧠 Projeto de Transformação de Objetos com Reflexão

Este projeto Java demonstra como utilizar **reflexão** para transformar objetos de uma entidade (como `Pessoa`) para um DTO (como `PessoaDTO`) de forma automática. Também inclui testes unitários utilizando **JUnit 5** para garantir o funcionamento correto da transformação.

---

## 📦 Estrutura do Projeto

br.com.alura/ ├── Pessoa.java ├── PessoaDTO.java ├── Endereco.java ├── PessoaRepository.java ├── PessoaService.java └── refl/ ├── Transformator.java └── TransformatorTest.java


---

## 🚀 Como funciona?

A classe `Transformator` utiliza reflexão para:
- Obter o nome da classe DTO correspondente (`Pessoa` → `PessoaDTO`)
- Criar uma instância do DTO
- Copiar os campos com **mesmo nome e tipo** da entidade para o DTO

Exemplo:
```java
Pessoa pessoa = new Pessoa(1, "Calebe", "000000");
PessoaDTO dto = new Transformator().transform(pessoa);

Resultado:
dto.getNome(); // "Calebe"
dto.getCpf();  // "000000"

✅ Testes Unitários
Os testes estão na classe TransformatorTest:

shouldTransform: Verifica se a conversão de Pessoa para PessoaDTO funciona corretamente.

shouldNotTransform: Garante que uma exceção é lançada quando não há DTO correspondente.

shouldTransformWhenSomeFieldsIsNull: Verifica o comportamento com campos null.

Execute os testes com:

mvn test
🔧 Tecnologias Utilizadas
Java 17+

JUnit 5

Reflexão (java.lang.reflect)

📚 Objetivo
O objetivo principal é demonstrar o uso de reflexão para mapeamento de objetos, uma abordagem útil para reduzir boilerplate em transformações entre entidades e DTOs, especialmente em APIs REST.

💡 Possíveis melhorias
Tratar tipos incompatíveis entre campos

Suporte a transformação reversa (DTO → Entidade)

Substituir por bibliotecas como ModelMapper ou MapStruct para maior performance e legibilidade

🧾 Serialização com ObjectToJson
A classe ObjectToJson transforma qualquer objeto Java em uma string JSON formatada, utilizando reflexão para acessar os campos privados.

Exemplo de uso:
Pessoa pessoa = new Pessoa(1, "Calebe", "12345");
ObjectToJson objectToJson = new ObjectToJson();
System.out.println(objectToJson.transform(pessoa));

Saída esperada:

{
  "id": 1,
  "nome": "Calebe",
  "cpf": "12345"
}


