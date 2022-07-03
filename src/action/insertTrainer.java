package action;

import database.Querries;

import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Trainer;
import database.Database;

public class insertTrainer {
// INSERT INTO POKEMON (NUMERO, NOME, DESCRICAO, TIPO_1, TIPO_2) VALUES (1, 'Bulbasaur', 'Bulbasaur can be seen nearing the earths surface, but is otherwise unknown. There are three other Bulbasaur in the wild.', 'NORMAL', 'GRASS');

    private Trainer trainer;

    private Connection db;

    public insertTrainer(String cpf, String name, char gender, String birthDate, String homeTown, String title)
    {
        db = Database.getInstance();
        trainer = new Trainer();

        trainer.cpf = cpf;
        trainer.name = name;

        if(gender != ' ')
            trainer.gender = gender;

        trainer.birthDate = birthDate;
        trainer.homeTown = homeTown;
        trainer.title = title;
    }

    public void insert() throws SQLException
    {
        // Lembrar de checar o campo gender, se ele conter ' ' colocar nulo no banco

        String sql = Querries.InsertTrainer;
        PreparedStatement stmt;

        stmt = db.prepareStatement(sql);
        stmt.setString(1, trainer.cpf);
        stmt.setString(2, trainer.name);
        stmt.setString(3, Character.toString(trainer.gender));
        stmt.setString(4, trainer.birthDate);
        stmt.setString(5, trainer.homeTown);
        stmt.setString(6, trainer.title);

        stmt.execute();
    }
}
