package main.java.Model;

public class Pokemon {
    // Atributos da classe Pokemon
    private String nome;
    private String tipo;
    private int nivel;
    
    // Construtor da classe Pokemon
    public Pokemon(String nome, String tipo, int nivel) {
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
    }
    
    // Métodos para acessar e modificar os atributos
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getNivel() {
        return nivel;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    // Método para exibir informações sobre o Pokémon
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Nível: " + nivel);
    }
    
    public static void main(String[] args) {
        // Exemplo de criação de um Pokémon e exibição de suas informações
        Pokemon meuPokemon = new Pokemon("Pikachu", "Elétrico", 25);
    }
}