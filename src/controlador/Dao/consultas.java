/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Dao;

import conection.dataBase.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Aletz
 */
public class consultas {

    public void guardarUsuario(String usuario, String password, String correo) {

        ConexionDB db = new ConexionDB();
        String sql = "CALL itsonspace.insertar_usuario('" + usuario + "', '" + password + "', '" + correo + "');";
      

        java.sql.Statement st;
        java.sql.Connection conexion = db.conectar();
        try {
            st = conexion.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void consultarUsuario(String user, String pass) {
        ConexionDB db = new ConexionDB();
        String usuarioCorrecto = null;
        String passCorrecto = null;
        String tipoDeCuenta = null;

        try {
            java.sql.Connection cn = db.conectar();
            PreparedStatement pst = cn.prepareStatement("{call itsonspace.obtener_usuario(?)}");
            pst.setString(1, user);
            ResultSet rs = pst.executeQuery();

            boolean usuarioEncontrado = false;

            while (rs.next()) {
                usuarioEncontrado = true;
                usuarioCorrecto = rs.getString(1);
                passCorrecto = rs.getString(2);
                tipoDeCuenta = rs.getString(3);

                if (pass.equals(passCorrecto)) {
                    String mensaje = "Login correcto. Bienvenido " + user + ".\n";
                    if (tipoDeCuenta.equals("admin")) {
                        mensaje += "Esta cuenta es Admin.";
                    } else {
                        mensaje += "Esta cuenta es Colaborador.";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                    break; // Salir del bucle si se encuentra una coincidencia
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta para el usuario " + user);
                }
            }

            if (!usuarioEncontrado) {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado: " + user);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }

    }

}
