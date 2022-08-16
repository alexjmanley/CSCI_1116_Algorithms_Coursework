package programming21_11;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  private Map<String, Integer>[] mapForBoy = new HashMap[10];
  private Map<String, Integer>[] mapForGirl = new HashMap[10];
  private URL[] urls = new URL[10]; 
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) throws MalformedURLException {
	  //adding in all names and ranks 
	  mapForBoy[0] = new HashMap<>(); 
	  mapForBoy[1] = new HashMap<>();
	  mapForBoy[2] = new HashMap<>();
	  mapForBoy[3] = new HashMap<>();
	  mapForBoy[4] = new HashMap<>();
	  mapForBoy[5] = new HashMap<>();
	  mapForBoy[6] = new HashMap<>();
	  mapForBoy[7] = new HashMap<>();
	  mapForBoy[8] = new HashMap<>();
	  mapForBoy[9] = new HashMap<>();
	  mapForGirl[0] = new HashMap<>();
	  mapForGirl[1] = new HashMap<>();
	  mapForGirl[2] = new HashMap<>();
	  mapForGirl[3] = new HashMap<>();
	  mapForGirl[4] = new HashMap<>();
	  mapForGirl[5] = new HashMap<>();
	  mapForGirl[6] = new HashMap<>();
	  mapForGirl[7] = new HashMap<>();
	  mapForGirl[8] = new HashMap<>();
	  mapForGirl[9] = new HashMap<>();
	  urls[0] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking2001.txt");
	  urls[1] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking2002.txt");
	  urls[2] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking2003.txt");
	  urls[3] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking2004.txt");
	  urls[4] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking2005.txt");
	  urls[5] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking2006.txt");
	  urls[6] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking2007.txt");
	  urls[7] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking2008.txt");
	  urls[8] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking2009.txt");
	  urls[9] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking2010.txt");
	  for (int i = 0; i < 10; i++) {
		  try {
			Scanner input = new Scanner(urls[i].openStream());
			int rank = 0; 
			String boy = null; 
			String girl = null; 
			while (input.hasNext() == true) {
				rank = Integer.parseInt(input.next()); 
				boy = input.next().toLowerCase(); 
				input.next();
				girl = input.next().toLowerCase(); 
				input.next(); 
				mapForBoy[i].put(boy, rank); 
				mapForGirl[i].put(girl, rank); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  // set on action for ranking button 
	  btFindRanking.setOnAction(e -> {
		  Scene scene = new Scene(answerpane(), 370, 160);
		  primaryStage.setScene(scene);
	  });
	 
	GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
    }
    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");

  }
  	public BorderPane answerpane() {
  		String gender = this.cboGender.getValue();
  		int year = this.cboYear.getValue() - 2001;
  		String name = this.tfName.getText().toLowerCase(); 
  		int rank = 0; 
  		if(gender.equalsIgnoreCase("male")) 
  			rank = this.mapForBoy[year].get(name);
  		else
  			rank = this.mapForGirl[year].get(name); 
  		String value = String.valueOf(rank); 
  		Label label = new Label(value); 
  		BorderPane pane = new BorderPane();
  		pane.setCenter(label);
		return pane;
  	}
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}

