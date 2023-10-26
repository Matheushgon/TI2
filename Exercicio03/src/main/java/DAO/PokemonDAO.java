package main.java.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.Model.Pokemon;

public class PokemonDAO {
    private Connection connection;

    public PokemonDAO(Connection connection) {
        this.connection = connection;
    }

    // Inserir um novo Pokémon na tabela
    public void inserirPokemon(Pokemon pokemon) {
        String sql = "INSERT INTO pokemon (nome, tipo, nivel) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pokemon.getNome());
            statement.setString(2, pokemon.getTipo());
            statement.setInt(3, pokemon.getNivel());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todos os Pokémons na tabela
    public List<Pokemon> listarPokemons() {
        List<Pokemon> pokemons = new ArrayList<>();
        String sql = "SELECT nome, tipo, nivel FROM pokemon";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String tipo = resultSet.getString("tipo");
                int nivel = resultSet.getInt("nivel");
                Pokemon pokemon = new Pokemon(nome, tipo, nivel);
                pokemons.add(pokemon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pokemons;
    }

    // Excluir um Pokémon da tabela com base no nome
    public void excluirPokemon(String nome) {
        String sql = "DELETE FROM pokemon WHERE nome = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Atualizar um Pokémon na tabela com base no nome
    public void atualizarPokemon(Pokemon pokemon) {
        String sql = "UPDATE pokemon SET tipo = ?, nivel = ? WHERE nome = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pokemon.getTipo());
            statement.setInt(2, pokemon.getNivel());
            statement.setString(3, pokemon.getNome());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
