================================================================================
        SISTEMA DE GERENCIAMENTO DE CLÍNICA VETERINÁRIA
================================================================================

Projeto Integrador - Sistemas de Informação
Faculdade Santíssimo Sacramento
Disciplina: Linguagem de Programação II

Autores: Felipe Brito dos Santos Rocha
Data: 29/10/2025
Versão: 1.0

================================================================================
                            DESCRIÇÃO DO PROJETO
================================================================================

Sistema de gerenciamento para clínica veterinária desenvolvido em Java,
utilizando programação orientada a objetos com ênfase em:

- HERANÇA: Hierarquia de classes (Animal -> Cachorro/Gato)
- POLIMORFISMO: ArrayList que armazena diferentes tipos de animais
- ENCAPSULAMENTO: Uso de modificadores de acesso (private, protected, public)
- JOPTIONPANE: Interface gráfica para interação com usuário
- CRUD COMPLETO: Create, Read, Update, Delete

================================================================================
                        ESTRUTURA DO PROJETO
================================================================================

O projeto contém 4 arquivos Java:

1. Animal.java
   - Superclasse que representa um animal genérico
   - Atributos: nome, especie, idade, nomeDono, telefone, raca
   - Métodos personalizados: calcularIdadeEmMeses(), validarIdade(), gerarFichaCompleta()

2. Cachorro.java
   - Subclasse de Animal
   - Atributo adicional: porte (Pequeno, Médio, Grande)
   - Métodos específicos: calcularIdadeHumana(), recomendarExercicio()
   - Sobrescreve: toString() e gerarFichaCompleta()

3. Gato.java
   - Subclasse de Animal
   - Atributos adicionais: pelagem (Curta, Média, Longa), temperamento
   - Métodos específicos: calcularIdadeHumana(), recomendarCuidadosPelagem(), analisarTemperamento()
   - Sobrescreve: toString() e gerarFichaCompleta()

4. SistemaVeterinaria.java
   - Classe principal com método main()
   - Implementa todas as funcionalidades CRUD
   - Utiliza ArrayList para armazenar animais
   - Interface completa com JOptionPane

================================================================================
                    FUNCIONALIDADES IMPLEMENTADAS
================================================================================

O sistema oferece as seguintes funcionalidades:

1. Cadastrar Cachorro
   - Solicita: nome, idade, dono, telefone, raça e porte
   - Validação de idade
   - Armazenamento em ArrayList

2. Cadastrar Gato
   - Solicita: nome, idade, dono, telefone, raça, pelagem e temperamento
   - Validação de idade
   - Armazenamento em ArrayList

3. Cadastrar Outro Animal
   - Permite cadastrar animais genéricos (pássaros, coelhos, etc.)
   - Raça é OPCIONAL (pode deixar em branco)
   - Flexibilidade para diferentes espécies

4. Listar Todos os Animais
   - Exibe lista completa de animais cadastrados
   - Mostra contagem total
   - Utiliza toString() sobrescrito

5. Buscar Animal por Nome
   - Busca case-insensitive (ignora maiúsculas/minúsculas)
   - Exibe ficha completa do animal
   - Demonstra polimorfismo (gerarFichaCompleta())

6. Atualizar Dados do Animal
   - Permite modificar: nome, espécie, idade, dono, telefone e raça
   - Validação de entrada
   - Utiliza setters

7. Remover Animal
   - Busca por nome
   - Solicita confirmação antes de excluir
   - Remove do ArrayList

8. Sair
   - Encerra o sistema com confirmação

================================================================================
                    REQUISITOS TÉCNICOS ATENDIDOS
================================================================================

✓ Estrutura de Classes com Herança
  - 1 superclasse (Animal) + 2 subclasses (Cachorro e Gato)
  - Uso correto de super() nos construtores
  - Modificadores de acesso adequados

✓ Métodos Obrigatórios
  - Getters e Setters implementados
  - toString() sobrescrito em todas as classes
  - 3+ métodos personalizados (calcularIdadeEmMeses, validarIdade, gerarFichaCompleta, etc.)

✓ JOptionPane
  - Menu principal navegável
  - Entrada de dados via showInputDialog()
  - Exibição via showMessageDialog()
  - Tratamento de cancelamento

✓ Funcionalidades CRUD
  - Create (cadastrar)
  - Read (listar e buscar)
  - Update (atualizar)
  - Delete (remover)

✓ Boas Práticas
  - Código organizado e identado
  - Nomenclatura clara (camelCase e PascalCase)
  - Comentários explicativos (JavaDoc)
  - Tratamento de exceções (try-catch)
  - Validações de entrada

================================================================================
                    INSTRUÇÕES DE COMPILAÇÃO E EXECUÇÃO
================================================================================

OPÇÃO 1: USANDO IntelliJ IDEA (RECOMENDADO)
-------------------------------------------

1. Abrir o IntelliJ IDEA

2. Criar um novo projeto:
   - File -> New -> Project
   - Selecione "Java"
   - Dê um nome ao projeto (ex: SistemaClinicaVeterinaria)
   - Clique em "Create"

