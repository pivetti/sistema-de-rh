/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.view;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Pichau
 */
public abstract class TelaBase extends JFrame   {
    protected static final int LARGURA = 1280;
    protected static final int ALTURA  = 720;

    protected void configurarTela16x9() {
        setSize(new Dimension(LARGURA, ALTURA));
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
