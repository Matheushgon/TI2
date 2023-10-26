package main.java.Service;

import main.java.DAO.PokemonDAO;
import main.java.Model.Pokemon;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class PokemonService {
    private PokemonDAO pokemonDAO; // Certifique-se de que você tenha uma instância de PokemonDAO para acessar os dados

    public PokemonService(PokemonDAO pokemonDAO) {
        this.pokemonDAO = pokemonDAO;
        configureRoutes();
    }

    private void configureRoutes() {
        // Rota para listar Pokémons
        get("/listar", this::listarPokemons);

        // Rota para inserir um novo Pokémon
        post("/inserir", this::inserirPokemon);
    }

    private String listarPokemons(Request req, Response res) {
        // Obtenha a lista de Pokémons do seu PokemonDAO
        // Converte a lista em um formato adequado para resposta (por exemplo, JSON)
        // Retorna a lista de Pokémons como resposta
        return "Implemente a lógica para listar Pokémons aqui";
    }

    private String inserirPokemon(Request req, Response res) {
        // Obtenha os dados do novo Pokémon da solicitação
        String nome = req.queryParams("nome");
        String tipo = req.queryParams("tipo");
        int nivel = Integer.parseInt(req.queryParams("nivel"));

        // Crie um novo objeto Pokemon com esses dados

        // Use seu PokemonDAO para inserir o novo Pokémon no banco de dados

        // Retorna uma resposta adequada (por exemplo, mensagem de sucesso)
        return "Implemente a lógica para inserir um novo Pokémon aqui";
    }
}