3. Adicionar os arquivos ao projeto:
   - Dentro da pasta "src", copie todos os 4 arquivos .java:
     * Animal.java
     * Cachorro.java
     * Gato.java
     * SistemaVeterinaria.java

4. Executar o sistema:
   - Abra o arquivo SistemaVeterinaria.java
   - Clique com botão direito no código
   - Selecione "Run 'SistemaVeterinaria.main()'"
   OU
   - Clique no botão verde de play (▶) ao lado do método main()

5. O sistema será iniciado e exibirá as janelas do JOptionPane


OPÇÃO 2: USANDO LINHA DE COMANDO (Terminal/CMD)
-----------------------------------------------

1. Navegue até a pasta onde estão os arquivos .java

2. Compile todos os arquivos:

   Windows:
   javac Animal.java Cachorro.java Gato.java SistemaVeterinaria.java

   Linux/Mac:
   javac Animal.java Cachorro.java Gato.java SistemaVeterinaria.java

3. Execute o sistema:

   Windows/Linux/Mac:
   java SistemaVeterinaria

4. O sistema será iniciado e exibirá as janelas do JOptionPane


OPÇÃO 3: USANDO OUTRO IDE (Eclipse, NetBeans, VS Code)
------------------------------------------------------

1. Crie um novo projeto Java no IDE de sua escolha

2. Adicione os 4 arquivos .java ao projeto (na pasta src)

3. Localize o arquivo SistemaVeterinaria.java

4. Execute a classe SistemaVeterinaria (botão Run/Execute)


================================================================================
                        REQUISITOS DO SISTEMA
================================================================================

- Java Development Kit (JDK) 8 ou superior
- IDE Java (IntelliJ IDEA, Eclipse, NetBeans) ou terminal com Java configurado
- Sistema operacional: Windows, Linux ou MacOS

================================================================================
                        SOLUÇÃO DE PROBLEMAS
================================================================================

PROBLEMA: Erro "javac não é reconhecido como comando"
SOLUÇÃO: Certifique-se de que o JDK está instalado e configurado no PATH do sistema

PROBLEMA: As janelas do JOptionPane não aparecem
SOLUÇÃO: Verifique se está executando em ambiente gráfico (não terminal SSH)

PROBLEMA: Erro de compilação "cannot find symbol"
SOLUÇÃO: Certifique-se de que todos os 4 arquivos .java estão na mesma pasta

PROBLEMA: Caracteres especiais (acentos) aparecem errados
SOLUÇÃO: Configure a codificação UTF-8 no IDE ou compile com: javac -encoding UTF-8 *.java

================================================================================
                        DEMONSTRAÇÃO DE USO
================================================================================

EXEMPLO DE FLUXO DE USO:

1. Execute o sistema
2. Escolha "1 - Cadastrar Cachorro"
3. Preencha os dados:
   - Nome: Rex
   - Idade: 3
   - Dono: João Silva
   - Telefone: 11999999999
   - Raça: Labrador
   - Porte: Grande
4. Sistema confirma: "✅ Cachorro cadastrado com sucesso!"
5. Escolha "4 - Listar Todos os Animais"
6. Sistema exibe o cachorro cadastrado
7. Escolha "5 - Buscar Animal por Nome"
8. Digite: Rex
9. Sistema exibe ficha completa com idade humana e recomendação de exercício
10. Continue explorando outras funcionalidades...

================================================================================
                        CONCEITOS DEMONSTRADOS
================================================================================

✓ HERANÇA
  - Animal é a superclasse
  - Cachorro e Gato são subclasses que herdam de Animal
  - Uso de extends e super()

✓ POLIMORFISMO
  - ArrayList<Animal> armazena objetos de diferentes tipos (Animal, Cachorro, Gato)
  - Métodos sobrescritos (toString, gerarFichaCompleta) comportam-se diferentemente

✓ ENCAPSULAMENTO
  - Atributos privados (private)
  - Acesso via getters e setters
  - Validação interna (ex: setRaca valida se não está vazio)

✓ SOBRESCRITA DE MÉTODOS
  - toString() sobrescrito em todas as classes
  - gerarFichaCompleta() sobrescrito nas subclasses

✓ ARRAYLIST
  - Estrutura de dados dinâmica para armazenar animais
  - Métodos add(), remove(), isEmpty(), size()

✓ JOPTIONPANE
  - showInputDialog() para entrada
  - showMessageDialog() para exibição
  - showConfirmDialog() para confirmações
  - showOptionDialog() para seleções

✓ TRATAMENTO DE EXCEÇÕES
  - try-catch para NumberFormatException
  - Validação de entradas null e vazias

================================================================================
                        INFORMAÇÕES ADICIONAIS
================================================================================

SUGESTÕES DE MELHORIAS FUTURAS:
- Persistência de dados em arquivo ou banco de dados
- Relatórios em PDF
- Sistema de agendamento de consultas
- Histórico médico dos animais
- Controle de vacinação
- Sistema de login e permissões

CONTATO:
Para dúvidas ou sugestões sobre o projeto, entre em contato com o desenvolvedor.

================================================================================
                        FIM DO README
================================================================================