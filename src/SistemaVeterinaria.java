import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Classe SistemaVeterinaria - CLASSE PRINCIPAL
 *
 * Sistema de Gerenciamento de Clínica Veterinária
 * Implementa todas as funcionalidades CRUD (Create, Read, Update, Delete)
 * utilizando JOptionPane para interação com o usuário.
 *
 * Funcionalidades:
 * 1. Cadastrar Cachorro
 * 2. Cadastrar Gato
 * 3. Cadastrar Outro Animal
 * 4. Listar Todos os Animais
 * 5. Buscar Animal por Nome
 * 6. Atualizar Dados do Animal
 * 7. Remover Animal
 * 8. Sair
 *
 * Demonstra: Herança, Polimorfismo, ArrayList, JOptionPane, Métodos
 *
 * @author Seu Nome
 * @version 1.0
 */
public class SistemaVeterinaria {

    // ========== ATRIBUTO PRINCIPAL ==========
    // ArrayList que armazena TODOS os animais (Animal, Cachorro e Gato)
    // Demonstração de POLIMORFISMO: a lista é do tipo Animal, mas aceita subclasses
    private static ArrayList<Animal> animais = new ArrayList<>();


    // ========== MÉTODO MAIN ==========

    /**
     * Método principal que inicia o sistema
     * Exibe o menu e processa as opções escolhidas pelo usuário
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        // Exibe mensagem de boas-vindas
        JOptionPane.showMessageDialog(null,
                "🐾 Bem-vindo ao Sistema de Clínica Veterinária! 🐾\n\n" +
                        "Sistema de Gerenciamento de Animais",
                "Sistema Veterinária",
                JOptionPane.INFORMATION_MESSAGE);

        // Loop principal do sistema - executa até o usuário escolher sair
        boolean continuar = true;
        while (continuar) {
            continuar = exibirMenuPrincipal();
        }

        // Mensagem de despedida
        JOptionPane.showMessageDialog(null,
                "Obrigado por usar o Sistema de Clínica Veterinária!\n" +
                        "Até logo! 🐾",
                "Encerramento",
                JOptionPane.INFORMATION_MESSAGE);
    }


    // ========== MENU PRINCIPAL ==========

    /**
     * Exibe o menu principal e processa a opção escolhida
     * Utiliza JOptionPane.showInputDialog() para capturar a escolha
     *
     * @return true para continuar no sistema, false para sair
     */
    private static boolean exibirMenuPrincipal() {
        // Monta o texto do menu
        String menu = "========== MENU PRINCIPAL ==========\n\n" +
                "1 - Cadastrar Cachorro\n" +
                "2 - Cadastrar Gato\n" +
                "3 - Cadastrar Outro Animal\n" +
                "4 - Listar Todos os Animais\n" +
                "5 - Buscar Animal por Nome\n" +
                "6 - Atualizar Dados do Animal\n" +
                "7 - Remover Animal\n" +
                "8 - Sair\n\n" +
                "Escolha uma opção:";

        // Exibe o menu e captura a escolha do usuário
        String opcao = JOptionPane.showInputDialog(null, menu,
                "Sistema Veterinária",
                JOptionPane.QUESTION_MESSAGE);

        // Tratamento de cancelamento (usuário clicou em Cancelar ou fechou a janela)
        if (opcao == null) {
            int confirmacao = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente sair do sistema?",
                    "Confirmar Saída",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            return confirmacao != JOptionPane.YES_OPTION; // Continua se escolher NÃO
        }

        // Processamento da opção escolhida usando try-catch para tratar exceções
        try {
            int escolha = Integer.parseInt(opcao.trim());

            switch (escolha) {
                case 1:
                    cadastrarCachorro();
                    break;
                case 2:
                    cadastrarGato();
                    break;
                case 3:
                    cadastrarOutroAnimal();
                    break;
                case 4:
                    listarTodosAnimais();
                    break;
                case 5:
                    buscarAnimalPorNome();
                    break;
                case 6:
                    atualizarAnimal();
                    break;
                case 7:
                    removerAnimal();
                    break;
                case 8:
                    return false; // Sair do sistema
                default:
                    JOptionPane.showMessageDialog(null,
                            "❌ Opção inválida! Por favor, escolha uma opção de 1 a 8.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Exceção capturada quando o usuário digita texto ao invés de número
            JOptionPane.showMessageDialog(null,
                    "❌ Entrada inválida! Por favor, digite apenas números.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

        return true; // Continua no sistema
    }


    // ========== FUNCIONALIDADE: CADASTRAR CACHORRO ==========

    /**
     * Cadastra um novo cachorro no sistema
     * Solicita todos os dados necessários via JOptionPane
     * Demonstra uso de super() através do construtor de Cachorro
     */
    private static void cadastrarCachorro() {
        try {
            // Coleta de dados básicos
            String nome = solicitarTexto("Digite o nome do cachorro:", "Cadastrar Cachorro");
            if (nome == null) return; // Usuário cancelou

            String especie = "Canina"; // Espécie padrão para cachorros

            // Solicita idade em anos e meses
            double idade = solicitarIdade("Cadastrar Cachorro");
            if (idade == -1) return; // Usuário cancelou

            String nomeDono = solicitarTexto("Digite o nome do dono:", "Cadastrar Cachorro");
            if (nomeDono == null) return;

            String telefone = solicitarTexto("Digite o telefone do dono:", "Cadastrar Cachorro");
            if (telefone == null) return;

            String raca = solicitarTexto("Digite a raça do cachorro:\n(Ex: Labrador, Poodle, SRD)",
                    "Cadastrar Cachorro");
            if (raca == null) return;

            // Coleta de dados específicos de Cachorro
            String[] opcoesPorte = {"Pequeno", "Médio", "Grande"};
            String porte = (String) JOptionPane.showInputDialog(null,
                    "Selecione o porte do cachorro:",
                    "Cadastrar Cachorro",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoesPorte,
                    opcoesPorte[1]);

            if (porte == null) return; // Usuário cancelou

            // Cria o objeto Cachorro (demonstra herança e uso de super())
            Cachorro cachorro = new Cachorro(nome, especie, idade, nomeDono, telefone, raca, porte);

            // Valida a idade usando método personalizado
            if (!cachorro.validarIdade()) {
                JOptionPane.showMessageDialog(null,
                        "⚠️ Atenção: A idade informada parece inválida, mas o cadastro será realizado.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }

            // Adiciona o cachorro ao ArrayList
            animais.add(cachorro);

            // Mensagem de sucesso com dados do cachorro
            JOptionPane.showMessageDialog(null,
                    "✅ Cachorro cadastrado com sucesso!\n\n" + cachorro.toString(),
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ Erro: A idade deve ser um número válido!",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "❌ Erro ao cadastrar cachorro: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    // ========== FUNCIONALIDADE: CADASTRAR GATO ==========

    /**
     * Cadastra um novo gato no sistema
     * Solicita todos os dados necessários via JOptionPane
     * Demonstra uso de super() através do construtor de Gato
     */
    private static void cadastrarGato() {
        try {
            // Coleta de dados básicos
            String nome = solicitarTexto("Digite o nome do gato:", "Cadastrar Gato");
            if (nome == null) return;

            String especie = "Felina"; // Espécie padrão para gatos

            // Solicita idade em anos e meses
            double idade = solicitarIdade("Cadastrar Gato");
            if (idade == -1) return; // Usuário cancelou

            String nomeDono = solicitarTexto("Digite o nome do dono:", "Cadastrar Gato");
            if (nomeDono == null) return;

            String telefone = solicitarTexto("Digite o telefone do dono:", "Cadastrar Gato");
            if (telefone == null) return;

            String raca = solicitarTexto("Digite a raça do gato:\n(Ex: Persa, Siamês, SRD)",
                    "Cadastrar Gato");
            if (raca == null) return;

            // Coleta de dados específicos de Gato
            String[] opcoesPelagem = {"Curta", "Média", "Longa"};
            String pelagem = (String) JOptionPane.showInputDialog(null,
                    "Selecione o tipo de pelagem:",
                    "Cadastrar Gato",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoesPelagem,
                    opcoesPelagem[0]);

            if (pelagem == null) return;

            String[] opcoesTemperamento = {"Calmo", "Ativo", "Agressivo", "Tímido", "Brincalhão"};
            String temperamento = (String) JOptionPane.showInputDialog(null,
                    "Selecione o temperamento:",
                    "Cadastrar Gato",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoesTemperamento,
                    opcoesTemperamento[0]);

            if (temperamento == null) return;

            // Cria o objeto Gato (demonstra herança e uso de super())
            Gato gato = new Gato(nome, especie, idade, nomeDono, telefone, raca, pelagem, temperamento);

            // Valida a idade
            if (!gato.validarIdade()) {
                JOptionPane.showMessageDialog(null,
                        "⚠️ Atenção: A idade informada parece inválida, mas o cadastro será realizado.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }

            // Adiciona o gato ao ArrayList
            animais.add(gato);

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(null,
                    "✅ Gato cadastrado com sucesso!\n\n" + gato.toString(),
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ Erro: A idade deve ser um número válido!",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "❌ Erro ao cadastrar gato: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    // ========== FUNCIONALIDADE: CADASTRAR OUTRO ANIMAL ==========

    /**
     * Cadastra um animal genérico (que não seja cachorro ou gato)
     * Ex: pássaro, coelho, hamster, réptil, etc.
     * Utiliza a classe Animal diretamente (não utiliza subclasses)
     * A raça é OPCIONAL - pode ser deixada em branco
     */
    private static void cadastrarOutroAnimal() {
        try {
            // Coleta de dados básicos
            String nome = solicitarTexto("Digite o nome do animal:", "Cadastrar Outro Animal");
            if (nome == null) return;

            String especie = solicitarTexto("Digite a espécie do animal:\n(Ex: Ave, Lagomorfo, Roedor, Réptil)",
                    "Cadastrar Outro Animal");
            if (especie == null) return;

            // Solicita idade em anos e meses
            double idade = solicitarIdade("Cadastrar Outro Animal");
            if (idade == -1) return; // Usuário cancelou

            String nomeDono = solicitarTexto("Digite o nome do dono:", "Cadastrar Outro Animal");
            if (nomeDono == null) return;

            String telefone = solicitarTexto("Digite o telefone do dono:", "Cadastrar Outro Animal");
            if (telefone == null) return;

            // Raça é OPCIONAL para outros animais
            String raca = JOptionPane.showInputDialog(null,
                    "Digite a raça do animal:\n" +
                            "(Deixe em branco ou clique em Cancelar se não souber)",
                    "Cadastrar Outro Animal",
                    JOptionPane.QUESTION_MESSAGE);

            // Se o usuário cancelou ou deixou vazio, define como vazio
            // O construtor de Animal vai converter para "Não informado"
            if (raca == null || raca.trim().isEmpty()) {
                raca = "";
            }

            // Cria o objeto Animal diretamente (não usa subclasse)
            Animal animal = new Animal(nome, especie, idade, nomeDono, telefone, raca);

            // Valida a idade
            if (!animal.validarIdade()) {
                JOptionPane.showMessageDialog(null,
                        "⚠️ Atenção: A idade informada parece inválida, mas o cadastro será realizado.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }

            // Adiciona o animal ao ArrayList
            animais.add(animal);

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(null,
                    "✅ Animal cadastrado com sucesso!\n\n" + animal.toString(),
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ Erro: A idade deve ser um número válido!",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "❌ Erro ao cadastrar animal: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    // ========== FUNCIONALIDADE: LISTAR TODOS OS ANIMAIS ==========

    /**
     * Lista todos os animais cadastrados no sistema
     * Demonstra o uso de toString() sobrescrito em cada classe
     * Utiliza JOptionPane.showMessageDialog() para exibir a lista
     */
    private static void listarTodosAnimais() {
        // Verifica se há animais cadastrados
        if (animais.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "📋 Nenhum animal cadastrado no sistema ainda.",
                    "Lista Vazia",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Constrói a lista formatada
        StringBuilder lista = new StringBuilder();
        lista.append("========== LISTA DE ANIMAIS ==========\n");
        lista.append("Total de animais cadastrados: ").append(animais.size()).append("\n\n");

        // Itera sobre todos os animais usando enhanced for loop
        int contador = 1;
        for (Animal animal : animais) {
            lista.append(contador).append(". ");
            // Utiliza o método toString() sobrescrito (polimorfismo)
            lista.append(animal.toString());
            lista.append("\n\n");
            contador++;
        }

        lista.append("=====================================");

        // Exibe a lista
        JOptionPane.showMessageDialog(null,
                lista.toString(),
                "Lista de Animais",
                JOptionPane.INFORMATION_MESSAGE);
    }


    // ========== FUNCIONALIDADE: BUSCAR ANIMAL POR NOME ==========

    /**
     * Busca um animal específico pelo nome
     * Exibe a ficha completa do animal encontrado
     * Demonstra o uso do método gerarFichaCompleta() (sobrescrito nas subclasses)
     */
    private static void buscarAnimalPorNome() {
        // Verifica se há animais cadastrados
        if (animais.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "📋 Nenhum animal cadastrado no sistema para buscar.",
                    "Lista Vazia",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Solicita o nome para busca
        String nomeBusca = solicitarTexto("Digite o nome do animal que deseja buscar:",
                "Buscar Animal");
        if (nomeBusca == null) return;

        // Busca o animal na lista
        Animal animalEncontrado = null;
        for (Animal animal : animais) {
            // Comparação case-insensitive (ignora maiúsculas/minúsculas)
            if (animal.getNome().equalsIgnoreCase(nomeBusca.trim())) {
                animalEncontrado = animal;
                break; // Para a busca ao encontrar
            }
        }

        // Verifica se encontrou
        if (animalEncontrado == null) {
            JOptionPane.showMessageDialog(null,
                    "❌ Nenhum animal encontrado com o nome: " + nomeBusca,
                    "Não Encontrado",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Exibe a ficha completa do animal
            // Usa o método gerarFichaCompleta() que está sobrescrito nas subclasses
            JOptionPane.showMessageDialog(null,
                    animalEncontrado.gerarFichaCompleta(),
                    "Animal Encontrado",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }


    // ========== FUNCIONALIDADE: ATUALIZAR ANIMAL ==========

    /**
     * Atualiza os dados de um animal cadastrado
     * Busca pelo nome e permite modificar os campos
     * Demonstra uso de setters
     */
    private static void atualizarAnimal() {
        // Verifica se há animais cadastrados
        if (animais.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "📋 Nenhum animal cadastrado no sistema para atualizar.",
                    "Lista Vazia",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Solicita o nome do animal
        String nomeBusca = solicitarTexto("Digite o nome do animal que deseja atualizar:",
                "Atualizar Animal");
        if (nomeBusca == null) return;

        // Busca o animal
        Animal animalEncontrado = null;
        for (Animal animal : animais) {
            if (animal.getNome().equalsIgnoreCase(nomeBusca.trim())) {
                animalEncontrado = animal;
                break;
            }
        }

        if (animalEncontrado == null) {
            JOptionPane.showMessageDialog(null,
                    "❌ Nenhum animal encontrado com o nome: " + nomeBusca,
                    "Não Encontrado",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Menu de atualização
        String[] opcoes = {
                "Nome",
                "Espécie",
                "Idade",
                "Nome do Dono",
                "Telefone",
                "Raça",
                "Cancelar"
        };

        String escolha = (String) JOptionPane.showInputDialog(null,
                "Animal encontrado: " + animalEncontrado.getNome() + "\n\n" +
                        "Qual informação deseja atualizar?",
                "Atualizar Animal",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        if (escolha == null || escolha.equals("Cancelar")) return;

        try {
            // Processa a atualização baseado na escolha
            switch (escolha) {
                case "Nome":
                    String novoNome = solicitarTexto("Digite o novo nome:", "Atualizar Nome");
                    if (novoNome != null) {
                        animalEncontrado.setNome(novoNome);
                        JOptionPane.showMessageDialog(null, "✅ Nome atualizado com sucesso!");
                    }
                    break;

                case "Espécie":
                    String novaEspecie = solicitarTexto("Digite a nova espécie:", "Atualizar Espécie");
                    if (novaEspecie != null) {
                        animalEncontrado.setEspecie(novaEspecie);
                        JOptionPane.showMessageDialog(null, "✅ Espécie atualizada com sucesso!");
                    }
                    break;

                case "Idade":
                    double novaIdade = solicitarIdade("Atualizar Idade");
                    if (novaIdade != -1) {
                        animalEncontrado.setIdade(novaIdade);
                        JOptionPane.showMessageDialog(null, "✅ Idade atualizada com sucesso!");
                    }
                    break;

                case "Nome do Dono":
                    String novoNomeDono = solicitarTexto("Digite o novo nome do dono:", "Atualizar Dono");
                    if (novoNomeDono != null) {
                        animalEncontrado.setNomeDono(novoNomeDono);
                        JOptionPane.showMessageDialog(null, "✅ Nome do dono atualizado com sucesso!");
                    }
                    break;

                case "Telefone":
                    String novoTelefone = solicitarTexto("Digite o novo telefone:", "Atualizar Telefone");
                    if (novoTelefone != null) {
                        animalEncontrado.setTelefone(novoTelefone);
                        JOptionPane.showMessageDialog(null, "✅ Telefone atualizado com sucesso!");
                    }
                    break;

                case "Raça":
                    String novaRaca = solicitarTexto("Digite a nova raça:", "Atualizar Raça");
                    if (novaRaca != null) {
                        animalEncontrado.setRaca(novaRaca);
                        JOptionPane.showMessageDialog(null, "✅ Raça atualizada com sucesso!");
                    }
                    break;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ Erro: Valor inválido inserido!",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    // ========== FUNCIONALIDADE: REMOVER ANIMAL ==========

    /**
     * Remove um animal do sistema
     * Busca pelo nome e solicita confirmação antes de excluir
     * Demonstra uso do método remove() do ArrayList
     */
    private static void removerAnimal() {
        // Verifica se há animais cadastrados
        if (animais.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "📋 Nenhum animal cadastrado no sistema para remover.",
                    "Lista Vazia",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Solicita o nome do animal
        String nomeBusca = solicitarTexto("Digite o nome do animal que deseja remover:",
                "Remover Animal");
        if (nomeBusca == null) return;

        // Busca o animal
        Animal animalEncontrado = null;
        for (Animal animal : animais) {
            if (animal.getNome().equalsIgnoreCase(nomeBusca.trim())) {
                animalEncontrado = animal;
                break;
            }
        }

        if (animalEncontrado == null) {
            JOptionPane.showMessageDialog(null,
                    "❌ Nenhum animal encontrado com o nome: " + nomeBusca,
                    "Não Encontrado",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmação de remoção
        int confirmacao = JOptionPane.showConfirmDialog(null,
                "⚠️ Tem certeza que deseja remover este animal?\n\n" +
                        animalEncontrado.toString() + "\n\n" +
                        "Esta ação não pode ser desfeita!",
                "Confirmar Remoção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Remove o animal da lista
            animais.remove(animalEncontrado);

            JOptionPane.showMessageDialog(null,
                    "✅ Animal removido com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "❌ Remoção cancelada.",
                    "Cancelado",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }


    // ========== MÉTODO AUXILIAR ==========

    /**
     * Método auxiliar para solicitar texto do usuário via JOptionPane
     * Valida se o campo não está vazio
     *
     * @param mensagem Mensagem a ser exibida
     * @param titulo Título da janela
     * @return texto digitado ou null se cancelado
     */
    private static String solicitarTexto(String mensagem, String titulo) {
        String texto = null;
        boolean valido = false;

        while (!valido) {
            texto = JOptionPane.showInputDialog(null, mensagem, titulo,
                    JOptionPane.QUESTION_MESSAGE);

            // Se usuário cancelou, retorna null
            if (texto == null) {
                return null;
            }

            // Valida se não está vazio
            if (texto.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "❌ Campo não pode estar vazio!",
                        "Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                valido = true;
            }
        }

        return texto.trim();
    }

    /**
     * Método auxiliar para solicitar idade do animal
     * Solicita ANOS e MESES separadamente
     *
     * @param titulo Título da janela
     * @return idade em anos (com decimais para meses) ou -1 se cancelado
     */
    private static double solicitarIdade(String titulo) {
        try {
            // Solicita os anos
            String anosStr = JOptionPane.showInputDialog(null,
                    "Digite a idade em ANOS:\n(Digite 0 se o animal tiver menos de 1 ano)",
                    titulo,
                    JOptionPane.QUESTION_MESSAGE);

            // Se cancelou, retorna -1
            if (anosStr == null) {
                return -1;
            }

            int anos = Integer.parseInt(anosStr.trim());

            // Valida se anos é positivo
            if (anos < 0) {
                JOptionPane.showMessageDialog(null,
                        "❌ A idade em anos não pode ser negativa!",
                        "Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
                return -1;
            }

            // Solicita os meses adicionais
            String mesesStr = JOptionPane.showInputDialog(null,
                    "Digite os MESES adicionais (0 a 11):\n(Digite 0 se não houver meses adicionais)",
                    titulo,
                    JOptionPane.QUESTION_MESSAGE);

            // Se cancelou, retorna -1
            if (mesesStr == null) {
                return -1;
            }

            int meses = Integer.parseInt(mesesStr.trim());

            // Valida se meses está entre 0 e 11
            if (meses < 0 || meses > 11) {
                JOptionPane.showMessageDialog(null,
                        "❌ Os meses devem estar entre 0 e 11!",
                        "Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
                return -1;
            }

            // Calcula a idade total em anos (com decimais)
            // Exemplo: 2 anos e 5 meses = 2 + (5/12) = 2.4166...
            double idadeTotal = anos + (meses / 12.0);

            return idadeTotal;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ Erro: Digite apenas números válidos!",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}