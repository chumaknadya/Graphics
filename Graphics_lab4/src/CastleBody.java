import java.awt.Container;
import javax.media.j3d.*; // for transform
import javax.vecmath.Color3f;
import java.awt.Color;
import com.sun.j3d.utils.geometry.*;
import javax.vecmath.*; // for Vector3f
import com.sun.j3d.utils.image.TextureLoader;

public class CastleBody {
    public static Box getBody(float height, float width) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(width, width, height, primflags, getBodyAppearence());
    }

    public static Box getWall(float height, float width) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(width/6, width, height,primflags, getWallAppearence());
    }

    public static Box geOthertWall(float height, float width) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(width, width/6, height,primflags, getCylTowersAppearence());
    }

    public static Box getTower() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(0.2f, 0.2f, 0.125f, primflags, getCubeTowersAppearence());
    }

    private static Cylinder getCentralTower(float cylinderHeight) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(0.12f, cylinderHeight, primflags, getCylTowersAppearence());
    }


    private static Cylinder getSideTower(float cylinderHeight) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(0.2f, cylinderHeight, primflags, getCylTowersAppearence());
    }

    private static Cone getCentralTowerRoof() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cone(0.125f, 0.3f, primflags, getRoofAppearence());
    }

    private static Cone getSideTowerRoof() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cone(0.225f, 0.35f, primflags, getRoofAppearence());
    }

    private static TransformGroup getCover(float x) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;

        TransformGroup tg = new TransformGroup();
        Transform3D transform = new Transform3D();
        transform.setTranslation(new Vector3f(x, .0f, 0.012f));
        tg.setTransform(transform);
        tg.addChild(new Box(0.008f, 0.008f, 0.008f, primflags, getRoofAppearence()));
        return tg;
    }

    private static TransformGroup getWall() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;

        TransformGroup tg = new TransformGroup();
        Transform3D transform = new Transform3D();
        transform.setTranslation(new Vector3f(.0f, .0f, .0f));
        tg.setTransform(transform);
        tg.addChild(new Box(0.2f, 0.008f, 0.008f, primflags, getRoofAppearence()));
        return tg;
    }

    public static TransformGroup getRoof(float height, float xPos, float yPos) {
        TransformGroup tg = new TransformGroup();

        Cone centralTowerRoof = CastleBody.getSideTowerRoof();
        Transform3D centralTowerRoofT = new Transform3D();
        centralTowerRoofT.setTranslation(new Vector3f(xPos, yPos, height+0.15f));
        centralTowerRoofT.setRotation(new AxisAngle4d(1, 0, 0, Math.toRadians(90)));
        TransformGroup centralTowerRoofTG = new TransformGroup();
        centralTowerRoofTG.setTransform(centralTowerRoofT);
        centralTowerRoofTG.addChild(centralTowerRoof);
        tg.addChild(centralTowerRoofTG);

        return tg;
    }

    public static TransformGroup getCylinder(float height, float xPos, float yPos) {
        TransformGroup tg = new TransformGroup();

        Cylinder centralTower = CastleBody.getSideTower(height);
        Transform3D centralTowerT = new Transform3D();
        centralTowerT.setTranslation(new Vector3f(xPos, yPos, height*0.5f));
        centralTowerT.setRotation(new AxisAngle4d(1, 0, 0, Math.toRadians(90)));
        TransformGroup centralTowerTG = new TransformGroup();
        centralTowerTG.setTransform(centralTowerT);
        centralTowerTG.addChild(centralTower);
        tg.addChild(centralTowerTG);
        return tg;
    }

    public static TransformGroup getCylinderTower(float height, float xPos, float yPos){
        TransformGroup tg = new TransformGroup();

        Cylinder centralTower = CastleBody.getCentralTower(height);
        Transform3D centralTowerT = new Transform3D();
        centralTowerT.setTranslation(new Vector3f(xPos, yPos, height*0.5f));
        centralTowerT.setRotation(new AxisAngle4d(1, 0, 0, Math.toRadians(90)));
        TransformGroup centralTowerTG = new TransformGroup();
        centralTowerTG.setTransform(centralTowerT);
        centralTowerTG.addChild(centralTower);
        tg.addChild(centralTowerTG);

        Cone centralTowerRoof = CastleBody.getCentralTowerRoof();
        Transform3D centralTowerRoofT = new Transform3D();
        centralTowerRoofT.setTranslation(new Vector3f(xPos, yPos, height+0.15f));
        centralTowerRoofT.setRotation(new AxisAngle4d(1, 0, 0, Math.toRadians(90)));
        TransformGroup centralTowerRoofTG = new TransformGroup();
        centralTowerRoofTG.setTransform(centralTowerRoofT);
        centralTowerRoofTG.addChild(centralTowerRoof);
        tg.addChild(centralTowerRoofTG);

        return tg;
    }

    private static Appearance getWallAppearence() {
        TextureLoader loader = new TextureLoader("/home/nadya/Graphics_lab4/src/texture4.jpg", "LUMINANCE", new Container());
        Texture texture = loader.getTexture();


        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));


        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(110, 110, 110));
        Color3f ambient = new Color3f(new Color(155, 155, 147));
        Color3f diffuse = new Color3f(new Color(155, 155, 147));
        Color3f specular = new Color3f(new Color(0,0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }


    private static Appearance getBodyAppearence() {
        TextureLoader loader = new TextureLoader("/home/nadya/Graphics_lab4/src/texture1.jpeg", "LUMINANCE", new Container());

        Texture texture = loader.getTexture();

        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));


        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(234, 234, 225));
        Color3f ambient = new Color3f(new Color(234, 234, 225));
        Color3f diffuse = new Color3f(new Color(214, 214, 194));
        Color3f specular = new Color3f(new Color(0,0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

    private static Appearance getRoofAppearence() {
        TextureLoader loader = new TextureLoader("/home/nadya/Graphics_lab4/src/roof.jpg", "LUMINANCE", new Container());

        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));


        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);
        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);



        Color3f emissive = new Color3f(new Color(64, 60, 60));
        Color3f ambient = new Color3f(new Color(40, 40, 37));
        Color3f diffuse = new Color3f(new Color(40, 40, 37));
        Color3f specular = new Color3f(new Color(0,0, 0));

        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

    private static Appearance getCubeTowersAppearence() {
        TextureLoader loader = new TextureLoader("/home/nadya/Graphics_lab4/src/texture1.jpeg", "LUMINANCE", new Container());

        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));


        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(48, 39, 39));
        Color3f ambient = new Color3f(new Color(48, 39, 39));
        Color3f diffuse = new Color3f(new Color(48, 39, 39));
        Color3f specular = new Color3f(new Color(0,0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

    private static Appearance getCylTowersAppearence() {

        TextureLoader loader = new TextureLoader("/home/nadya/Graphics_lab4/src/texture.jpg", "LUMINANCE", new Container());
        Texture texture = loader.getTexture();


        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));


        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(110, 110, 110));
        Color3f ambient = new Color3f(new Color(155, 155, 147));
        Color3f diffuse = new Color3f(new Color(155, 155, 147));
        Color3f specular = new Color3f(new Color(0,0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }
}
