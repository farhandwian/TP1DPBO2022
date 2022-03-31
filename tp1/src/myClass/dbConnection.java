/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClass;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ACER
 */
public class dbConnection {
    public static Connection con;
    public static Statement stm;
    
    public void connect(){//untuk membuka koneksi ke database
        try {
            String url ="jdbc:mysql://localhost:3309/db_dpbo";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();
            System.out.println("koneksi berhasil;");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("koneksi gagal " +e.getMessage());
        }
    }
    
    public DefaultTableModel readTable(){
        
        DefaultTableModel dataTabel = null;
        try{
            Object[] column = {"No", "Nama", "Nim"};
            connect();
            dataTabel = new DefaultTableModel(null, column);
            String sql = "Select nama,nim from mahasiswa";
            ResultSet res = stm.executeQuery(sql);
            
            int no = 1;
            while(res.next()){
                Object[] hasil = new Object[3];
                hasil[0] = no;
                hasil[1] = res.getString("nama");
                hasil[2] = res.getString("nim");
                no++;
                System.out.print(hasil[1]);
                dataTabel.addRow(hasil);
            }
        }catch(SQLException e){
            System.err.println("Read gagal " +e.getMessage());
        }
        
        return dataTabel;
    }
    
    public ResultSet Query(String inputan){
        
        try{
            connect();
            String sql = inputan;
            return stm.executeQuery(sql);
            
        }catch(SQLException e){
            System.err.println("Read gagal " +e.getMessage());
        }
        return null;
    }
}
