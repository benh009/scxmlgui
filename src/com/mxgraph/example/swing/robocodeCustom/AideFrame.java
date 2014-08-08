/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mxgraph.example.swing.robocodeCustom;


import com.mxgraph.examples.config.SCXMLConstraints;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author hofbauer
 */
public class AideFrame extends JPanel {
    private JLabel documentationLabel = new JLabel();
    private JLabel nameLabel = new JLabel();
  private JComboBox combo = new JComboBox();

    public AideFrame()
    {
        super();
        this.setLayout(new BorderLayout());

        combo = new JComboBox();
        combo.setPreferredSize(new Dimension(200, 20));
        
        this.add(documentationLabel,BorderLayout.SOUTH);
        this.add(combo,BorderLayout.NORTH);
        
        
    }
    private SCXMLConstraints.RestrictedAction as;
    public void addElementCombo(SCXMLConstraints.RestrictedAction as)
    {
        this.as=as;
        combo.addItemListener(new  ItemState());
    
            for (SCXMLConstraints.RestrictedAction.PossibleAction a : as.getPossibleAction()) {
               
                combo.addItem(a.getName());
                
                
            
        }
            
            
    }
      class ItemState implements ItemListener{
    public void itemStateChanged(ItemEvent e) {
        
        System.out.println( combo.getSelectedIndex());
        
      documentationLabel.setText(as.getPossibleAction().get( combo.getSelectedIndex()).getDocumentation());
    }               
  }
    
    public JLabel getDocumentationLabel()
    {
        return documentationLabel;
    }
     public JLabel getNameLabel()
    {
        return nameLabel;
    }
    
    
}
