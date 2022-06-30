package action;

import java.lang.String;

public class insertTrainer {

    private String cpf;
    private String name;
    private char gender;
    private String birthDate;
    private String homeTown;
    private String title;

    public insertTrainer(String cpf, String name, char gender, String birthDate, String homeTown, String title)
    {
        this.cpf = cpf;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.homeTown = homeTown;
        this.title = title;
    }

    public void insert()
    {
        // Lembrar de checar o campo gender, se ele conter ' ' colocar nulo no banco

    }
}
