/**
 * Classe Gato - SUBCLASSE de Animal
 *
 * Representa especificamente um gato cadastrado na clínica veterinária.
 * Esta classe herda todos os atributos e métodos da classe Animal (superclasse)
 * e adiciona atributos e comportamentos específicos para gatos.
 *
 * Demonstra o conceito de HERANÇA (extends) e POLIMORFISMO em Java.
 *
 * @author Seu Nome
 * @version 1.0
 */
public class Gato extends Animal {

    // ========== ATRIBUTOS ESPECÍFICOS DE GATO ==========
    // Estes atributos são exclusivos da subclasse Gato

    /**
     * Tipo de pelagem do gato (Curta, Longa, Média)
     */
    private String pelagem;

    /**
     * Temperamento do gato (Calmo, Ativo, Agressivo, Tímido, etc.)
     */
    private String temperamento;


    // ========== CONSTRUTOR ==========

    /**
     * Construtor completo da classe Gato
     * Utiliza super() para chamar o construtor da superclasse Animal
     *
     * @param nome Nome do gato
     * @param especie Espécie (normalmente "Felina")
     * @param idade Idade do gato em anos (aceita decimais)
     * @param nomeDono Nome do proprietário
     * @param telefone Telefone do proprietário
     * @param raca Raça do gato (Ex: Persa, Siamês, SRD, etc.)
     * @param pelagem Tipo de pelagem (Curta, Longa, Média)
     * @param temperamento Temperamento do gato (Calmo, Ativo, Agressivo, etc.)
     */
    public Gato(String nome, String especie, double idade, String nomeDono,
                String telefone, String raca, String pelagem, String temperamento) {
        // Chama o construtor da superclasse Animal usando super()
        // Isso inicializa os atributos herdados (nome, especie, idade, nomeDono, telefone, raca)
        super(nome, especie, idade, nomeDono, telefone, raca);

        // Inicializa os atributos específicos de Gato
        this.pelagem = pelagem;
        this.temperamento = temperamento;
    }


    // ========== GETTERS E SETTERS ESPECÍFICOS ==========

    /**
     * Retorna o tipo de pelagem do gato
     * @return pelagem (Curta, Longa, Média)
     */
    public String getPelagem() {
        return pelagem;
    }

    /**
     * Define o tipo de pelagem do gato
     * @param pelagem novo tipo de pelagem
     */
    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    /**
     * Retorna o temperamento do gato
     * @return temperamento (Calmo, Ativo, Agressivo, etc.)
     */
    public String getTemperamento() {
        return temperamento;
    }

    /**
     * Define o temperamento do gato
     * @param temperamento novo temperamento
     */
    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }


    // ========== MÉTODOS PERSONALIZADOS ESPECÍFICOS ==========

    /**
     * MÉTODO PERSONALIZADO ESPECÍFICO DE GATO
     * Calcula a idade do gato em "anos humanos" usando fórmula simplificada
     *
     * Fórmula aproximada para gatos:
     * - 1º ano = 15 anos humanos
     * - 2º ano = +9 anos humanos
     * - Demais anos = +4 anos humanos cada
     *
     * @return idade aproximada em anos humanos
     */
    public int calcularIdadeHumana() {
        double idadeAtual = getIdade(); // Usa o getter herdado da superclasse
        int anos = getAnos(); // Pega apenas os anos completos

        if (idadeAtual <= 0) {
            return 0;
        } else if (anos == 0) {
            // Menos de 1 ano - proporcional
            return (int) (15 * idadeAtual);
        } else if (anos == 1) {
            return 15 + (int) (9 * (idadeAtual - 1));
        } else if (anos == 2) {
            return 24 + (int) (4 * (idadeAtual - 2));
        } else {
            // Mais de 2 anos
            return 24 + ((anos - 2) * 4) + (int) (4 * (idadeAtual - anos));
        }
    }

    /**
     * MÉTODO PERSONALIZADO - Retorna recomendação de cuidados baseado na pelagem
     *
     * @return String com recomendação de cuidados com a pelagem
     */
    public String recomendarCuidadosPelagem() {
        switch (pelagem.toLowerCase()) {
            case "curta":
                return "Cuidados: Escovação semanal é suficiente";
            case "média":
            case "media":
                return "Cuidados: Escovação 2-3 vezes por semana";
            case "longa":
                return "Cuidados: Escovação diária recomendada para evitar nós";
            default:
                return "Cuidados: Consulte o veterinário para orientações";
        }
    }

    /**
     * MÉTODO PERSONALIZADO - Analisa se o gato precisa de atenção especial
     * com base no temperamento
     *
     * @return String com análise do temperamento
     */
    public String analisarTemperamento() {
        String temp = temperamento.toLowerCase();

        if (temp.contains("agressivo")) {
            return "⚠️ ATENÇÃO: Gato com temperamento agressivo - manusear com cuidado";
        } else if (temp.contains("tímido") || temp.contains("timido")) {
            return "ℹ️ Gato tímido - necessita ambiente calmo e paciência";
        } else if (temp.contains("ativo")) {
            return "✓ Gato ativo - precisa de estímulos e brincadeiras regulares";
        } else if (temp.contains("calmo")) {
            return "✓ Gato calmo - temperamento tranquilo e equilibrado";
        } else {
            return "ℹ️ Temperamento registrado: " + temperamento;
        }
    }


    // ========== SOBRESCRITA DE MÉTODOS ==========

    /**
     * SOBRESCREVE o método gerarFichaCompleta() da superclasse
     * Adiciona informações específicas de Gato à ficha
     *
     * @return String com a ficha completa formatada incluindo dados de gato
     */
    @Override
    public String gerarFichaCompleta() {
        // Chama o método da superclasse para obter a ficha básica
        String fichaBasica = super.gerarFichaCompleta();

        // Adiciona informações específicas de Gato
        StringBuilder fichaCompleta = new StringBuilder(fichaBasica);
        fichaCompleta.append("\n--- Informações Específicas ---\n");
        fichaCompleta.append("Tipo: Gato\n");
        fichaCompleta.append("Pelagem: ").append(this.pelagem).append("\n");
        fichaCompleta.append("Temperamento: ").append(this.temperamento).append("\n");
        fichaCompleta.append("Idade Humana: ").append(calcularIdadeHumana()).append(" anos\n");
        fichaCompleta.append(recomendarCuidadosPelagem()).append("\n");
        fichaCompleta.append(analisarTemperamento()).append("\n");
        fichaCompleta.append("=====================================");

        return fichaCompleta.toString();
    }

    /**
     * SOBRESCREVE o método toString() da superclasse
     * Adiciona pelagem e temperamento à representação em String
     *
     * @return String formatada com os dados do gato
     */
    @Override
    public String toString() {
        // Usa super.toString() para obter a representação básica e adiciona dados específicos
        return super.toString() +
                " | Pelagem: " + pelagem +
                " | Temperamento: " + temperamento;
    }
}