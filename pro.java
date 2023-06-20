import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class Histogram extends Application {
    @Override
    public void start(Stage primaryStage) {
VBox root = new VBox();
int[] histogramArray = new int[11];
        for (inti = 0; i<= 10; i++) {
histogramArray[i] = 0;
        }
        try {
FileChooserfileChooser = new FileChooser();
fileChooser.setTitle("Select the file with the midterm scores.");
            File file = fileChooser.showOpenDialog(primaryStage);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
int score = Integer.parseInt(line);
                if (score < 0 || score > 100
) {
throw new IllegalArgumentException("That score is out of range");
} else {
int range = score / 10;
histogramArray[range]++;
}
}
for (int range = 0; range <= 10; range++) {
String label;
switch (range) {
case 0:
label = "00-09";
break;
case 10:
label = " 100";
break;
default:
label = (10 * range) + "-" + (10 * range + 9);
break;
}
StringBuilder stars = new StringBuilder();
for (inti = 0; i<histogramArray[range]; i++) {
stars.append("*");
}
Label histogramRow = new Label(label + ": " + stars.toString());
root.getChildren().add(histogramRow);
}
} catch (FileNotFoundException e) {
e.printStackTrace();
}    Scene scene = new Scene(root,500,500);
primaryStage.setTitle("Histogram");
primaryStage.setScene(scene);
primaryStage.show();
}
Public static void main(String[] args) {
   launch(args);
}
}
