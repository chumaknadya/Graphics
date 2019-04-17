import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.swing.Timer;
import javax.vecmath.*;

// Vector3f - float, Vector3d - double
public class Castle implements ActionListener {
    private float upperEyeLimit = 5.0f; // 5.0
    private float lowerEyeLimit = 1.0f; // 1.0
    private float farthestEyeLimit = 6.0f; // 6.0
    private float nearestEyeLimit = 3.0f; // 3.0

    private TransformGroup treeTransformGroup;
    private TransformGroup viewingTransformGroup;
    private Transform3D treeTransform3D = new Transform3D();
    private Transform3D viewingTransform = new Transform3D();
    private float angle = 0;
    private float eyeHeight;
    private float eyeDistance;
    private boolean descend = true;
    private boolean approaching = true;

    public static void main(String[] args) {
        new Castle();
    }

    private Castle() {
        Timer timer = new Timer(50, this);
        // створюємо простір, в якому будемо працювати
        SimpleUniverse universe = new SimpleUniverse();

        viewingTransformGroup = universe.getViewingPlatform().getViewPlatformTransform();
        // додаємо створену групу у простір
        universe.addBranchGraph(createSceneGraph());

        eyeHeight = upperEyeLimit;
        eyeDistance = farthestEyeLimit;
        timer.start();
    }

