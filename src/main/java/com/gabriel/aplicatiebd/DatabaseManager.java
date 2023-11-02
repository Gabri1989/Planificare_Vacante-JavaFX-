package com.gabriel.aplicatiebd;
import javafx.util.Pair;

import java.sql.*;

public class DatabaseManager {
    private String  id;
    private String nume;
    private String prenume;
    private String nastere;
    private String adresa;
    private String telefon;
    private String oras;
    public DatabaseManager(String ID_CLIENT,String NUME_CLIENT,String PRENUME_CLIENT,String DATA_NASTERII,String ADRESA,String TELEFON,String ORAS)
    {
        id=ID_CLIENT;
        nume=NUME_CLIENT;
        prenume=PRENUME_CLIENT;
        nastere=DATA_NASTERII;
        adresa=ADRESA;
        telefon=TELEFON;
        oras=ORAS;
    }


    public DatabaseManager() {
    }

    public void insertData() {
        String dbURL = "jdbc:oracle:thin:@localhost:1521:GABYDB";
        String username = "GABI_USER";
        String password = "********";

        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            String sql = "INSERT INTO CLIENTI(ID_CLIENT,NUME_CLIENT,PRENUME_CLIENT,DATA_NASTERII,ADRESA,TELEFON,ORAS)"
                    + "VALUES(CLIENTI_S.nextval,?)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String show_data() {
        String dbURL = "jdbc:oracle:thin:@localhost:1521:GABYDB";
        String username = "GABI_USER";
        String password = "Adrian1989$";
        StringBuilder data = new StringBuilder();

        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM CLIENTI";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String nume = resultSet.getString("NUME_CLIENT");
                String prenume = resultSet.getString("PRENUME_CLIENT");
                data.append(nume).append(" ").append(prenume).append("\n");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data.toString();
    }

}
