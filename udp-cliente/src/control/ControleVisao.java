/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.Partida;
import vision.JDGJogo;
import vision.JFRTelaInicial;

/**
 *
 * @author gudeck
 */
public class ControleVisao {

    private ControleVisao() {
    }

    public static ControleVisao getInstance() {
        return ControleVisaoHolder.INSTANCE;
    }

    private static class ControleVisaoHolder {

        private static final ControleVisao INSTANCE = new ControleVisao();
    }

    JFRTelaInicial telaInicial;

    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        ControleVisao visaoCtrl = ControleVisao.getInstance();
        visaoCtrl.telaInicial();

    }
    
    public void telaInicial() {
        telaInicial = new JFRTelaInicial(this);
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setVisible(true);
    }

    public void jogo(Partida partida) {
        JDGJogo jogo = new JDGJogo(telaInicial, true, this, partida);
        jogo.setLocationRelativeTo(null);
        jogo.setResizable(false);
        jogo.setVisible(true);
    }
    
    

}
