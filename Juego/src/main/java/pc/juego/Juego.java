/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pc.juego;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.json.JSONObject;
        /**
 *
 * @author sebastianqr.2208
 */
public class Juego extends javax.swing.JFrame {
    int tam = 27;
    int inicio = 10;
    static int tipo = 0;
    int nivel = 1;
    static ArrayList<JButton> botones = new ArrayList<>();
    ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();
    ManejadorArchivos manejador=new ManejadorArchivos();
    JButton ultimoModificado = null;
    ImageIcon puntero = new ImageIcon("imagenes/botones/puntero.png");
    ImageIcon muro = new ImageIcon("imagenes/botones/muro.jpeg");
    ImageIcon contacto = new ImageIcon("imagenes/botones/soldado.png");
    ImageIcon mediano = new ImageIcon("imagenes/botones/mediano.png");
    ImageIcon avion = new ImageIcon("imagenes/botones/avion.png");
    ImageIcon iron = new ImageIcon("imagenes/botones/multiple.png");
    
    ArrayList<String> rutas = new ArrayList<>();
    ArrayList<JSONObject> defensas = new ArrayList<>();
    ArrayList<JSONObject> supers = new ArrayList<>();
    ArrayList<JSONObject> ataques = new ArrayList<>();
    
    private String[] delete(String[] arr, String ele){
        ArrayList<String> aux = new ArrayList<>();
        for(String i: arr){
            if(!i.equals(ele)){
                aux.add(i);
            }
        }
        return aux.toArray(new String[0]);
    }
    
    private void leerArchivos(){
        int c = 0;
        for(String ruta : rutas){
            String aux = manejador.leer(ruta);
            String[] aux2 = aux.split("@");
            aux2 = delete(aux2, "");
            for(String i: aux2){
                if(c == 0){
                    defensas.add(new JSONObject(i));
                }
                else if(c == 1){
                    supers.add(new JSONObject(i));
                }
                else{
                    ataques.add(new JSONObject(i));
                }
            }
            c++;
        }
    }
    
    
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
        rutas.add("personajes/defensas.txt");
        rutas.add("personajes/super.txt");
        rutas.add("personajes/ataques.txt");
        leerArchivos();
        System.out.println(ataques);
        
        
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
        username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        entrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        principal = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        malla = new javax.swing.JButton();
        iniciar = new javax.swing.JButton();
        multiple = new javax.swing.JButton();
        cont = new javax.swing.JButton();
        med = new javax.swing.JButton();
        aereo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        usernamer = new javax.swing.JTextField();
        passwordr = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel1.setText("Login");

        entrar.setText("Entrar");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jButton4.setText("Registrarse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(152, 152, 152))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 446, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(14, 14, 14))
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

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 50)); // NOI18N
        jLabel4.setText("Registrarse");

        jLabel5.setText("Username");

        jLabel6.setText("Password");

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Login");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(usernamer, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addComponent(passwordr, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(149, 149, 149))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(314, 314, 314))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(313, 313, 313))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(16, 16, 16))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordr, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(usernamer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(53, 53, 53)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 416, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(20, 20, 20))
        );

        pantallas.addTab("tab3", jPanel2);

        getContentPane().add(pantallas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

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
        for (JSONObject defensa : defensas) {
            System.out.println("DEFENSA: " + defensa);
            if (Manager.nivel == (int) defensa.get("nivel_aparicion")) {
                switch (defensa.get("ataque").toString()) {
                    case "Aereo":

                        Zombie z = ZombieFactory.getNewZombie(TIPOZOMBIE.AEREO, "Z_Aereo", "", (int) defensa.getInt("vida"), (int) defensa.get("golpes_por_segundo"),
                                5, 1, (int) defensa.get("nivel_aparicion"));
                        z.start();
                        System.out.println("ZOMBIE AEREO CREADO");

                        break;

                    case "Contacto":
                        Zombie z2 = ZombieFactory.getNewZombie(TIPOZOMBIE.CONTACTO, "Z_Aereo", "", (int) defensa.getInt("vida"), (int) defensa.get("golpes_por_segundo"),
                                5, 1, (int) defensa.get("nivel_aparicion"));
                        z2.start();
                        System.out.println("ZOMBIE CONTACTO CREADO");
                        break;
                    case "Mediano Alcance":
                        Zombie z3 = ZombieFactory.getNewZombie(TIPOZOMBIE.MEDIO_ALCANCE, "Z_Aereo", "", (int) defensa.getInt("vida"), (int) defensa.get("golpes_por_segundo"),
                                5, 1, (int) defensa.get("nivel_aparicion"));
                        z3.start();
                        System.out.println("ZOMBIE MED CREADO");
                        break;
                    case "Choque":
                        Zombie z4 = ZombieFactory.getNewZombie(TIPOZOMBIE.AEREO, "Z_Aereo", "", (int) defensa.getInt("vida"), (int) defensa.get("golpes_por_segundo"),
                                5, 1, (int) defensa.get("nivel_aparicion"));
                        z4.start();
                        System.out.println("ZOMBIE CHOQUE CREADO");
                        break;

                }
            }
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

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        // TODO add your handling code here:
        String user = username.getText();
        String pass = new String(password.getPassword());
                
        String info = manejador.leer("usuarios/jugadores/" + user + "/" + user + ".txt");
                
        if(!info.equals("1")){
            String[] aux = info.split(",");
            if(user.equals(aux[0]) && pass.equals(aux[1])){
                pantallas.setSelectedIndex(1);
                username.setText("");
                password.setText("");
            }
            else{
              JOptionPane.showMessageDialog(pantallas, "Usuario o Contraseña incorrecta!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);   
            }
        }
        else{
            JOptionPane.showMessageDialog(pantallas, "Usuario no Existe!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_entrarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        pantallas.setSelectedIndex(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String ruta = "usuarios/jugadores/";
        String user = usernamer.getText();
        String pass = passwordr.getText();
        
        if(!pass.equals("") && !pass.equals(" ") && !user.equals("") && !user.equals(" ")){
            int a = manejador.crear_carpeta(ruta + user);
            if(a == 0){
                manejador.escribir(ruta + user + "/" + user + ".txt", user + "," + pass);
                JOptionPane.showMessageDialog(pantallas, "Usuario Creado!!!", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
                username.setText(user);
                password.setText(pass);
                pantallas.setSelectedIndex(0);
                passwordr.setText("");
                usernamer.setText("");
            }
            else{
                JOptionPane.showMessageDialog(pantallas, "Usuario ya existe!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(pantallas, "Ingrese un Usuario y Contraseña Validos!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        pantallas.setSelectedIndex(2);
    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JButton entrar;
    private javax.swing.JButton iniciar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton malla;
    private javax.swing.JButton med;
    private javax.swing.JButton multiple;
    private javax.swing.JTabbedPane pantallas;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField passwordr;
    public javax.swing.JPanel principal;
    private javax.swing.JTextField username;
    private javax.swing.JTextField usernamer;
    // End of variables declaration//GEN-END:variables
}
