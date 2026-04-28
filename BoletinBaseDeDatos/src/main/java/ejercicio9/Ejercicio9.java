package ejercicio9;

import exception.AppException;
import io.MiEntradaSalida;
import io.PropertiesReader;

import java.sql.*;

public class Ejercicio9 {

    static void main(String[] args) {
        try{
            PropertiesReader pop = PropertiesReader.getInstance();

            String nombreCliente = MiEntradaSalida.leerLinea("Introduce el nombre del cliente: \n");

            String sqlOrder = "DELETE FROM orderdetails WHERE orderNumber IN " +
                    "(SELECT orderNumber FROM orders WHERE customerNumber = " +
                    "(SELECT customerNumber FROM customers WHERE customerName = ?))";

            String sqlPedidos = "DELETE FROM orders WHERE customerNumber = " +
                    "(SELECT customerNumber FROM customers WHERE customerName = ?)";

            String sqlPagos = "DELETE FROM payments WHERE customerNumber = " +
                    "(SELECT customerNumber FROM customers WHERE customerName = ?)";

            String sqlCustomer = "DELETE FROM customers WHERE customerName = ?";


            try(Connection con =DriverManager.getConnection(pop.get("url"),pop.get("usuario"),pop.get("pass"));
                PreparedStatement pr = con.prepareStatement(sqlOrder); PreparedStatement pr2 = con.prepareStatement(sqlPedidos);
                PreparedStatement pr3 = con.prepareStatement(sqlPagos);PreparedStatement pr4 = con.prepareStatement(sqlCustomer)){
                con.setAutoCommit(false);

                pr.setString(1,nombreCliente);
                pr2.setString(1,nombreCliente);
                pr3.setString(1,nombreCliente);
                pr4.setString(1,nombreCliente);

                pr.executeUpdate();
                pr2.executeUpdate();
                pr3.executeUpdate();
               int lineasBorradas =  pr4.executeUpdate();

                if (lineasBorradas > 0){
                    con.commit();
                    System.out.printf("Cliente borrado correctamente %n");
                }else {
                    con.rollback();
                    System.out.printf("Cliente no encontrado %n");
                }

            }

        }catch(AppException | SQLException e){
            System.out.printf("%s", e.getMessage());
        }
    }
}
