package com.mxgraph.example.swing.robocodeCustom;

import com.mxgraph.examples.config.DocAffichage;
import com.mxgraph.examples.config.SCXMLConstraints;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
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
    private JComboBox comboTypeDoc = new JComboBox();
    private SCXMLConstraints restrictedStatesConfig;

    public AideFrame(SCXMLConstraints restrictedStatesConfig) {
        super();
        this.setLayout(new BorderLayout());
        this.restrictedStatesConfig = restrictedStatesConfig;
        combo.setPreferredSize(new Dimension(200, 20));
        comboTypeDoc.setPreferredSize(new Dimension(200, 20));
        documentationLabel.setSize(400, 200);

        this.add(documentationLabel, BorderLayout.CENTER);
        this.add(combo, BorderLayout.NORTH);
        this.add(comboTypeDoc, BorderLayout.SOUTH);

        comboTypeDoc.addItem("Evènement disponible");
        comboTypeDoc.addItem("Information disponible");
        comboTypeDoc.addItem("Action disponible");
        comboTypeDoc.addItemListener(new ItemTypeDoc());
        combo.addItemListener(new ItemState());


    }

    public void addElementCombo() {
        combo.removeAllItems();
        for (Object a : list) {
            combo.addItem(((DocAffichage) a).getName());
        }
    }
    
private List list;
    class ItemState implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(combo.getSelectedIndex()!=-1){
            String s = ((DocAffichage)list.get(combo.getSelectedIndex())).getDocumentation();
            documentationLabel.setText("<html>" + s + "</html>");
            }
        }
    }

    class ItemTypeDoc implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            int index = comboTypeDoc.getSelectedIndex();
            if (index == 0) {
                list = restrictedStatesConfig.getRestrictedState().get(0).getPossibleEvent();
                addElementCombo();
            } else if (index == 1) {
                list =restrictedStatesConfig.getRestrictedInformation().get(0).getPossibleInformation();
                addElementCombo();
            } else if (index == 2) {
                list= restrictedStatesConfig.getRestrictedAction().get(0).getPossibleAction();
                addElementCombo();
            }
        }
    }
}
