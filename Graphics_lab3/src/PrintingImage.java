
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.sun.corba.se.spi.transport.CorbaResponseWaitingRoom;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.css.Rect;

public class PrintingImage extends Application{
	private HeaderBitmapImage image; // приватне поле, яке зберігає об'єкт з інформацією про заголовок зображення
	private int numberOfPixels; // приватне поле для збереження кількості пікселів з чорним кольором

	public PrintingImage(){}

	public PrintingImage(HeaderBitmapImage image) // перевизначений стандартний конструктор
	{
		this.image = image;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ReadingImageFromFile.loadBitmapImage("/Users/nadine/IdeaProjects/Graphics_lab3/src/source/trajectory.bmp");
		this.image = ReadingImageFromFile.pr.image;
		int width = (int)this.image.getWidth();
		int height = (int)this.image.getHeight();
		
		int half = (int)image.getHalfOfWidth();
		Group root = new Group();
		Scene scene = new Scene (root, width, height);
		Circle cir;
		int let = 0;
		int let1 = 0;
		int let2 = 0;
		char[][] map = new char[width][height];

		// виконуємо зчитування даних про пікселі
		BufferedInputStream reader = new BufferedInputStream (new FileInputStream("/Users/nadine/IdeaProjects/Graphics_lab3/src/res/pixels.txt"));

		for(int i=0;i<height;i++)  // поки не кінець зображення по висоті
		{
			for(int j=0;j<half;j++)  // поки не кінець зображення по довжині
			{
				let = reader.read();  // зчитуємо один символ з файлу
				let1 = let;
				let2 = let;
				let1 = let1&(0xf0);  // старший байт - перший піксель
				let1 = let1>>4;  // зсув на 4 розряди
				let2 = let2&(0x0f);  // молодший байт - другий піксель
				if(j*2<width) // так як 1 символ кодує 2 пікселі нам необхідно пройти до середини ширини зображення
				{
					cir = new Circle ((j)*2,(height-1-i),1,Color.valueOf((returnPixelColor(let1)))); // за допомогою стандартного
					// примітива Коло радіусом в 1 піксель та кольором визначеним за допомогою методу returnPixelColor малюємо піксель
					root.getChildren().add(cir); //додаємо об'єкт в сцену
					if (returnPixelColor(let1) == "BLACK") // якщо колір пікселя чорний, то ставимо в масиві 1
					{
						map[j*2][height-1-i] = '1';
						numberOfPixels++; // збільшуємо кількість чорних пікселів
					}
					else
					{
						map[j*2][height-1-i] = '0';
					}
				}

				if(j*2+1<width) // для другого пікселя
				{
					cir = new Circle ((j)*2+1,(height-1-i),1,Color.valueOf((returnPixelColor(let2))));
					root.getChildren().add(cir);
					if (returnPixelColor(let2) == "BLACK")
					{
						map[j*2+1][height-1-i] = '1';
						numberOfPixels++;
					}
					else
					{
						map[j*2+1][height-1-i] = '0';
					}
				}
			}
		}
		primaryStage.setScene(scene); // ініціалізуємо сцену
		primaryStage.show(); // візуалізуємо сцену
		reader.close();


		int[][] black;
		black = new int[numberOfPixels][2];
		int lich = 0;
		// writing
		BufferedOutputStream writer = new BufferedOutputStream (new FileOutputStream("/Users/nadine/IdeaProjects/Graphics_lab3/src/res/map.txt")); // записуємо карту для руху по траекторії в файл
		for(int i=0;i<height;i++)  // поки не кінець зображення по висоті
		{
			for(int j=0;j<width;j++)  // поки не кінець зображення по довжині
			{
				if (map[j][i] == '1')
				{
					black[lich][0] = j;
					black[lich][1] = i;
					lich++;
				}
				writer.write(map[j][i]);
			}
			writer.write(10);
		}
		writer.close();
		System.out.println("number of black color pixels = " + numberOfPixels);

		Path path2 = new Path();
		for (int l = 0; l < numberOfPixels - 1; l++) {
			path2.getElements().addAll(new MoveTo(black[l][0],black[l][1]),
					                   new LineTo(black[l+1][0],black[l+1][1]) );
		}

        MikeyMouse mikeyMouse = new MikeyMouse();
        Group mickey = mikeyMouse.drawMickey(root);


        //Animation
		int cycleCount = 2;
		int time = 3000;

		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(5000));
		pathTransition.setPath(path2);
		pathTransition.setNode(mickey);

		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(time), mickey);
		scaleTransition.setToX(2);
		scaleTransition.setToY(2);
		scaleTransition.setAutoReverse(true);

		ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(time), mickey);
		scaleTransition2.setToX(0.5);
		scaleTransition2.setToY(0.5);
		scaleTransition2.setCycleCount(cycleCount);
		scaleTransition2.setAutoReverse(true);

		RotateTransition rotateTransition = new RotateTransition(Duration.millis(time), mickey);
		rotateTransition.setByAngle(360f);
		rotateTransition.setCycleCount(cycleCount);
		rotateTransition.setAutoReverse(true);


		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(
				pathTransition,
				rotateTransition,
				scaleTransition,
				scaleTransition2
		);
		parallelTransition.setCycleCount(Timeline.INDEFINITE);
		parallelTransition.play();



	}

	// далі необхідно зробити рух об'єкту по заданій траеторії
	private String returnPixelColor (int color) // метод для співставлення кольорів 16-бітного зображення
	{
		String col = "BLACK";
		switch(color)
		{
			case 0: return "BLACK";
			case 1: return "LIGHTCORAL";
			case 2: return "GREEN";
			case 3: return "BROWN";
			case 4: return "BLUE";
			case 5: return "MAGENTA";
			case 6: return "CYAN";
			case 7: return "LIGHTGRAY";
			case 8: return "DARKGRAY";
			case 9: return "RED";
			case 10:return "LIGHTGREEN";
			case 11:return "YELLOW";
			case 12:return "LIGHTBLUE";
			case 13:return "LIGHTPINK";
			case 14:return "LIGHTCYAN";
			case 15:return "WHITE";
		}
		return col;
	}

	public static void main (String args[])
	{
		launch(args);
	}
}
