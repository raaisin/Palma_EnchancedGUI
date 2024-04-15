package com.example.csit228f2_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

    public static void main(String[] args) {
        try(Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (name, email) VALUES (?, ?)"
            )) {

            String name = "Russell Joshua T. Palma";
            String email = "russelljoshua.palma@cit.edu";
            statement.setString(1, name);
            statement.setString(2, email);

            int rowsInserted = statement.executeUpdate();

            String name2 = "Asher Paquit";
            String email2 = "pinakagahi.sa@cit.edu";
            statement.setString(1, name2);
            statement.setString(2, email2);

            rowsInserted = statement.executeUpdate();

            if(rowsInserted > 0){
                System.out.println("Data inserted successfully");
            }

            //System.out.println("Table created successfully!");
        }
        catch (SQLException e) {
            e.getStackTrace();
        }
    }

}
