package action;

import java.lang.String;
import java.lang.Integer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import database.Querries;
import models.Pokemon;
import database.Database;

public class selectPokemon {

    private Pokemon pokemon;

    private Connection db;

    public selectPokemon(Integer number, String name, String type1, String type2)
    {
        db = Database.getInstance();
        pokemon = new Pokemon();

        pokemon.number = number;
        pokemon.name = name;
        pokemon.type1 = type1.isEmpty() ? null : type1;
        pokemon.type2 = type2.isEmpty() ? null : type2;
    }

    public void search()
    {
        String sql = Querries.GetPokemon;
        PreparedStatement stmt;
        ResultSet rs;

        try{
            stmt = db.prepareStatement(sql);
            if (pokemon.number != null) {
                stmt.setInt(1, pokemon.number);
            } else {
                stmt.setNull(1, Types.INTEGER);
            }
            stmt.setString(2, "%"+pokemon.name+"%");
            stmt.setString(3, pokemon.type1);
            stmt.setString(4, pokemon.type2);
            stmt.setString(5, pokemon.type2);
            stmt.setString(6, pokemon.type1);

            rs = stmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("Nome"));
            }
        } catch (Exception e) {
            System.out.println("Erro selectPokemon: " + e.getMessage());
        }

        // Se a query retornar resultados, chamar a classe pokemonList enviando o ResultSet para mostrar

    }
}
