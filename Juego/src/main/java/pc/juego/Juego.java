/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pc.juego;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author sebastianqr.2208
 */
public class Juego extends javax.swing.JFrame {
    int tam = 27;
    int inicio = 10;
    static int tipo = 0;
    static ArrayList<JButton> botones = new ArrayList<>();
    ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();
    JButton ultimoModificado = null;
    ImageIcon puntero = new ImageIcon("imagenes/botones/puntero.png");
    ImageIcon muro = new ImageIcon("imagenes/botones/muro.jpeg");
    ImageIcon contacto = new ImageIcon("imagenes/botones/soldado.png");
    ImageIcon mediano = new ImageIcon("imagenes/botones/mediano.png");
    ImageIcon avion = new ImageIcon("imagenes/botones/avion.png");
    ImageIcon iron = new ImageIcon("imagenes/botones/multiple.png");
    
    
    private void cambiarEstadoMatriz(int x, int y, int estado){
        ArrayList<Integer> lista = matriz.get(x);
        lista.set(y, estado);
    }
    
    private void accionButton(JButton boton){
        Color color = null;
        switch(tipo){
            case 0: //caso donde nada pasa
                color = null;
                break;
                
            case 1: //caso del bloque
                
                String[] nombre=boton.getName().split("-");
                int posX= Integer.valueOf(nombre[0]);
                int posY= Integer.valueOf(nombre[1]);
                Arma a =ArmaFactory.getNewArma(TIPOARMA.BLOQUE,posX,posY);
                if(a==null){
                    
                }else{
                    a.start();
                    color = Color.gray;
                }
                
                break;
                
            case 2://contacto
                String[] nombre1=boton.getName().split("-");
                int posX1= Integer.valueOf(nombre1[0]);
                int posY1= Integer.valueOf(nombre1[1]);
                Arma a1 =ArmaFactory.getNewArma(TIPOARMA.CONTACTO,posX1,posY1);
                if(a1==null){
                    
                }else{
                    a1.start();
                    color = Color.getHSBColor(170, 139, 90);
                }
                break;
                
            case 3://mediano alcance
                
                String[] nombre2=boton.getName().split("-");
                int posX2= Integer.valueOf(nombre2[0]);
                int posY2= Integer.valueOf(nombre2[1]);
                Arma a2 =ArmaFactory.getNewArma(TIPOARMA.MEDIANO_ALCANCE,posX2,posY2);
                if(a2==null){
                    
                }else{
                    a2.start();
                    color = Color.orange;
                }
                break;
                
            case 4: //aereo
                String[] nombre3=boton.getName().split("-");
                int posX3= Integer.valueOf(nombre3[0]);
                int posY3= Integer.valueOf(nombre3[1]);
                Arma a3 =ArmaFactory.getNewArma(TIPOARMA.AEREO,posX3,posY3);
                if(a3==null){
                    
                }else{
                    a3.start();
                    color = Color.blue;
                }
                
                break;
                
            case 5: //multiple
                String[] nombre4=boton.getName().split("-");
                int posX4= Integer.valueOf(nombre4[0]);
                int posY4= Integer.valueOf(nombre4[1]);
                Arma a4 =ArmaFactory.getNewArma(TIPOARMA.ATAQUE_MULTIPLE,posX4,posY4);
                if(a4==null){
                    
                }else{
                    a4.start();
                    color = Color.getHSBColor(135, 76, 98);
                }
                
                break;
        }
        String[] lista = boton.getName().split("-");
        cambiarEstadoMatriz(Integer.valueOf(lista[0]), Integer.valueOf(lista[1]), tipo);
        int[]pos=new int[2];pos[0]=Integer.valueOf(lista[0]);pos[1]=Integer.valueOf(lista[1]);
        Manager.posicionesArma.add(pos);
        boton.setBackground(color);
    }
    
    private void cambiarEstadoBotones(boolean estado){
        for(JButton i : botones){
            i.setEnabled(estado);
        }
    }

    public static ArrayList<JButton> getBotones() {
        return botones;
    }
    
