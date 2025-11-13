/**
 * Classe Cachorro - SUBCLASSE de Animal
 *
 * Representa especificamente um cachorro cadastrado na clínica veterinária.
 * Esta classe herda todos os atributos e métodos da classe Animal (superclasse)
 * e adiciona atributos e comportamentos específicos para cachorros.
 *
 * Demonstra o conceito de HERANÇA (extends) e POLIMORFISMO em Java.
 *
 * @author Seu Nome
 * @version 1.0
 */
public class Cachorro extends Animal {

    // ========== ATRIBUTOS ESPECÍFICOS DE CACHORRO ==========
    // Estes atributos são exclusivos da subclasse Cachorro

    /**
     * Porte do cachorro (Pequeno, Médio ou Grande)
     */
    private String porte;


    // ========== CONSTRUTOR ==========

    /**
     * Construtor completo da classe Cachorro
     * Utiliza super() para chamar o construtor da superclasse Animal
     *
     * @param nome Nome do cachorro
     * @param especie Espécie (normalmente "Canina")
     * @param idade Idade do cachorro em anos (aceita decimais)
     * @param nomeDono Nome do proprietário
     * @param telefone Telefone do proprietário
     * @param raca Raça do cachorro (Ex: Labrador, Poodle, SRD, etc.)
     * @param porte Porte do cachorro (Pequeno, Médio ou Grande)
     */
    public Cachorro(String nome, String especie, double idade, String nomeDono,
                    String telefone, String raca, String porte) {
        // Chama o construtor da superclasse Animal usando super()
        // Isso inicializa os atributos herdados (nome, especie, idade, nomeDono, telefone, raca)
        super(nome, especie, idade, nomeDono, telefone, raca);

        // Inicializa o atributo específico de Cachorro
        this.porte = porte;
    }


    // ========== GETTERS E SETTERS ESPECÍFICOS ==========

    /**
     * Retorna o porte do cachorro
     * @return porte (Pequeno, Médio ou Grande)
     */
    public String getPorte() {
        return porte;
    }

    /**
     * Define o porte do cachorro
     * @param porte novo porte (Pequeno, Médio ou Grande)
     */
    public void setPorte(String porte) {
        this.porte = porte;
    }


    // ========== MÉTODOS PERSONALIZADOS ESPECÍFICOS ==========

    /**
     * MÉTODO PERSONALIZADO ESPECÍFICO DE CACHORRO
     * Calcula a idade do cachorro em "anos humanos" usando fórmula simplificada
     *
     * Fórmula aproximada:
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
     * MÉTODO PERSONALIZADO - Retorna recomendação de exercício baseado no porte
     *
     * @return String com recomendação de exercício diário
     */
    public String recomendarExercicio() {
        switch (porte.toLowerCase()) {
            case "pequeno":
                return "Recomendação: 30 minutos de caminhada por dia";
            case "médio":
            case "medio":
                return "Recomendação: 1 hora de exercícios por dia";
            case "grande":
                return "Recomendação: 1h30 a 2 horas de exercícios por dia";
            default:
                return "Recomendação: Consulte o veterinário";
        }
    }


    // ========== SOBRESCRITA DE MÉTODOS ==========

    /**
     * SOBRESCREVE o método gerarFichaCompleta() da superclasse
     * Adiciona informações específicas de Cachorro à ficha
     *
     * @return String com a ficha completa formatada incluindo dados de cachorro
     */
    @Override
    public String gerarFichaCompleta() {
        // Chama o método da superclasse para obter a ficha básica
        String fichaBasica = super.gerarFichaCompleta();

        // Adiciona informações específicas de Cachorro
        StringBuilder fichaCompleta = new StringBuilder(fichaBasica);
        fichaCompleta.append("\n--- Informações Específicas ---\n");
        fichaCompleta.append("Tipo: Cachorro\n");
        fichaCompleta.append("Porte: ").append(this.porte).append("\n");
        fichaCompleta.append("Idade Humana: ").append(calcularIdadeHumana()).append(" anos\n");
        fichaCompleta.append(recomendarExercicio()).append("\n");
        fichaCompleta.append("=====================================");

        return fichaCompleta.toString();
    }

    /**
     * SOBRESCREVE o método toString() da superclasse
     * Adiciona o porte do cachorro à representação em String
     *
     * @return String formatada com os dados do cachorro
     */
    @Override
    public String toString() {
        // Usa super.toString() para obter a representação básica e adiciona o porte
        return super.toString() + " | Porte: " + porte;
    }
}