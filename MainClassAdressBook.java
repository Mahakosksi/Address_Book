
package folder;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClassAdressBook extends Application{
    
    protected AddressBookPane2 Book = new AddressBookPane2();
    
    public int x=0;
    
    @Override 
    public void start(Stage primaryStage) throws IOException {
       
        Scene scene = new Scene(Book);
        primaryStage.setTitle("Address Book");
        primaryStage.setScene(scene);
        primaryStage.show();
        RandomAccessFile inout = new RandomAccessFile("lab3.dat", "rw");
        
        Book.add.setOnAction(e->{
            try {
                add(inout);
            } catch (IOException ex) {
                Logger.getLogger(MainClassAdressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        Book.first.setOnAction(e->{
            try {
                first(inout);
            } catch (IOException ex) {
                Logger.getLogger(MainClassAdressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
         Book.last.setOnAction(e->{
            try {
                last(inout);
            } catch (IOException ex) {
                Logger.getLogger(MainClassAdressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
          Book.previous.setOnAction(e->{
            try {
                previous(inout);
            } catch (IOException ex) {
                Logger.getLogger(MainClassAdressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
           Book.next.setOnAction(e->{
            
            try {
                next(inout);
            } catch (IOException ex) {
                Logger.getLogger(MainClassAdressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
            Book.update.setOnAction(e->{
            
            try {
                 update(inout);
            } catch (IOException ex) {
                Logger.getLogger(MainClassAdressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }
     byte[] fixeByte(byte[] textBytes, int maxBytes){
        byte[] fixedTextBytes = new byte[maxBytes];
        for(int i=0; i<textBytes.length; i++){
            fixedTextBytes[i]= textBytes[i];
        }
        return fixedTextBytes;
    }
    
    private void write(RandomAccessFile inout) throws IOException {
        
       inout.write(fixeByte(Book.Name.getText().getBytes(),23));
       inout.write(fixeByte(Book.Street.getText().getBytes(),23));
       inout.write(fixeByte(Book.City.getText().getBytes(),8));
       inout.write(fixeByte(Book.State.getText().getBytes(),2));
       inout.write(fixeByte(Book.Zip.getText().getBytes(),4));
    }
    private void read(RandomAccessFile inout) throws IOException {
		int pos;
		byte[] name = new byte[23];	
		pos = inout.read(name);
		Book.Name.setText(new String(name));
                
                byte[] street = new byte[23];	
		pos = inout.read(street);
		Book.Street.setText(new String(street));
                
                byte[] city = new byte[8];	
		pos = inout.read(city);
		Book.City.setText(new String(city));
                
                byte[] state = new byte[2];	
		pos = inout.read(state);
		Book.State.setText(new String(state));
                
                byte[] zip = new byte[4];	
		pos = inout.read(zip);
		Book.Zip.setText(new String(zip));
    }
    private void  add(RandomAccessFile inout) throws IOException{
        
            
           inout.seek(inout.length());
           write(inout);
    }
    private void first(RandomAccessFile inout) throws  IOException{
           x=0;
           inout.seek(x);
           read(inout);
    }
    
    private void next(RandomAccessFile inout) throws  IOException{
        
           if(x<(int)(inout.length()-60)){
               x+=60;
           }
           inout.seek(x);
           read(inout);
    }
    private void previous(RandomAccessFile inout) throws  IOException{
        
           if(x>0){
               x=x-60;
           }
           inout.seek(x);
           read(inout);    
    }
    private void last(RandomAccessFile inout) throws  IOException{
        
            
           x=(int) ((inout.length())-60);
           inout.seek(x);
           read(inout);
    }
    private void update(RandomAccessFile inout) throws IOException{
        
        inout.seek(x);
        write(inout);
        
    }

    public static void main(String[] args){
        Application.launch(args);
    }
    
}
