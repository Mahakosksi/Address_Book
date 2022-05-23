
package folder;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class AddressBookPane2  extends Pane{
    
    
    protected Label lab1= new Label("Name");
    protected TextField Name = new TextField();
    protected Label lab2 = new Label("Street");
    protected TextField Street = new TextField();
    protected Label lab3= new Label("City");
    protected TextField City = new TextField();
    protected Label lab4= new Label("State");
    protected TextField State = new TextField();
    protected Label lab5= new Label("Zip");
    protected TextField Zip = new TextField();
    protected Button add = new Button("Add");
    protected Button first = new Button("First");
    protected Button next = new Button("Next");
    protected Button previous = new Button("Previous");
    protected Button last = new Button("Last");
    protected Button update = new Button("Update");
    protected HBox pane1 = new HBox(5);
    protected HBox pane2 = new HBox(5);
    protected HBox pane3 = new HBox(5);
    protected HBox pane4 = new HBox(5);
    protected VBox pane = new VBox(5);
    
    
    public AddressBookPane2(){
        DrowAdressBook();
    }
    private void DrowAdressBook(){
        
        Name.setPrefColumnCount(23);
        Street.setPrefColumnCount(23);
        City.setPrefColumnCount(8);
        State.setPrefColumnCount(2);
        Zip.setPrefColumnCount(4);
        pane1.getChildren().addAll(lab1,Name);
        pane1.setAlignment(Pos.CENTER);
        pane2.getChildren().addAll(lab2,Street);
        pane2.setAlignment(Pos.CENTER);
        pane3.getChildren().addAll(lab3,City,lab4,State,lab5,Zip);
        pane3.setAlignment(Pos.CENTER);
        pane4.getChildren().addAll(add,first,next,previous,last,update);
        pane4.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(pane1,pane2,pane3,pane4);
        
        getChildren().add(pane);
        
        
       
        
    }
         
}
