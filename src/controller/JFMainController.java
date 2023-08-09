package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Transform;
import view.JFMain;

public class JFMainController implements ActionListener{

    JFMain window;

    public JFMainController(JFMain window){
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("transform")){
            handleTransform();
        }   
    }
    
    private void handleTransform(){
        try{
            int startBase = Integer.parseInt(window.getCBStartBase().getSelectedItem().toString());
            int targetBase = Integer.parseInt(window.getCBTargetBase().getSelectedItem().toString());
            String num = window.getTxtStartNumber().getText();
            String result = transform(startBase, targetBase, num);
            JOptionPane.showMessageDialog(window, makeAlertOutput(result, startBase, targetBase, num));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Verifique los datos");
        }
    }

    private String makeAlertOutput(String result, int startBase, int targetBase, String num){
        return "El número " + num + " de base " + startBase + " a base " + targetBase + " es:\n" + result;
    }

    private String transform(int startBase, int targetBase, String num){
        return Transform.convert(num, startBase, targetBase);
    }
    
}