    private void generarMatrix(){
        int posX = inicio, posY = inicio;
        
        for(int i =0; i < 25; i++){
            for(int j = 0; j<25; j++){
                JButton but = new JButton("");
                principal.add(but);
                but.setSize(tam, tam);
                but.setLocation(posX, posY);
                String name = Integer.toString(i) + "-" + Integer.toString(j);
                but.setName(name);
                but.addActionListener(e -> accionButton(but));
                if(j==12&&i==12){
                    but.setBackground(Color.PINK);
                }
                botones.add(but);
                posX += tam;
            }
            posY += tam;
            posX = inicio;
        }      
    }
    
    private void crearMatriz(){
        for(int i =0; i < 25; i++){
            ArrayList<Integer> a = new ArrayList<>();
            for(int j =0; j < 25; j++){
                a.add(0);
            }
            matriz.add(a);
        }
    }
    
    private void modificarUltimoCambiado(JButton boton){
        ultimoModificado.setBackground(null);
        boton.setBackground(Color.green);
        ultimoModificado = boton;
    }
    
    /**
     * Creates new form visual
     */
    public Juego() {
        initComponents();
        pantallas.setSelectedIndex(1);
        generarMatrix();
        crearMatriz();
        ultimoModificado = jButton1;
        jButton1.setBackground(Color.green);
        jButton1.setIcon(puntero);
        malla.setIcon(muro);
        cont.setIcon(contacto);
        med.setIcon(mediano);
        aereo.setIcon(avion);
        multiple.setIcon(iron);
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pantallas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        principal = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        malla = new javax.swing.JButton();
        iniciar = new javax.swing.JButton();
        multiple = new javax.swing.JButton();
        cont = new javax.swing.JButton();
        med = new javax.swing.JButton();
        aereo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField1");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel1.setText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(560, Short.MAX_VALUE))
        );

        pantallas.addTab("tab1", jPanel1);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        malla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mallaActionPerformed(evt);
            }
        });

        iniciar.setText("Iniciar");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        multiple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multipleActionPerformed(evt);
            }
        });

        cont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contActionPerformed(evt);
            }
        });

        med.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medActionPerformed(evt);
            }
        });

        aereo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aereoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalLayout.createSequentialGroup()
                .addContainerGap(764, Short.MAX_VALUE)
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aereo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(multiple, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(malla, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cont, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(med, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iniciar)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(malla, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cont, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(med, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aereo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(multiple, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pantallas.addTab("tab2", principal);

        getContentPane().add(pantallas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tipo = 0;
        modificarUltimoCambiado(jButton1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mallaActionPerformed
        // TODO add your handling code here:
        tipo = 1;
        modificarUltimoCambiado(malla);
    }//GEN-LAST:event_mallaActionPerformed

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
        // TODO add your handling code here:
        for(int i=0;i<2;i++){
            
            Zombie z =ZombieFactory.getNewZombie(TIPOZOMBIE.CONTACTO,(int)(Math.random()*23),(int) (Math.random() * 23));
            Zombie z1 =ZombieFactory.getNewZombie(TIPOZOMBIE.AEREO,(int) (Math.random() * 23),(int) (Math.random() * 23));
            Zombie z2 =ZombieFactory.getNewZombie(TIPOZOMBIE.MEDIO_ALCANCE,(int) (Math.random() * 23),(int) (Math.random() * 23));
            z.start();
            z1.start();
            z2.start();
        }
    }//GEN-LAST:event_iniciarActionPerformed

    private void multipleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multipleActionPerformed
        // TODO add your handling code here:
        tipo = 2;
        modificarUltimoCambiado(multiple);
    }//GEN-LAST:event_multipleActionPerformed

    private void contActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contActionPerformed
        // TODO add your handling code here:
        tipo = 2;
        modificarUltimoCambiado(cont);
    }//GEN-LAST:event_contActionPerformed

    private void medActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medActionPerformed
        // TODO add your handling code here:
        tipo = 3;
        modificarUltimoCambiado(med);
    }//GEN-LAST:event_medActionPerformed

    private void aereoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aereoActionPerformed
        // TODO add your handling code here:
        tipo = 4;
        modificarUltimoCambiado(aereo);
    }//GEN-LAST:event_aereoActionPerformed

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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aereo;
    private javax.swing.JButton cont;
    private javax.swing.JButton iniciar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton malla;
    private javax.swing.JButton med;
    private javax.swing.JButton multiple;
    private javax.swing.JTabbedPane pantallas;
    public javax.swing.JPanel principal;
    // End of variables declaration//GEN-END:variables
}
