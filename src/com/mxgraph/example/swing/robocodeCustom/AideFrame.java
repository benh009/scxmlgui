/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxgraph.example.swing.robocodeCustom;

import com.mxgraph.examples.config.SCXMLConstraints;
import com.mxgraph.examples.swing.SCXMLGraphEditor;
import com.mxgraph.util.mxResources;
import java.awt.Dimension;
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
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author hofbauer
 */
public class AideFrame {
    
    public AideFrame(SCXMLGraphEditor editor)
    {
        initxml();
        AidePanel aide = new AidePanel(restrictedStatesConfig);

        JDialog frame = new JDialog(SwingUtilities.windowForComponent(editor));
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(600, 600);
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Liste des méthodes",aide);
         JPanel aideGlobaleRobocode= new JPanel();
         JTextPane jtext = new  JTextPane();
         jtext.setEditable(false);
        jtext.setPreferredSize(new Dimension(600, 660));
        jtext.setContentType("text/html");
         jtext.setText("<html>"+stringAideGloable+"</html>");
        aideGlobaleRobocode.add(jtext);
        tabs.addTab("Aide globale",aideGlobaleRobocode);
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
    
    private String stringAideGloable=
            ""
            + " <h1>Robocode</h1>"
            + "L'interface de base de SCXMLGUI a été adaptée pour pouvoir représenter"
            + " facilement le comportement de robots du jeu Robocode. Une fois ces robots"
            + " modélisés, leurs modèles pourront être simulés dans le jeu. Il n'est donc "
            + "pas utile de coder le comportement en Java. "
            + "<h1>Actions et informations</h1>"
            + "Il est possible d'appeler des méthodes d'un robot "
            +"à l'aide de ses objets qui servent de proxys. Les objets sont :<br>"
            +"---->RI(informations du robot)<br>"
            +"---->RA(actions du robot)<br>"
            +"---->RGI(informations du canon du robot)<br>"
            +"---->RGA(actions du canon du robot)<br>"
            +"---->GI(informations sur la partie)<br><br>"
            +"La balise permettant de lancer une action dans un OnEntry,OnExit ou dans "
            + "la partie action d'une transition est la suivante : <br>"
            +"&lt my:RA expression=\"RA.direction(0.0d)\"&gt&lt/my:RA&gt"
            +"<br><br> l'objet _event.data permet de récuperer le payload d'une transition"
            
            ;
}
