package exercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class PokemonApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Conectar ao banco de dados (substitua com suas próprias configurações)
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pokemon", "postgres", "1349958");

            // Crie um objeto PokemonDAO para realizar operações no banco de dados
            PokemonDAO pokemonDAO = new PokemonDAO(connection);

            int escolha;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Listar Pokémons");
                System.out.println("2. Inserir Novo Pokémon");
                System.out.println("3. Excluir Pokémon");
                System.out.println("4. Atualizar Pokémon");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();

                switch (escolha) {
                case 1:
                    // Listar Pokémons
                    List<Pokemon> pokemons = pokemonDAO.listarPokemons();
                    System.out.println("Lista de Pokémons:");
                    for (Pokemon pokemon : pokemons) {
                        System.out.println(pokemon.getNome() + " (" + pokemon.getTipo() + ") - Nível " + pokemon.getNivel());
                    }
                    break;
                case 2:
                    // Inserir Novo Pokémon
                    System.out.print("Nome do Pokémon: ");
                    String nome = scanner.next();
                    System.out.print("Tipo: ");
                    String tipo = scanner.next();
                    System.out.print("Nível: ");
                    int nivel = scanner.nextInt();
                    Pokemon novoPokemon = new Pokemon(nome, tipo, nivel);
                    pokemonDAO.inserirPokemon(novoPokemon);
                    System.out.println("Novo Pokémon inserido com sucesso!");
                    break;
                case 3:
                    // Excluir Pokémon
                    System.out.print("Nome do Pokémon a ser excluído: ");
                    String nomeExcluir = scanner.next();
                    pokemonDAO.excluirPokemon(nomeExcluir);
                    System.out.println("Pokémon excluído com sucesso!");
                    break;
                case 4:
                    // Atualizar Pokémon
                    System.out.print("Nome do Pokémon a ser atualizado: ");
                    String nomeAtualizar = scanner.next();
                    System.out.print("Novo tipo: ");
                    String novoTipo = scanner.next();
                    System.out.print("Novo nível: ");
                    int novoNivel = scanner.nextInt();
                    Pokemon pokemonAtualizado = new Pokemon(nomeAtualizar, novoTipo, novoNivel);
                    pokemonDAO.atualizarPokemon(pokemonAtualizado);
                    System.out.println("Pokémon atualizado com sucesso!");
                    break;
                case 5:
                        // Sair do programa
                        System.out.println("Saindo do programa.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (escolha != 5);

            // Feche a conexão com o banco de dados
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Certifique-se de fechar o Scanner
            scanner.close();
        }
    }
}