    private BranchGroup createSceneGraph() {
        // створюємо групу, в яку додаємо об'єкти для відображення
        BranchGroup objRoot = new BranchGroup();


        treeTransformGroup = new TransformGroup();
        treeTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        buildCastleSkeleton();
        objRoot.addChild(treeTransformGroup);

//        Колір фону, при бажанні можна задати
//        Background background = new Background(new Color3f(1.0f, 1.0f, 1.0f)); // white color
//        BoundingSphere sphere = new BoundingSphere(new Point3d(0,0,0), 100000);
//        background.setApplicationBounds(sphere);
//        objRoot.addChild(background);


        //налаштовуємо освітлення
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);  // вказуємо сферу, внутрішній простір якої буде освітлено
        Color3f light1Color = new Color3f(1f, 0f, 0.9f);  // параметри конструктору- це відповідно червона, зелена та синя компоненти кольору
        Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f); //встановлюємо вектор, що задає напрям освітлення
        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction); //створюмо власне об'єкт освітлення
        light1.setInfluencingBounds(bounds); //вказуємо, яка частина сцени має бути освітлена
        objRoot.addChild(light1);


        // встановлюємо навколишнє освітлення
        Color3f ambientColor = new Color3f(1.0f, 1.0f, 1.0f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        objRoot.addChild(ambientLightNode);
        return objRoot;
    }

    private void buildCastleSkeleton() {
        Box body1 = CastleBody.getBody(0.125f, 1.0f);
        Transform3D body1T = new Transform3D();
        body1T.setTranslation(new Vector3f());
        TransformGroup body1TG = new TransformGroup();
        body1TG.setTransform(body1T);
        body1TG.addChild(body1);
        treeTransformGroup.addChild(body1TG);

        setSideTowers();
        setSideRoof();


        setOneLevelOfTowers(0.8f, 0.25f);

        Box body2 = CastleBody.getBody(0.125f, 0.6f);
        Transform3D body2T = new Transform3D();
        body2T.setTranslation(new Vector3f(.0f, .0f, 0.25f));
        TransformGroup body2TG = new TransformGroup();
        body2TG.setTransform(body2T);
        body2TG.addChild(body2);
        treeTransformGroup.addChild(body2TG);


        setWall();
        setCylinderTowers();
    }

    public void setWall() {
        Box body3 = CastleBody.getWall(0.425f, 0.65f);
        // створюємо 3д трансформацію
        Transform3D body3T = new Transform3D();
        // створюємо вектор, на яких буде здійснене перенесення і задаємо трансформації властивість перенесення на вказаний вектор
        body3T.setTranslation(new Vector3f(.8f, .0f, 0.4f));
        TransformGroup body3TG = new TransformGroup();
        // вказуємо створену трансформацію заданій групі трансформації
        body3TG.setTransform(body3T);
        body3TG.addChild(body3);
        treeTransformGroup.addChild(body3TG);

        Box body4 = CastleBody.getWall(0.425f, 0.65f);
        Transform3D body4T = new Transform3D();
        body4T.setTranslation(new Vector3f(-0.8f, -0f, 0.4f));
        TransformGroup body4TG = new TransformGroup();
        body4TG.setTransform(body4T);
        body4TG.addChild(body4);
        treeTransformGroup.addChild(body4TG);

        Box body5 = CastleBody.geOthertWall(0.425f, 0.65f);
        Transform3D body5T = new Transform3D();
        body5T.setTranslation(new Vector3f(0f, -0.8f, 0.4f));
        TransformGroup body5TG = new TransformGroup();
        body5TG.setTransform(body5T);
        body5TG.addChild(body5);
        treeTransformGroup.addChild(body5TG);

        Box body6 = CastleBody.geOthertWall(0.425f, 0.65f);
        Transform3D body6T = new Transform3D();
        body6T.setTranslation(new Vector3f(0f, 0.8f, 0.4f));
        TransformGroup body6TG = new TransformGroup();
        body6TG.setTransform(body6T);
        body6TG.addChild(body6);
        treeTransformGroup.addChild(body6TG);
    }
    public void setSideRoof(){
        TransformGroup cylinderTower1 = CastleBody.getRoof(1f, 0.80f, 0.80f);
        treeTransformGroup.addChild(cylinderTower1);

        TransformGroup cylinderTower2 = CastleBody.getRoof(1f, -0.80f, -0.80f);
        treeTransformGroup.addChild(cylinderTower2);

        TransformGroup cylinderTower3 = CastleBody.getRoof(1f, 0.80f, -0.80f);
        treeTransformGroup.addChild(cylinderTower3);

        TransformGroup cylinderTower4 = CastleBody.getRoof(1f, -0.80f, 0.80f);
        treeTransformGroup.addChild(cylinderTower4);


    }
    private void setSideTowers() {
        TransformGroup cylinderTower1 = CastleBody.getCylinder(1f, 0.80f, 0.80f);
        treeTransformGroup.addChild(cylinderTower1);

        TransformGroup cylinderTower2 = CastleBody.getCylinder(1f, -0.80f, -0.80f);
        treeTransformGroup.addChild(cylinderTower2);

        TransformGroup cylinderTower3 = CastleBody.getCylinder(1f, 0.80f, -0.80f);
        treeTransformGroup.addChild(cylinderTower3);

        TransformGroup cylinderTower4 = CastleBody.getCylinder(1f, -0.80f, 0.80f);
        treeTransformGroup.addChild(cylinderTower4);
    }


    private void setCylinderTowers(){
        float cylTowDistFromCentre = 0.34f;
        TransformGroup cylinder1 = CastleBody.getCylinder(1.5f, .0f, .0f);
        treeTransformGroup.addChild(cylinder1);

        TransformGroup tower1 = CastleBody.getRoof(1.5f, .0f, .0f);
        treeTransformGroup.addChild(tower1);

        TransformGroup cylinderTower2 = CastleBody.getCylinderTower(1.05f, -cylTowDistFromCentre, cylTowDistFromCentre);
        treeTransformGroup.addChild(cylinderTower2);
        TransformGroup cylinderTower3 = CastleBody.getCylinderTower(1.0f, cylTowDistFromCentre, cylTowDistFromCentre);
        treeTransformGroup.addChild(cylinderTower3);
        TransformGroup cylinderTower4 = CastleBody.getCylinderTower(1.0f, cylTowDistFromCentre, -cylTowDistFromCentre);
        treeTransformGroup.addChild(cylinderTower4);
        TransformGroup cylinderTower5 = CastleBody.getCylinderTower(1.0f, -cylTowDistFromCentre, -cylTowDistFromCentre);
        treeTransformGroup.addChild(cylinderTower5);
    }


    private void setOneLevelOfTowers(float distanceFromCentre, float height){
        Box tower1 = CastleBody.getTower();
        Transform3D tower1T = new Transform3D();
        tower1T.setTranslation(new Vector3f(distanceFromCentre, distanceFromCentre, height));
        TransformGroup tower1TG = new TransformGroup();
        tower1TG.setTransform(tower1T);
        tower1TG.addChild(tower1);
        treeTransformGroup.addChild(tower1TG);

        Box tower2 = CastleBody.getTower();
        Transform3D tower2T = new Transform3D();
        tower2T.setTranslation(new Vector3f(-distanceFromCentre, -distanceFromCentre, height));
        TransformGroup tower2TG = new TransformGroup();
        tower2TG.setTransform(tower2T);
        tower2TG.addChild(tower2);
        treeTransformGroup.addChild(tower2TG);

        Box tower3 = CastleBody.getTower();
        Transform3D tower3T = new Transform3D();
        tower3T.setTranslation(new Vector3f(distanceFromCentre, -distanceFromCentre, height));
        TransformGroup tower3TG = new TransformGroup();
        tower3TG.setTransform(tower3T);
        tower3TG.addChild(tower3);
        treeTransformGroup.addChild(tower3TG);

        Box tower4 = CastleBody.getTower();
        Transform3D tower4T = new Transform3D();
        tower4T.setTranslation(new Vector3f(-distanceFromCentre, distanceFromCentre, height));
        TransformGroup tower4TG = new TransformGroup();
        tower4TG.setTransform(tower4T);
        tower4TG.addChild(tower4);
        treeTransformGroup.addChild(tower4TG);
    }

    // ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        float delta = 0.03f;

        // rotation of the castle
        treeTransform3D.rotZ(angle);
        treeTransformGroup.setTransform(treeTransform3D);
        angle += delta;

        // change of the camera position up and down within defined limits
        if (eyeHeight > upperEyeLimit){
            descend = true;
        }else if(eyeHeight < lowerEyeLimit){
            descend = false;
        }
        if (descend){
            eyeHeight -= delta-0.02;
        }else{
            eyeHeight += delta;
        }

        // change camera distance to the scene
        if (eyeDistance > farthestEyeLimit){
            approaching = true;
        } else if(eyeDistance < nearestEyeLimit){
            approaching = false;
        }
        if (approaching){
            eyeDistance -= delta-0.02;
        } else{
            eyeDistance += delta;
        }

        Point3d eye = new Point3d(eyeDistance, eyeDistance, eyeHeight); // spectator's eye
        Point3d center = new Point3d(.0f, .0f ,0.5f); // sight target
        Vector3d up = new Vector3d(.0f, .0f, 1.0f);; // the camera frustum
        viewingTransform.lookAt(eye, center, up);
        viewingTransform.invert();
        viewingTransformGroup.setTransform(viewingTransform);
    }
}