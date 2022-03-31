/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClass;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ACER
 */
public class MyImageHandler {
    private String path;
    private File selFile;
    private ImageIcon img;
    public MyImageHandler(){
    }
    
    public void Browse()
    {
        JFileChooser file = new JFileChooser();
        //filtering files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png", "jpeg");
        file.addChoosableFileFilter(filter);
        file.setAcceptAllFileFilterUsed(false);
        int res = file.showOpenDialog(null);
        //if the user clicks on save in Jfilechooser
        if(res == JFileChooser.APPROVE_OPTION){
          this.selFile = file.getSelectedFile();
          this.path =  selFile.getName();
        }
        
    }
     
    // Method to resize the image with the same size of the Jlabel
    public void resize()
    {
      ImageIcon l_path = new ImageIcon(this.path);
      Image l_img = l_path.getImage();
      Image newImg = l_img.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
      ImageIcon image = new ImageIcon(newImg);
      this.img = image;
    }
    public String getPath(){
        return this.path;
    }
    
    public File getFile(){
        return this.selFile;
    }
    
    public ImageIcon getImg(){
        return this.img;
    }
}
