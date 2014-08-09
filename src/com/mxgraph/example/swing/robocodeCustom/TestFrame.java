/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxgraph.example.swing.robocodeCustom;

import com.mxgraph.examples.config.ObjectFactory;
import com.mxgraph.examples.config.SCXMLConstraints;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author hofbauer
 */
public class TestFrame {

    private static SCXMLConstraints restrictedStatesConfig;

    public static void main(String[] args) {

        initxml();
        AideFrame aide = new AideFrame(restrictedStatesConfig);

        JFrame frame = new JFrame();

        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.add(aide);
        //Définit un titre pour notre fenêtre
        frame.setTitle("Documentation");

        //Nous demandons maintenant à notre objet de se positionner au centre
        frame.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void initxml() {
        restrictedStatesConfig = null;
        InputStream fileInputStream = null;
        try {
            File file = new File("restrictedStates.xml");
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            System.out.println("Restriction configuration file not found. The application starts in normal mode without restriction handling.");
        }
        try {
            JAXBContext context = JAXBContext.newInstance(SCXMLConstraints.class);
            if (fileInputStream != null) {
                restrictedStatesConfig = (SCXMLConstraints) context.createUnmarshaller().unmarshal(fileInputStream);

            }
        } catch (Exception e) {
            System.out.println("Error while parsing restrictedStates.xml file: " + e.getMessage());
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing restriction configuration file!" + e.getMessage());
            }
        }
    }
}
