/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import myClass.AuthorWrapperCB;
import myClass.dbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import myClass.MyImageHandler;

/**
 *
 * @author ACER
 */
public class FormBuku extends javax.swing.JFrame {
    private int id;
    private int id_author;
    private String penerbit;
    private String des;
    private String img;
    private Main.MainFrame mf;
    myClass.MyImageHandler imgHandler = new MyImageHandler();
    static dbConnection db = new dbConnection();
    /**
     * Creates new form formAdd
     * @param mf
     */
    
    public FormBuku(Main.MainFrame mf) {
        initComponents();
        this.mf = mf;
        setAddForm();
    }
    
    public FormBuku(int id, Main.MainFrame mf) {
        initComponents();
        this.id = id;
        this.mf = mf;
        setEditForm();
    }
    
    public void setBuku(){
        try{
            String sql = "SELECT * FROM tb_buku WHERE id = '"+this.id+"'";
            ResultSet res = db.Query(sql);
            while(res.next()){
                this.id_author = res.getInt("id_author");
                this.penerbit = res.getString("penerbit");
                this.des = res.getString("des");
                this.img = res.getString("img");
            }            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void setAddForm(){
        cbAuthor.removeAllItems();
        try{
            String sql = "SELECT id, nama FROM tb_author";
            ResultSet res = db.Query(sql);
            while(res.next()){
                AuthorWrapperCB author = new AuthorWrapperCB();
                author.setId(res.getInt("id"));
                author.setPosition(res.getString("nama"));
                cbAuthor.addItem(author);
            }            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        judul.setText("ADD Buku");
        btnAdd.setVisible(true);
        btnEdit.setVisible(false);
        labelId.setVisible(false);
    }
    
    public void setEditForm(){
        setBuku();
        btnAdd.setVisible(false);
        btnClear.setVisible(false);
        judul.setText("EDIT BUKU");
        tfPenerbit.setText(this.penerbit);
        taDesc.setText(this.des);
        labelId.setText("ID : "+this.id);
        labelImg.setText(this.img);
        cbAuthor.removeAllItems();
        setBuku();
        try{
            String sql = "SELECT id, nama FROM tb_author";
            ResultSet res = db.Query(sql);
            while(res.next()){
                AuthorWrapperCB author = new AuthorWrapperCB();
                author.setId(res.getInt("id"));
                author.setPosition(res.getString("nama"));
                cbAuthor.addItem(author);
                if(res.getInt("id") == this.id_author)
                    cbAuthor.setSelectedItem(author);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void uploadImg(String img){
         try {
            Path copied = Paths.get("src/image/buku/"+img);
            Path originalPath = Paths.get(imgHandler.getFile().getAbsolutePath());
            Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
          } catch (IOException e) {
              JOptionPane.showMessageDialog(null, e.getMessage());
              e.printStackTrace();
          }
    }
    
    public void clearForm(){
        tfPenerbit.setText("");
        taDesc.setText("");
        cbAuthor.setSelectedIndex(0);
        labelImg.setText("");
        imgHandler = new MyImageHandler();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        judul = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        tfPenerbit = new javax.swing.JTextField();
        cbAuthor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDesc = new javax.swing.JTextArea();
        btnEdit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        labelImg = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N

        judul.setFont(new java.awt.Font("Papyrus", 0, 17)); // NOI18N
        judul.setForeground(new java.awt.Color(51, 51, 51));
        judul.setText("ADD BUKU");

        jLabel2.setFont(new java.awt.Font("Papyrus", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Penerbit");

        jLabel3.setFont(new java.awt.Font("Papyrus", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Author");

        jLabel4.setFont(new java.awt.Font("Papyrus", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Desc");

        labelId.setForeground(new java.awt.Color(51, 51, 51));
        labelId.setText("id");

        btnAdd.setFont(new java.awt.Font("Papyrus", 0, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(51, 51, 51));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tfPenerbit.setForeground(new java.awt.Color(51, 51, 51));

        cbAuthor.setForeground(new java.awt.Color(51, 51, 51));
        cbAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAuthorActionPerformed(evt);
            }
        });

        jScrollPane1.setForeground(new java.awt.Color(51, 51, 51));

        taDesc.setColumns(20);
        taDesc.setRows(5);
        jScrollPane1.setViewportView(taDesc);

        btnEdit.setFont(new java.awt.Font("Papyrus", 0, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(51, 51, 51));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Papyrus", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("BROWSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Papyrus", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Image");

        btnClear.setFont(new java.awt.Font("Papyrus", 0, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(51, 51, 51));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbAuthor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfPenerbit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(judul)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelId)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd)
                        .addGap(39, 39, 39)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(judul)
                    .addComponent(labelId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(labelImg)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        penerbit = tfPenerbit.getText();
        id_author = ((AuthorWrapperCB)cbAuthor.getSelectedItem()).getId();
        des = taDesc.getText();
        if((penerbit != null) && (id_author != 0) && (des != null) && (imgHandler.getFile() != null)){
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
            this.img = ft.format(dNow)+"_"+imgHandler.getFile().getName();
            try{
                uploadImg(this.img);
                String sql = "INSERT INTO `tb_buku` (`id`, `id_author`, `penerbit`, `des`, `img`) VALUES (null, '"+id_author+"','"+penerbit+"','"+des+"','"+img+"')";
                db.stm.execute(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
                this.mf.setItem();
                this.dispose();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Lengkapi Form", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAuthorActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        penerbit = tfPenerbit.getText();
        id_author = ((AuthorWrapperCB)cbAuthor.getSelectedItem()).getId();
        des = taDesc.getText();
        if((penerbit != null) && (id_author != 0) && (des != null)){
            if(imgHandler.getFile()!=null){
                uploadImg(this.img);
            }
            int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin mengubah data ini ?", "Edit Data", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION){
                try{
                    String sql = "UPDATE `tb_buku` SET penerbit = '"+penerbit+"', id_author= '"+id_author+"', des = '"+des+"' WHERE id = '"+id+"'";
                    db.stm.execute(sql);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    clearForm();
                    this.mf.setItem();
                    this.dispose();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Lengkapi Form", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        imgHandler.Browse();
        labelImg.setText(imgHandler.getPath());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<AuthorWrapperCB> cbAuthor;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel judul;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelImg;
    private javax.swing.JTextArea taDesc;
    private javax.swing.JTextField tfPenerbit;
    // End of variables declaration//GEN-END:variables
}
