/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxgraph.example.swing.robocodeCustom;

import com.mxgraph.examples.config.SCXMLConstraints;
import com.mxgraph.examples.swing.SCXMLGraphEditor;
import com.mxgraph.util.mxResources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author hofbauer
 */
public class TestFrame {
    
    public TestFrame(SCXMLGraphEditor editor)
    {
        initxml();
        AideFrame aide = new AideFrame(restrictedStatesConfig);

        JDialog frame = new JDialog(SwingUtilities.windowForComponent(editor));
        frame.pack();

        frame.setVisible(true);
        frame.setSize(400, 400);
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Liste des méthodes",aide);
        tabs.addTab("Aide globale",new JPanel());
        frame.add(tabs);
        //Définit un titre pour notre fenêtre
        frame.setTitle("Documentation");
        

        //Nous demandons maintenant à notre objet de se positionner au centre
        frame.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
  
    }

    private static SCXMLConstraints restrictedStatesConfig;

    public static void main(String[] args) {

        //TestFrame t = new TestFrame();

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
