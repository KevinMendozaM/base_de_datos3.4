import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
        String usuario = "root";
        String password = "123456";
        Connection conn = null;
        PreparedStatement pstmt = null;


        //establecer la conexion

        try (Connection connection = DriverManager.getConnection(url, usuario, password)) {

            //preparar la sentencia sql

            String sql = "UPDATE estudiante SET bimestreUno=? WHERE cedula=?";
            pstmt = connection.prepareStatement(sql);

            //SETEAMOS LOS VALORES DE LA SENTENCIA PREVIA

            pstmt.setInt(1, 1);
            pstmt.setString(2, "1234567890");
            System.out.println(sql);
            int n = pstmt.executeUpdate();
            System.out.println("se modificaron: " + n + "Lineas");

        }

        //esto es para que me salga el mensaje de error
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            //cerramos la conexion
            try {
                if (pstmt != null) {
                    pstmt.close();

                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}