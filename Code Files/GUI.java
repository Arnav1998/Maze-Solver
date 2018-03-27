package hw4;

import java.io.File;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * <p>
 * The {@code GUI} class represents
 * the graphical user interface for the
 * {@code MazeSolver} class. The {@code GUI} 
 * class extends the {@code Application} abstract
 * class and uses Javafx to produce an 
 * interactive user interface which displays
 * the graphical solution if it exists for
 * an input maze.
 * 
 * @author Arnav Singhania
 *
 */
public class GUI extends Application {

	private Scene scene;
	private MazeSolver mazeSolver;

	/**
	 * Gets called when the program first begins.
	 * Calls for the set up of the graphical user 
	 * interface for the program.
	 * 
	 * @param args An array of String objects.
	 */
	public static void main(String[] args) {

		Application.launch(args);

	}

	/**
	 * Gets called when the graphical
	 * user interface is first created.
	 * 
	 * @param primaryStage A {@code Stage} object representing
	 * 					   the current {@code Stage} used in the 
	 * 					   graphical user interface.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		setUpWelcomeScreen(primaryStage);

	}

	private void setUpWelcomeScreen(Stage primaryStage) {

		BorderPane welcomeScreenBorderPane = new BorderPane();



		Label mazeSolverLabel = new Label("Maze Solver");

		welcomeScreenBorderPane.setTop(mazeSolverLabel);

		BorderPane.setAlignment(mazeSolverLabel, Pos.CENTER);



		VBox centreVBox = new VBox();



		Button selectInputFileButton = new Button("Select Input File"); selectInputFileButton.setOnAction(e->{selectInputFileButtonClicked();});

		Button printSolutionButton = new Button("Print Solution"); printSolutionButton.setOnAction(e->{printSolutionButtonClicked();});

		Button exitButton = new Button("Exit"); exitButton.setOnAction(e->{System.exit(0);});



		centreVBox.getChildren().addAll(selectInputFileButton, printSolutionButton, exitButton);

		centreVBox.setAlignment(Pos.CENTER);

		centreVBox.setSpacing(40);



		welcomeScreenBorderPane.setCenter(centreVBox);


		scene = new Scene(welcomeScreenBorderPane, 600,600);

		scene.getStylesheets().add("hw4/resources/design.css");

		primaryStage.setScene(scene);

		primaryStage.show();

	}


	private void printSolutionButtonClicked() {
		GridPane gp = new GridPane();
		for (int a = 0; a < mazeSolver.getMap().length; a++) {
			
			for (int b = 0; b < mazeSolver.getMap()[a].length; b++) {
				
				if (mazeSolver.getMap()[a][b].getCoordinateValue() == 'S') {
					Label l = new Label("S"); l.setStyle("-fx-background-color: blue; -fx-border-color: blue; -fx-text-fill: white;");
					l.setPrefSize(75, 75);
					GridPane.setConstraints(l, b, a);
					GridPane.setHgrow(l, Priority.ALWAYS);
					GridPane.setVgrow(l, Priority.ALWAYS);
					gp.getChildren().add(l);
				} else if (mazeSolver.getMap()[a][b].getCoordinateValue() == 'E') {
					Label l = new Label("E"); l.setStyle("-fx-background-color: #dc143c; -fx-border-color: blue;  -fx-text-fill: white;");
					l.setPrefSize(75, 75);
					GridPane.setConstraints(l, b, a);
					GridPane.setHgrow(l, Priority.ALWAYS);
					GridPane.setVgrow(l, Priority.ALWAYS);
					gp.getChildren().add(l);
				} else if (mazeSolver.getMap()[a][b].getCoordinateValue() == 'W') {
					Label l = new Label("W"); l.setStyle("-fx-background-color: black; -fx-text-fill: black; -fx-border-color: blue;");
					l.setPrefSize(75, 75);;
					GridPane.setConstraints(l, b, a);
					GridPane.setHgrow(l, Priority.ALWAYS);
					GridPane.setVgrow(l, Priority.ALWAYS);
					gp.getChildren().add(l);
				} else if (mazeSolver.getMap()[a][b].getCoordinateValue() == 'Q') {
					Label l = new Label("Q"); l.setStyle("-fx-background-color: #25FFA2; -fx-text-fill: #25FFA2; -fx-border-color: blue;");
					l.setPrefSize(75, 75);
					GridPane.setConstraints(l, b, a);
					GridPane.setHgrow(l, Priority.ALWAYS);
					GridPane.setVgrow(l, Priority.ALWAYS);
					gp.getChildren().add(l);
				} else if (mazeSolver.getMap()[a][b].getCoordinateValue() == 'C') {
					Label l = new Label("C"); l.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: #D3D3D3; -fx-border-color: blue;");
					l.setPrefSize(75, 75);
					GridPane.setConstraints(l, b, a);
					GridPane.setHgrow(l, Priority.ALWAYS);
					GridPane.setVgrow(l, Priority.ALWAYS);
					gp.getChildren().add(l);
				} else if (mazeSolver.getMap()[a][b].getCoordinateValue() == 'F') {
					Label l = new Label("F"); l.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: #D3D3D3; -fx-border-color: blue;");
					l.setPrefSize(75, 75);
					GridPane.setConstraints(l, b, a);
					GridPane.setHgrow(l, Priority.ALWAYS);
					GridPane.setVgrow(l, Priority.ALWAYS);
					gp.getChildren().add(l);
				}
				
			}
			
		}
		
		scene.getStylesheets().clear();

	    ScrollPane scrollPane = new ScrollPane();
	    scrollPane.setFitToHeight(true);
	    scrollPane.setFitToWidth(true);
	    scrollPane.setContent(gp);
		scene.setRoot(scrollPane);
		
	}
	
	private void selectInputFileButtonClicked() {

		FileChooser fileChooser = new FileChooser();

		fileChooser.setTitle("Open Input File");

		File inputFile = fileChooser.showOpenDialog(null);

		if (inputFile != null) {

			mazeSolver = new MazeSolver(inputFile);
			Boolean b = mazeSolver.solve();

			if (b) {
				new Alert(AlertType.INFORMATION, "Solution Generated").showAndWait();
			} else {
				new Alert(AlertType.INFORMATION, "No Solution Found").showAndWait();
			}

		} else {
			
			new Alert(AlertType.INFORMATION, "File not found").showAndWait();
			
		}
	}

}
