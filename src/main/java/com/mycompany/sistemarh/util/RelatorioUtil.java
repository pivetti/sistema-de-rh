/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.util;

import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Pichau
 */
public class RelatorioUtil {

    public static void abrirPDF(String nomeRelatorio,
                                Map<String, Object> parametros,
                                Connection con) {
        try {
            // carrega pelo classpath
            InputStream relatorioStream =
                RelatorioUtil.class.getResourceAsStream(
                    "/relatorios/" + nomeRelatorio + ".jasper"
                );

            if (relatorioStream == null) {
                throw new RuntimeException(
                    "Relatório não encontrado: " + nomeRelatorio
                );
            }

            JasperPrint print = JasperFillManager.fillReport(
                relatorioStream,
                parametros,
                con
            );

            File pdfTemp = File.createTempFile("relatorio_", ".pdf");
            pdfTemp.deleteOnExit();

            JasperExportManager.exportReportToPdfFile(
                print,
                pdfTemp.getAbsolutePath()
            );

            Desktop.getDesktop().open(pdfTemp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

