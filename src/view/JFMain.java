package view;

import java.awt.*;
import javax.swing.*;

import controller.JFMainController;

public class JFMain extends JFrame {

    private JFMainController controller;
    private JButton btnConvertir;
    private JComboBox<String> CBStartBase;
    private JComboBox<String> CBTargetBase;
    private JTextField txtStartNumber;
    private JPanel pnlData, pnlButtons;
    private JLabel tpStartBase, tpTargetBase, tpStartNumber;

    public JFMain() {
        initComponents();
    }

    private void initComponents() {
        controller = new JFMainController(this);
        tpStartBase = new JLabel("De base");
        tpTargetBase = new JLabel("A base");
        tpStartNumber = new JLabel("Número: ");
        pnlData = new JPanel(new GridLayout(3, 2, 10, 10));
        pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
        btnConvertir = new JButton("Convertir");
        String[] bases = { "2", "8", "10", "16" };
        CBStartBase = new JComboBox<>(bases);
        CBTargetBase = new JComboBox<>(bases);
        txtStartNumber = new JTextField("");

        pnlData.add(tpStartBase);
        pnlData.add(tpTargetBase);
        pnlData.add(CBStartBase);
        pnlData.add(CBTargetBase);
        pnlData.add(tpStartNumber);
        pnlData.add(txtStartNumber);

        pnlButtons.add(btnConvertir);

        btnConvertir.addActionListener(controller);
        btnConvertir.setActionCommand("transform");

        this.setSize(400, 250);
        this.setLayout(new GridLayout(2, 1, 10, 10));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.add(pnlData);
        this.add(pnlButtons);
    }

    public JButton getBtnConvertir() {
        return btnConvertir;
    }

    public JComboBox<String> getCBStartBase() {
        return CBStartBase;
    }

    public JComboBox<String> getCBTargetBase() {
        return CBTargetBase;
    }

    public JTextField getTxtStartNumber() {
        return txtStartNumber;
    }
}
