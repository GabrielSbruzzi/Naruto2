# Exercício de Programação Orientada a Objetos em Java - Anime Naruto Parte 2

🎯 **Objetivo**  
O objetivo deste desafio é praticar conceitos de Programação Orientada a Objetos (POO) utilizando o universo do anime Naruto. A ideia é criar classes, interfaces e interações em Java que representem os personagens do anime, demonstrando habilidades em herança, interfaces, manipulação de estruturas de dados, e organização de código.

---

💻 **Requisitos**

### Atributos da Classe `Personagem`
- **Nome** (String)
- **Idade** (int)
- **Aldeia** (String)
- **Jutsus** (Map<String, Jutsu>)  
  - O Map deve conter o nome do jutsu como chave e uma instância da classe `Jutsu` como valor.
- **Chakra** (int = 100)
- **Vida** (int)

### Métodos da Classe `Personagem`
- Um construtor para inicializar os atributos.
- Método para adicionar um novo jutsu ao Map de jutsus.
- Método para aumentar o chakra do personagem em uma quantidade específica.
- Método para exibir todas as informações do personagem: nome, idade, aldeia, jutsus e chakra.
- Os personagens só podem atacar enquanto possuem chakra. A cada golpe, o personagem deve perder uma quantidade de chakra correspondente ao consumo do jutsu utilizado.

### Classe `Jutsu`
- **Atributos**:
  - **Dano** (int): o dano causado pelo jutsu.
  - **ConsumoDeChakra** (int): o quanto de chakra é consumido ao usar o jutsu.

---

### Interface `Ninja`
A interface deve conter os métodos:
- `usarJutsu(String nomeDoJutsu)`: exibe uma mensagem indicando que o personagem está usando um jutsu, calcula o dano causado ao inimigo e reduz o chakra do usuário.
- `desviar(int dano)`: exibe uma mensagem indicando que o personagem está tentando desviar de um ataque. Caso o personagem desvie com sucesso, não perde vida; caso contrário, o dano recebido será deduzido de sua vida.

---

### Classes Específicas

#### 1️⃣ **`NinjaDeTaijutsu`**
- Extende a classe `Personagem`.
- Implementa a interface `Ninja`.
- Métodos:
  - `usarJutsu(String nomeDoJutsu)`: indica que o personagem está usando um golpe de Taijutsu.
  - `desviar(int dano)`: indica que o personagem está desviando de um ataque utilizando técnicas de Taijutsu.

#### 2️⃣ **`NinjaDeNinjutsu`**
- Extende a classe `Personagem`.
- Implementa a interface `Ninja`.
- Métodos:
  - `usarJutsu(String nomeDoJutsu)`: indica que o personagem está usando um jutsu de Ninjutsu.
  - `desviar(int dano)`: indica que o personagem está desviando de um ataque utilizando Ninjutsu.

#### 3️⃣ **`NinjaDeGenjutsu`**
- Extende a classe `Personagem`.
- Implementa a interface `Ninja`.
- Métodos:
  - `usarJutsu(String nomeDoJutsu)`: indica que o personagem está usando um jutsu de Genjutsu.
  - `desviar(int dano)`: indica que o personagem está desviando de um ataque utilizando Genjutsu.

---

🛠 **Tecnologias Utilizadas**

- **Java**: Linguagem principal do projeto.
- **JUnit 5**: Framework para criação e execução de testes unitários.
- **Spring Boot**: Framework utilizado para facilitar a construção da aplicação.
- **Springdoc OpenAPI**: Utilizado para gerar a documentação Swagger da API, permitindo visualizar e testar os endpoints da API diretamente através de uma interface web.
- **H2 Database**: Banco de dados relacional em memória utilizado para persistir as informações do projeto.

---

🛠 **Instruções para Execução**

1️⃣ **Clone o repositório**
   ```bash
   git clone https://github.com/GabrielSbruzzi/Naruto2.git
   ```

👨‍💻 **Autor**  
[Gabriel Sbruzzi]  
GitHub: [@GabrielSbruzzi](https://github.com/GabrielSbruzzi)  
LinkedIn: [Gabriel Sbruzzi](https://linkedin.com/in/gabriel-sbruzzi)
```
