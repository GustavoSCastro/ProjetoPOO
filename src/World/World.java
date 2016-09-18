package World;

import java.io.IOException;
import static Databases.DatabaseConnection.*;
import java.sql.*;

public class World {

    public static void  main(String args[]) throws IOException, SQLException {
            java.sql.Connection connection = getConexaoMySQL();
            System.out.println(GetConectionStatus());
            /*
                PreparedStatement stmt = connection.prepareStatement(PStatements.GetPreparedStatements(PStatements.INS_ALGO));
                stmt.setInt(1, 2);
                stmt.execute();
                stmt.clearParameters();
                
                stmt = connection.prepareStatement(PStatements.GetPreparedStatements(PStatements.SEL_ALGO));
                ResultSet result = stmt.executeQuery();
                while (result.next())
                {
                    int i = 1;
                    System.out.println(result.getInt(i));
                    ++i;
                }
                */
            //Integer.parseInt(prop.getProperty(param)); // Mudar de String pra int
    }
}