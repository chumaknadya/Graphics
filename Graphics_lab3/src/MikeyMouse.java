

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MikeyMouse extends Application {

    public MikeyMouse() {
    }

    private static double X (double originalX){
        return originalX + 300;
    }
    private static double Y (double originalY){
        return originalY + 250;
    }

    public static void main(String args[]) {
        launch(args);
    }


    public void mickeyAnimate(Group root) {
        // Animation
        int cycleCount = 2;
        int time = 2000;

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(time), root);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        scaleTransition.setAutoReverse(true);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(time), root);
        rotateTransition.setByAngle(360f);
        rotateTransition.setCycleCount(cycleCount);
        rotateTransition.setAutoReverse(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(time), root);
        translateTransition.setFromX(250);
        translateTransition.setToX(10);
        translateTransition.setCycleCount(cycleCount+1);
        translateTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                translateTransition,
                rotateTransition,
                scaleTransition
        );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();
    }


    public Group drawMickey(Group mainRoot) {

        Group root = new Group();

        Path pants = new Path();
        MoveTo pantsStart = new MoveTo(X(17.0f), Y(15.0f));
        QuadCurveTo pantsPoint1 = new QuadCurveTo(X(20.0f),Y(30.0f), X(23.0f),Y(37.0f));
        QuadCurveTo pantsPoint2 = new QuadCurveTo(X(20.0f),Y(38.0f), X(15.0f),Y(42.0f));
        QuadCurveTo pantsPoint3 = new QuadCurveTo(X(17.0f),Y(58.0f), X(32.0f),Y(56.0f));
        QuadCurveTo pantsPoint4 = new QuadCurveTo(X(43.0f),Y(48.0f), X(43.0f),Y(48.0f));
        QuadCurveTo pantsPoint5 = new QuadCurveTo(X(49.0f),Y(49.0f), X(52.0f),Y(56.0f));
        QuadCurveTo pantsPoint6 = new QuadCurveTo(X(69.0f),Y(56.0f), X(75.0f),Y(44.0f));
        QuadCurveTo pantsPoint7 = new QuadCurveTo(X(73.0f),Y(42.0f), X(70.0f),Y(40.0f));
        QuadCurveTo pantsPoint8 = new QuadCurveTo(X(66.0f),Y(23.0f), X(53.5f),Y(16.0f));
        pants.getElements().add(pantsStart);
        pants.getElements().add(pantsPoint1);
        pants.getElements().add(pantsPoint2);
        pants.getElements().add(pantsPoint3);
        pants.getElements().add(pantsPoint4);
        pants.getElements().add(pantsPoint5);
        pants.getElements().add(pantsPoint6);
        pants.getElements().add(pantsPoint7);
        pants.getElements().add(pantsPoint8);
        pants.setFill(Color.rgb(254,32,34));
        root.getChildren().add(pants);

        Path leftHand = new Path();
        MoveTo leftHandPoint1 = new MoveTo(X(4.0f), Y(-14.0f));
        QuadCurveTo leftHandPoint2 = new QuadCurveTo(X(-20.0f),Y(-35.0f), X(-20.0f),Y(-35.0f));
        QuadCurveTo leftHandPoint3 = new QuadCurveTo(X(-22.0f),Y(-30.0f), X(-24.0f),Y(-28.0f));
        QuadCurveTo leftHandPoint4 = new QuadCurveTo(X(20.0f),Y(9.0f), X(20.0f),Y(9.0f));
        QuadCurveTo leftHandPoint5 = new QuadCurveTo(X(20.0f),Y(0.0f), X(20.0f),Y(0.0f));
        leftHand.getElements().add(leftHandPoint1);
        leftHand.getElements().add(leftHandPoint2);
        leftHand.getElements().add(leftHandPoint3);
        leftHand.getElements().add(leftHandPoint4);
        leftHand.getElements().add(leftHandPoint5);
        leftHand.setFill(Color.BLACK);
        root.getChildren().add(leftHand);

        Path rightHand = new Path();
        MoveTo rightHandPoint1 = new MoveTo(X(51.0f), Y(-5.0f));
        QuadCurveTo rightHandPoint2 = new QuadCurveTo(X(62.0f),Y(-6.0f), X(87.0f),Y(0.0f));
        QuadCurveTo rightHandPoint3 = new QuadCurveTo(X(84.5f),Y(2.0f), X(84.0f),Y(6.0f));
        QuadCurveTo rightHandPoint4 = new QuadCurveTo(X(47.0f),Y(4.0f), X(46.0f),Y(2.0f));
        rightHand.getElements().add(rightHandPoint1);
        rightHand.getElements().add(rightHandPoint2);
        rightHand.getElements().add(rightHandPoint3);
        rightHand.getElements().add(rightHandPoint4);
        rightHand.setFill(Color.BLACK);
        root.getChildren().add(rightHand);

        Path leftPalm = new Path();
        MoveTo leftPalmPoint1 = new MoveTo(X(-20.0f), Y(-35.0f));
        QuadCurveTo leftPalmPoint2 = new QuadCurveTo(X(-21.0f),Y(-39.0f), X(-24.0f),Y(-37.0f));
        QuadCurveTo leftPalmPoint3 = new QuadCurveTo(X(-25.0f),Y(-45.0f), X(-34.0f),Y(-50.0f));
        QuadCurveTo leftPalmPoint4 = new QuadCurveTo(X(-23.0f),Y(-70.0f), X(-32.0f),Y(-70.0f));
        QuadCurveTo leftPalmPoint5 = new QuadCurveTo(X(-41.7f),Y(-69.0f), X(-40.0f),Y(-52.0f));
        QuadCurveTo leftPalmPoint6 = new QuadCurveTo(X(-52.0f),Y(-62.0f), X(-63.0f),Y(-66.0f));
        QuadCurveTo leftPalmPoint7 = new QuadCurveTo(X(-74.0f),Y(-62.0f), X(-46.0f),Y(-46.0f));
        QuadCurveTo leftPalmPoint8 = new QuadCurveTo(X(-76.0f),Y(-41.0f), X(-72.0f),Y(-40.0f));
        QuadCurveTo leftPalmPoint9 = new QuadCurveTo(X(-69.0f),Y(-30.0f), X(-52.0f),Y(-36.0f));
        QuadCurveTo leftPalmPoint10 = new QuadCurveTo(X(-48.0f),Y(-37.0f), X(-52.0f),Y(-30.0f));
        QuadCurveTo leftPalmPoint11 = new QuadCurveTo(X(-68.0f),Y(-18.0f), X(-63.0f),Y(-18.0f));
        QuadCurveTo leftPalmPoint12 = new QuadCurveTo(X(-54.0f),Y(-14.0f), X(-44.0f),Y(-28.0f));
        QuadCurveTo leftPalmPoint13 = new QuadCurveTo(X(-35.0f),Y(-20.0f), X(-24.0f),Y(-28.0f));
        leftPalm.getElements().add(leftPalmPoint1);
        leftPalm.getElements().add(leftPalmPoint2);
        leftPalm.getElements().add(leftPalmPoint3);
        leftPalm.getElements().add(leftPalmPoint4);
        leftPalm.getElements().add(leftPalmPoint5);
        leftPalm.getElements().add(leftPalmPoint6);
        leftPalm.getElements().add(leftPalmPoint7);
        leftPalm.getElements().add(leftPalmPoint8);
        leftPalm.getElements().add(leftPalmPoint9);
        leftPalm.getElements().add(leftPalmPoint10);
        leftPalm.getElements().add(leftPalmPoint11);
        leftPalm.getElements().add(leftPalmPoint12);
        leftPalm.getElements().add(leftPalmPoint13);
        root.getChildren().add(leftPalm);

        Path rightPalm = new Path();
        MoveTo rightPalmPoint1 = new MoveTo(X(87.0f), Y(0.0f));
        QuadCurveTo rightPalmPoint2 = new QuadCurveTo(X(96.0f),Y(-4.0f), X(104.0f),Y(0.0f));
        QuadCurveTo rightPalmPoint3 = new QuadCurveTo(X(106.0f),Y(5.0f), X(122.0f),Y(-6.0f));
        QuadCurveTo rightPalmPoint4 = new QuadCurveTo(X(139.0f),Y(-7.0f), X(116.0f),Y(6.0f));
        QuadCurveTo rightPalmPoint5 = new QuadCurveTo(X(116.0f),Y(10.0f), X(138.0f),Y(8.0f));
        QuadCurveTo rightPalmPoint6 = new QuadCurveTo(X(150.0f),Y(14.0f), X(128.0f),Y(16.0f));
        QuadCurveTo rightPalmPoint7 = new QuadCurveTo(X(116.0f),Y(16.0f), X(123.0f),Y(21.0f));
        QuadCurveTo rightPalmPoint8 = new QuadCurveTo(X(139.0f),Y(29.0f), X(135.0f),Y(29.0f));
        QuadCurveTo rightPalmPoint9 = new QuadCurveTo(X(132.0f),Y(34.0f), X(107.0f),Y(23.0f));
        QuadCurveTo rightPalmPoint10 = new QuadCurveTo(X(102.0f),Y(24.0f), X(102.0f),Y(33.0f));
        QuadCurveTo rightPalmPoint11 = new QuadCurveTo(X(103.0f),Y(42.0f), X(101.0f),Y(42.0f));
        QuadCurveTo rightPalmPoint12 = new QuadCurveTo(X(94.0f),Y(39.0f), X(93.0f),Y(21.0f));
        QuadCurveTo rightPalmPoint13 = new QuadCurveTo(X(86.0f),Y(15.0f), X(87.0f),Y(9.0f));
        QuadCurveTo rightPalmPoint14 = new QuadCurveTo(X(86.5f),Y(14.0f), X(84.5f),Y(7.0f));
        rightPalm.getElements().add(rightPalmPoint1);
        rightPalm.getElements().add(rightPalmPoint2);
        rightPalm.getElements().add(rightPalmPoint3);
        rightPalm.getElements().add(rightPalmPoint4);
        rightPalm.getElements().add(rightPalmPoint5);
        rightPalm.getElements().add(rightPalmPoint6);
        rightPalm.getElements().add(rightPalmPoint7);
        rightPalm.getElements().add(rightPalmPoint8);
        rightPalm.getElements().add(rightPalmPoint9);
        rightPalm.getElements().add(rightPalmPoint10);
        rightPalm.getElements().add(rightPalmPoint11);
        rightPalm.getElements().add(rightPalmPoint12);
        rightPalm.getElements().add(rightPalmPoint13);
        rightPalm.getElements().add(rightPalmPoint14);
        root.getChildren().add(rightPalm);

        Ellipse leftBoot = new Ellipse(X(5), Y(72), 26, 12);
        leftBoot.setRotate(165);
        leftBoot.setStroke(Color.BLACK);
        leftBoot.setStrokeWidth(1);
        leftBoot.setFill(Color.YELLOW);
        root.getChildren().add(leftBoot);

        Ellipse rightBoot = new Ellipse(X(70), Y(78), 26, 13);
        rightBoot.setRotate(25);
        rightBoot.setStroke(Color.BLACK);
        rightBoot.setStrokeWidth(1);
        rightBoot.setFill(Color.YELLOW);
        root.getChildren().add(rightBoot);

        Path leftBootElem = new Path();
        MoveTo elemBootElemStart = new MoveTo(X(-1.0f), Y(70.0f));
        QuadCurveTo leftBootElemPoint1 = new QuadCurveTo(X(5.0f),Y(69.0f), X(10.0f),Y(75.0f));
        MoveTo leftBootElemPoint2 = new MoveTo(X(10.0f), Y(62.0f));
        QuadCurveTo leftBootElemPoint3 = new QuadCurveTo(X(0.0f),Y(67.0f), X(14.0f),Y(69.0f));
        MoveTo leftBootElemPoint4 = new MoveTo(X(20.0f), Y(62.0f));
        QuadCurveTo leftBootElemPoint5 = new QuadCurveTo(X(29.0f),Y(64.0f), X(23.0f),Y(67.0f));
        leftBootElem.getElements().add(elemBootElemStart);
        leftBootElem.getElements().add(leftBootElemPoint1);
        leftBootElem.getElements().add(leftBootElemPoint2);
        leftBootElem.getElements().add(leftBootElemPoint3);
        leftBootElem.getElements().add(leftBootElemPoint4);
        leftBootElem.getElements().add(leftBootElemPoint5);
        root.getChildren().add(leftBootElem);

        Path rightBootElem = new Path();
        MoveTo elemRightBootElemStart = new MoveTo(X(65.0f), Y(78.0f));
        QuadCurveTo rightBootElemPoint1 = new QuadCurveTo(X(65.0f),Y(75.0f), X(79.0f),Y(76.0f));
        MoveTo rightBootElemPoint2 = new MoveTo(X(60.0f), Y(63.0f));
        QuadCurveTo rightBootElemPoint3 = new QuadCurveTo(X(54.0f),Y(62.0f), X(57.0f),Y(70.0f));
        MoveTo rightBootElemPoint4 = new MoveTo(X(70.0f), Y(70.0f));
        QuadCurveTo rightBootElemPoint5 = new QuadCurveTo(X(73.0f),Y(72.0f), X(68.0f),Y(74.0f));
        rightBootElem.getElements().add(elemRightBootElemStart);
        rightBootElem.getElements().add(rightBootElemPoint1);
        rightBootElem.getElements().add(rightBootElemPoint2);
        rightBootElem.getElements().add(rightBootElemPoint3);
        rightBootElem.getElements().add(rightBootElemPoint4);
        rightBootElem.getElements().add(rightBootElemPoint5);
        root.getChildren().add(rightBootElem);

        Path leftLeg = new Path();
        MoveTo leftLegStart = new MoveTo(X(14.0f), Y(43.0f));
        QuadCurveTo leftLegPoint1 = new QuadCurveTo(X(7.0f),Y(48.0f), X(5.0f),Y(52.0f));
        QuadCurveTo leftLegPoint2 = new QuadCurveTo(X(6.0f),Y(56.0f), X(10.0f),Y(65.0f));
        QuadCurveTo leftLegPoint3 = new QuadCurveTo(X(14.0f),Y(68.0f), X(21.0f),Y(65.0f));
        QuadCurveTo leftLegPoint4 = new QuadCurveTo(X(17.0f),Y(55.0f), X(16.0f),Y(55.0f));
        QuadCurveTo leftLegPoint5 = new QuadCurveTo(X(20.0f),Y(53.0f), X(20.0f),Y(53.0f));
        leftLeg.getElements().add(leftLegStart);
        leftLeg.getElements().add(leftLegPoint1);
        leftLeg.getElements().add(leftLegPoint2);
        leftLeg.getElements().add(leftLegPoint3);
        leftLeg.getElements().add(leftLegPoint4);
        leftLeg.getElements().add(leftLegPoint5);
        leftLeg.setFill(Color.BLACK);
        root.getChildren().add(leftLeg);

        Path rightLeg = new Path();
        MoveTo rightLegStart = new MoveTo(X(69.0f), Y(51.0f));
        QuadCurveTo rightLegPoint1 = new QuadCurveTo(X(75.0f),Y(59.0f), X(74.0f),Y(60.0f));
        QuadCurveTo rightLegPoint2 = new QuadCurveTo(X(68.0f),Y(71.0f), X(68.0f),Y(71.0f));
        QuadCurveTo rightLegPoint3 = new QuadCurveTo(X(61.0f),Y(72.0f), X(60.0f),Y(66.0f));
        QuadCurveTo rightLegPoint4 = new QuadCurveTo(X(63.0f),Y(61.0f), X(63.0f),Y(61.0f));
        QuadCurveTo rightLegPoint5 = new QuadCurveTo(X(58.0f),Y(55.0f), X(58.0f),Y(55.0f));
        rightLeg.getElements().add(rightLegStart);
        rightLeg.getElements().add(rightLegPoint1);
        rightLeg.getElements().add(rightLegPoint2);
        rightLeg.getElements().add(rightLegPoint3);
        rightLeg.getElements().add(rightLegPoint4);
        rightLeg.getElements().add(rightLegPoint5);
        rightLeg.setFill(Color.BLACK);
        root.getChildren().add(rightLeg);

        Path bodyTop = new Path();
        MoveTo bodyStart = new MoveTo(X(15.0f), Y(-6.0f));
        QuadCurveTo bodyEnd = new QuadCurveTo(X(13.0f),Y(5.0f), X(17.0f),Y(15.0f));
        QuadCurveTo bodyEnd2 = new QuadCurveTo(X(35.0f),Y(30.0f), X(53.0f),Y(15.0f));
        QuadCurveTo bodyEnd3 = new QuadCurveTo(X(45.0f),Y(5.0f), X(50.0f),Y(-5.0f));
        bodyTop.getElements().add(bodyStart);
        bodyTop.getElements().add(bodyEnd);
        bodyTop.getElements().add(bodyEnd2);
        bodyTop.getElements().add(bodyEnd3);
        bodyTop.setFill(Color.BLACK);
        root.getChildren().add(bodyTop);

        Ellipse button1 = new Ellipse(X(47), Y(33), 7, 4);
        button1.setRotate(68);
        button1.setStroke(Color.BLACK);
        button1.setStrokeWidth(1);
        button1.setFill(Color.WHITE);
        root.getChildren().add(button1);

        Ellipse button2 = new Ellipse(X(33), Y(36), 6.7, 4);
        button2.setRotate(68);
        button2.setStroke(Color.BLACK);
        button2.setStrokeWidth(1);
        button2.setFill(Color.WHITE);
        root.getChildren().add(button2);

        Arc headPart = new Arc(X(32), Y(-35), 34, 36, -20, 220);
        headPart.setFill(Color.BLACK);
        root.getChildren().add(headPart);

        Ellipse leftEar = new Ellipse(X(1), Y(-72), 16, 17);
        leftEar.setRotate(12);
        leftEar.setFill(Color.BLACK);
        root.getChildren().add(leftEar);

        Ellipse rightEar = new Ellipse(X(65), Y(-71), 17.2, 15);
        rightEar.setRotate(30);
        rightEar.setFill(Color.BLACK);
        root.getChildren().add(rightEar);

        Ellipse rightSide = new Ellipse(X(40), Y(-44), 14, 23);
        rightSide.setFill(Color.rgb(255,211,208));
        root.getChildren().add(rightSide);

        Ellipse leftSide = new Ellipse(X(23), Y(-44), 14, 23);
        leftSide.setFill(Color.rgb(255,211,208));
        root.getChildren().add(leftSide);

        Ellipse chin = new Ellipse(X(32), Y(-9), 14, 12);
        chin.setFill(Color.rgb(255,211,208));
        root.getChildren().add(chin);

        Rectangle rec = new Rectangle(X(-0.1), Y(-28), 64, 16);
        rec.setArcHeight(50);
        rec.setArcWidth(25);
        rec.setFill(Color.rgb(255,211,208));
        root.getChildren().add(rec);

        Arc rec2 = new Arc(X(32), Y(-22), 30, 20, 200, 140);
        rec2.setFill(Color.rgb(255,211,208));
        root.getChildren().add(rec2);

        Ellipse rightEye = new Ellipse(X(37), Y(-40), 4, 14);
        rightEye.setStroke(Color.BLACK);
        rightEye.setStrokeWidth(1);
        rightEye.setFill(Color.WHITE);
        root.getChildren().add(rightEye);

        Ellipse smallRightEye = new Ellipse(X(36), Y(-33), 3, 7);
        smallRightEye.setFill(Color.BLACK);
        root.getChildren().add(smallRightEye);

        Ellipse leftEye = new Ellipse(X(26), Y(-40), 4, 14);
        leftEye.setRotate(-2);
        leftEye.setStroke(Color.BLACK);
        leftEye.setStrokeWidth(1);
        leftEye.setFill(Color.WHITE);
        root.getChildren().add(leftEye);

        Ellipse smallLeftEye = new Ellipse(X(27), Y(-33), 3, 7);
        smallLeftEye.setFill(Color.BLACK);
        root.getChildren().add(smallLeftEye);

        Ellipse nose = new Ellipse(X(32), Y(-18), 9, 4);
        nose.setFill(Color.BLACK);
        root.getChildren().add(nose);

        Path mouse = new Path();
        MoveTo mouseStart = new MoveTo(X(22.0f), Y(-6.5f));
        QuadCurveTo mouseEnd = new QuadCurveTo(X(31.0f),Y(8.0f), X(43.0f),Y(-6.8f));
        mouse.getElements().add(mouseStart);
        mouse.getElements().add(mouseEnd);
        mouse.setFill(Color.BLACK);
        mouse.setStrokeWidth(1.0f);
        root.getChildren().add(mouse);

        Ellipse tongue = new Ellipse(X(32), Y(-2), 6, 2);
        tongue.setFill(Color.rgb(136,91,92));
        root.getChildren().add(tongue);

        Path smile = new Path();
        MoveTo start = new MoveTo(X(10.0f), Y(-16.0f));
        QuadCurveTo end = new QuadCurveTo(X(31.0f),Y(5.0f), X(55.0f),Y(-16.0f));
        MoveTo point1 = new MoveTo(X(9.0f), Y(-20.0f));
        QuadCurveTo point2 = new QuadCurveTo(X(9.0f),Y(-16.0f), X(7.0f),Y(-15.0f));
        MoveTo point3 = new MoveTo(X(55.0f), Y(-20.0f));
        QuadCurveTo point4 = new QuadCurveTo(X(55.0f),Y(-16.0f), X(58.0f),Y(-15.0f));
        smile.getElements().add(start);
        smile.getElements().add(end);
        smile.getElements().add(point1);
        smile.getElements().add(point2);
        smile.getElements().add(point3);
        smile.getElements().add(point4);
        root.getChildren().add(smile);

        mainRoot.getChildren().add(root);

        return root;

    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 600);
        drawMickey(root);
        mickeyAnimate(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Graphics#3");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
