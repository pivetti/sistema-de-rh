/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemarh;

import com.mycompany.sistemarh.util.Tema;
import com.mycompany.sistemarh.view.Login;
import java.sql.SQLException;

/**
 *
 * @author Pichau
 */
public class SistemaRH {

    public static void main(String[] args) throws SQLException {
        Tema.aplicarClaro();

        javax.swing.SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
