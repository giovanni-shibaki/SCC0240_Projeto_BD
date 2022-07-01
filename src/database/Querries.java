package database;

public final class Querries {
    private Querries() { }

    public static String GetPokemon = "SELECT * FROM POKEMON WHERE NUMERO = NVL(?, NUMERO) AND UPPER(NOME) LIKE UPPER(NVL(?, NOME)) AND (UPPER(TIPO_1) = UPPER(NVL(?, TIPO_1)) AND UPPER(TIPO_2) = UPPER(NVL(?, TIPO_2))) OR (UPPER(TIPO_1) = UPPER(NVL(?, TIPO_1)) AND UPPER(TIPO_2) = UPPER(NVL(?, TIPO_2)))";
    public static String InsertTrainer = "INSERT INTO TREINADOR (CPF, NOME, GENERO, DATA_NASC, CIDADE_NATAL, TITULO) VALUES (?, ?, ?, ?, ?, ?)";
}