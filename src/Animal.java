/**
 * Classe Animal - SUPERCLASSE
 *
 * Representa um animal genérico cadastrado na clínica veterinária.
 * Esta é a classe pai que contém os atributos e métodos comuns a todos os animais.
 * Pode ser instanciada diretamente para cadastrar animais que não sejam cachorros ou gatos
 * (como pássaros, coelhos, hamsters, répteis, etc.).
 *
 * @author Seu Nome
 * @version 1.0
 */
public class Animal {

    // ========== ATRIBUTOS ==========
    // Modificador 'private' para garantir encapsulamento

    /**
     * Nome do animal
     */
    private String nome;

    /**
     * Espécie do animal (Ex: Canina, Felina, Ave, Lagomorfo, etc.)
     */
    private String especie;

    /**
     * Idade do animal em anos
     */
    private int idade;

    /**
     * Nome do proprietário/dono do animal
     */
    private String nomeDono;

    /**
     * Telefone de contato do proprietário
     */
    private String telefone;

    /**
     * Raça do animal (pode ser "Não informado" ou "SRD" se desconhecido)
     */
    private String raca;


    // ========== CONSTRUTORES ==========

    /**
     * Construtor completo da classe Animal
     *
     * @param nome Nome do animal
     * @param especie Espécie do animal
     * @param idade Idade do animal em anos
     * @param nomeDono Nome do proprietário
     * @param telefone Telefone do proprietário
     * @param raca Raça do animal
     */
    public Animal(String nome, String especie, int idade, String nomeDono, String telefone, String raca) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.nomeDono = nomeDono;
        this.telefone = telefone;
        // Se raça estiver vazia ou null, define como "Não informado"
        this.raca = (raca == null || raca.trim().isEmpty()) ? "Não informado" : raca;
    }


    // ========== GETTERS E SETTERS ==========
    // Métodos para acessar e modificar os atributos privados

    /**
     * Retorna o nome do animal
     * @return nome do animal
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do animal
     * @param nome novo nome do animal
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a espécie do animal
     * @return espécie do animal
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Define a espécie do animal
     * @param especie nova espécie do animal
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * Retorna a idade do animal
     * @return idade em anos
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade do animal
     * @param idade nova idade em anos
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Retorna o nome do proprietário
     * @return nome do dono
     */
    public String getNomeDono() {
        return nomeDono;
    }

    /**
     * Define o nome do proprietário
     * @param nomeDono novo nome do dono
     */
    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    /**
     * Retorna o telefone do proprietário
     * @return telefone de contato
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do proprietário
     * @param telefone novo telefone de contato
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna a raça do animal
     * @return raça do animal
     */
    public String getRaca() {
        return raca;
    }

    /**
     * Define a raça do animal
     * @param raca nova raça do animal
     */
    public void setRaca(String raca) {
        // Se raça estiver vazia ou null, define como "Não informado"
        this.raca = (raca == null || raca.trim().isEmpty()) ? "Não informado" : raca;
    }


    // ========== MÉTODOS PERSONALIZADOS ==========

    /**
     * MÉTODO PERSONALIZADO 1
     * Calcula a idade aproximada do animal em meses humanos
     * Conversão simplificada: 1 ano animal = 12 meses
     *
     * @return idade em meses
     */
    public int calcularIdadeEmMeses() {
        return this.idade * 12;
    }

    /**
     * MÉTODO PERSONALIZADO 2
     * Valida se a idade informada é válida (positiva e razoável)
     *
     * @return true se idade válida, false caso contrário
     */
    public boolean validarIdade() {
        // Idade deve ser maior que 0 e menor que 50 anos (limite razoável para maioria dos animais)
        return this.idade > 0 && this.idade <= 50;
    }

    /**
     * MÉTODO PERSONALIZADO 3
     * Gera uma ficha completa formatada do animal com todos os dados
     *
     * @return String com a ficha completa formatada
     */
    public String gerarFichaCompleta() {
        StringBuilder ficha = new StringBuilder();
        ficha.append("========== FICHA DO ANIMAL ==========\n");
        ficha.append("Nome: ").append(this.nome).append("\n");
        ficha.append("Espécie: ").append(this.especie).append("\n");
        ficha.append("Raça: ").append(this.raca).append("\n");
        ficha.append("Idade: ").append(this.idade).append(" ano(s)");
        ficha.append(" (").append(calcularIdadeEmMeses()).append(" meses)\n");
        ficha.append("--- Dados do Proprietário ---\n");
        ficha.append("Nome: ").append(this.nomeDono).append("\n");
        ficha.append("Telefone: ").append(this.telefone).append("\n");
        ficha.append("=====================================");
        return ficha.toString();
    }


    // ========== MÉTODO toString() SOBRESCRITO ==========

    /**
     * Sobrescreve o método toString() da classe Object
     * Retorna uma representação em String do objeto Animal de forma legível
     *
     * @return String formatada com os dados do animal
     */
    @Override
    public String toString() {
        return "Animal: " + nome +
                " | Espécie: " + especie +
                " | Raça: " + raca +
                " | Idade: " + idade + " ano(s)" +
                " | Dono: " + nomeDono +
                " | Tel: " + telefone;
    }
}