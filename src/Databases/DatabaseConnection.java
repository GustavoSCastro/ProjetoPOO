package Databases;

import static World.ConfigReader.ReadConfigFile;
import java.io.IOException;
import java.sql.*;

public class DatabaseConnection {

    public static String status = "Não conectado.";
    public DatabaseConnection() { 
    }
    
    public enum PStatements {
    INS_ALGO("INSERT INTO db (a,b,c) VALUES ???"),
    DEL_ALGO("DELETE FROM db WHERE a = ?"),
    SEL_ALGO("SELECT b FROM db WHERE a = ?");

    public String sttm;
    
    private PStatements(String str) {
        this.sttm = str;
    }
    public static String GetPreparedStatements(PStatements str){
        return str.sttm;
    }
}

//Método de Conexão//
public static java.sql.Connection getConexaoMySQL() throws IOException {
    Connection connection = null;
    try
    {
        // Carregando o JDBC Driver padrão
        String driverName = "com.mysql.jdbc.Driver";

        Class.forName(driverName);
        String server = ReadConfigFile("MySQLServer");
        String database = ReadConfigFile("MySQLDatabase");
        String login = ReadConfigFile("MySQLUser");
        String password = ReadConfigFile("MySQLPassword");
        String url = "jdbc:mysql://" + server + "/" + database;
        connection = DriverManager.getConnection(url, login, password);

        if (connection != null) {
            status = ("STATUS--->Conectado com sucesso!");
        } else {
            status = ("STATUS--->Não foi possivel realizar conexão");
        }
        return connection;
    }
    catch (ClassNotFoundException e) {
        //Driver não encontrado
        System.out.println("O driver expecificado nao foi encontrado.");
        return null;
    }
    catch (SQLException e) {
        //Não conseguindo se conectar ao banco
        System.out.println("Nao foi possivel conectar ao Banco de Dados.");
        return null;
    }
}
//Método que retorna o status da sua conexão//
public static String GetConectionStatus() {
    return status;
}

//Método que fecha sua conexão//
public static boolean FecharConexao() throws IOException {
    try {
        DatabaseConnection.getConexaoMySQL().close();
        return true;
    } catch (SQLException e) {
        return false;
    }
}

//Método que reinicia sua conexão//
public static java.sql.Connection ReiniciarConexao() throws IOException {
    FecharConexao();
    return DatabaseConnection.getConexaoMySQL();
}
}
