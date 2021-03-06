package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Kata5P1 {
    
    public static void createNewTable() {

        String url = "jdbc:sqlite:EMAIL.db";
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                    + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " mail text NOT NULL);";
        try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws Exception{
        createNewTable();
        String fileName = "email.txt";
        MailListReader mr = new MailListReader();
        List<String> lista = mr.read(fileName);
        InsertarDatosTabla idt = new InsertarDatosTabla();
        for(String s:lista){
            idt.insert(s);
        }

    }

}