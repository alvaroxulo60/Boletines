package ejercicio1;

import io.MiEntradaSalida;
import io.PropertiesReader;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC";
        String usuario, password;

        PropertiesReader p = PropertiesReader.getInstance();

        try (Connection conexion = DriverManager.getConnection(url, p.get("usuario"), p.get("pass"));
             Statement statement = conexion.createStatement()) {

//            try (ResultSet rs = statement.executeQuery("SELECT productline from productlines")) {
//                while (rs.next()) {
//                    System.out.println("Categoria: " + rs.getString(1));
//                }
//
//            }

            String sql = "SELECT productCode, productName, buyPrice FROM products WHERE\n" +
                    "productLine = ? ORDER BY productName";

            String productLineBuscada = "Planes";

            PreparedStatement pr = conexion.prepareStatement(sql);

            pr.setString(1, productLineBuscada);

            System.out.println();
            System.out.println("Buscando productos de "+ productLineBuscada);

            String sql2 = "SELECT * FROM orders o WHERE o.customerNumber = ?";

            try (ResultSet rs = pr.executeQuery();
            PreparedStatement ps = conexion.prepareStatement(sql2)) {
//                // 3. Procesar los resultados
//                boolean encontrado = false;
//                while (rs.next()) {
//                    encontrado = true;
//                    String codigo = rs.getString("productCode");
//                    String nombre = rs.getString("productName");
//                    double precio = rs.getDouble("buyPrice");
//                    System.out.printf(" - Código: %s, Nombre: %s, Precio: %.2f%n",
//                            codigo, nombre, precio);
//                }
//                if (!encontrado){
//                    System.out.println("No se han encontrado productos para esa categoria");
//                }


                String customerNumber = MiEntradaSalida.leerLinea("Introduce el numero del usuario: \n");

                ps.setString(1,customerNumber);

                ResultSet rs2 = ps.executeQuery();





                while (rs2.next()){
                    System.out.println(rs2.getString(1));
                }

            } catch (SQLException e) {
                System.err.println("Error durante la operación con la base de datos:");
                e.printStackTrace();
            } // No se necesita finally para cerrar 'conexion'

        }
    }
}