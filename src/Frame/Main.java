package Frame;

import codefest.loadData;
import codefest.setupDataSet;
import java.util.ArrayList;
import org.jfree.chart.ChartPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Frank
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private setupDataSet set;
    private loadData load;
    public Main() {
        initComponents();
        set = new setupDataSet();
        ArrayList<String> Steps = new ArrayList<>();
        for (int x = 1; x <= 5; x++) {
            Steps.add("Step " + x);
        }
        charts(Steps);
        errorLineChart(Steps);
        processRateChart(Steps);

    }

    private void charts(ArrayList<String> steps) {
        RealTimePanel.removeAll();
        set.setSteps(steps);
        ChartPanel chart = set.setupBarChart();
        RealTimePanel.add(chart);
        RealTimePanel.revalidate();
        RealTimePanel.repaint();

    }

    private void errorLineChart(ArrayList<String> steps) {
        ErrrorPercentagePanel.removeAll();
        set.setSteps(steps);
        ChartPanel errorpanel = set.setupErrorLineChart();
        ErrrorPercentagePanel.add(errorpanel);
        ErrrorPercentagePanel.revalidate();
        ErrrorPercentagePanel.repaint();
    }

    private void processRateChart(ArrayList<String> steps) {
        ProcessRatePanel.removeAll();
        set.setSteps(steps);
        ChartPanel ratepanel = set.setupProcessLineChart();
        ProcessRatePanel.add(ratepanel);
        ProcessRatePanel.revalidate();
        ProcessRatePanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        RealTimePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ProcessRatePanel = new javax.swing.JPanel();
        ErrrorPercentagePanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 50, 5));

        btnStart.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jPanel1.add(btnStart);

        btnStop.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnStop.setText("Stop");
        btnStop.setEnabled(false);
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        jPanel1.add(btnStop);

        RealTimePanel.setBackground(new java.awt.Color(255, 0, 51));
        RealTimePanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        ProcessRatePanel.setBackground(new java.awt.Color(0, 204, 0));
        ProcessRatePanel.setLayout(new java.awt.BorderLayout());
        jPanel3.add(ProcessRatePanel);

        ErrrorPercentagePanel.setBackground(new java.awt.Color(0, 153, 102));
        ErrrorPercentagePanel.setLayout(new java.awt.BorderLayout());
        jPanel3.add(ErrrorPercentagePanel);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Report");
        jMenu2.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu2MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RealTimePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RealTimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                load = new loadData(set);
                ArrayList<String> steps = load.getSteps();
                charts(steps);
                errorLineChart(steps);
                processRateChart(steps);
                load.startReading();
                btnStop.setEnabled(true);
                btnStart.setEnabled(false);
            }
        }).start();


    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        load.stopReading();
    }//GEN-LAST:event_btnStopActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu2MenuKeyPressed
        
    }//GEN-LAST:event_jMenu2MenuKeyPressed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        ReportFilter rf = new ReportFilter();
        rf.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });

//        JPanel RealTimePanel = new JPanel();
//        RealTimePanel.setLayout(new java.awt.BorderLayout());
//        barChart bc = new barChart("Test");
//        RealTimePanel.add(bc);
//        bc.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ErrrorPercentagePanel;
    private javax.swing.JPanel ProcessRatePanel;
    private javax.swing.JPanel RealTimePanel;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
