package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;
import java.util.Vector;


/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    public Spatial ob;
    
    public Spatial mer_tras;
    public Spatial ven_tras;
    public Spatial tie_tras;
    public Spatial mar_tras;
    public Spatial jup_tras;
    
    public Spatial mer_rot;
    public Spatial ven_rot;
    public Spatial tie_rot;
    public Spatial mar_rot;
    public Spatial jup_rot;

    public static void main(String[] args) {
        //poner imagen al inicio
        AppSettings settings= new AppSettings(true);
        settings.setTitle("Sistema solar");
        
        settings.setSettingsDialogImage("Interface/descarga.jpg");
        
        settings.setResolution(1000, 900);
        
        Main app = new Main();
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Node sol_node = new Node("sol_node");
        //nodos para traslación
        Node mercu_tras_nodo = new Node("mercu_tras_nodo");
        Node venus_tras_nodo = new Node("venus_tras_nodo");
        Node tierra_tras_nodo = new Node("tierra_tras_nodo");
        Node marte_tras_nodo = new Node("marte_tras_nodo");
        Node jupiter_tras_nodo = new Node("jupiter_tras_nodo");
        
        //nodos para la rotación
        Node mercu_nodo = new Node("mercu_nodo");
        Node venus_nodo = new Node("venus_nodo");
        Node tierra_nodo = new Node("tierra_nodo");
        Node marte_nodo = new Node("marte_nodo");
        Node jupiter_nodo = new Node("jupiter_nodo");
        
       
        
        
        Sphere sol = new Sphere(10,30,6); //para hacer el sol
        Geometry geomSol = new Geometry("Sol", sol); 
        
        Sphere mercurio = new Sphere(10,30,1); //para hacer mercurio
        Geometry geomMercu = new Geometry("Mercurrio", mercurio);
        
        Sphere venus = new Sphere(10,30,2);//para hacer venus
        Geometry geomVenus = new Geometry("Venus", venus);
        
        Sphere tierra = new Sphere(10,30,4); //para hacer la tierra
        Geometry geomTierra = new Geometry("Tierra", tierra); 
        
        Sphere marte = new Sphere(10,30,3); //para hacer marte
        Geometry geomMarte = new Geometry("Marte", marte);
        
        Sphere jupiter = new Sphere(10,30,5);//para hacer jupiter
        Geometry geomJupiter = new Geometry("Jupiter", jupiter);
        
        //rotar
        geomSol.rotate(FastMath.HALF_PI,0,0);
        geomMercu.rotate(FastMath.HALF_PI,0,0);
        geomVenus.rotate(FastMath.HALF_PI,0,0);
        geomTierra.rotate(FastMath.HALF_PI,0,0);
        geomMarte.rotate(FastMath.HALF_PI,0,0);
        geomJupiter.rotate(FastMath.HALF_PI,0,0);
        
        Material matSol = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //matSol.setColor("Color", ColorRGBA.Yellow);
        matSol.setTexture("ColorMap", assetManager.loadTexture("Textures/sol.jpg"));
        geomSol.setMaterial(matSol);
        
        Material matMercu = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //matMercu.setColor("Color", ColorRGBA.Brown);
        matMercu.setTexture("ColorMap", assetManager.loadTexture("Textures/mercurio.jpg"));
        geomMercu.setMaterial(matMercu);
        
        Material matVenus = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matVenus.setTexture("ColorMap", assetManager.loadTexture("Textures/venus.jpg"));
        geomVenus.setMaterial(matVenus);
        
        Material matTierra = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //matTierra.setColor("Color", ColorRGBA.Blue);
        matTierra.setTexture("ColorMap", assetManager.loadTexture("Textures/tierra.jpg"));
        geomTierra.setMaterial(matTierra);

        Material matMarte = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matMarte.setTexture("ColorMap", assetManager.loadTexture("Textures/marte.jpg"));
        geomMarte.setMaterial(matMarte);
        
        Material matJupiter = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matJupiter.setTexture("ColorMap", assetManager.loadTexture("Textures/jupiter.jpg"));
        geomJupiter.setMaterial(matJupiter);
        
        rootNode.attachChild(sol_node);
        sol_node.attachChild(geomSol);
        sol_node.attachChild(mercu_tras_nodo);
        sol_node.attachChild(venus_tras_nodo);
        sol_node.attachChild(tierra_tras_nodo);
        sol_node.attachChild(marte_tras_nodo);
        sol_node.attachChild(jupiter_tras_nodo);
        
        mercu_tras_nodo.attachChild(mercu_nodo);
        venus_tras_nodo.attachChild(venus_nodo);
        tierra_tras_nodo.attachChild(tierra_nodo);
        marte_tras_nodo.attachChild(marte_nodo);
        jupiter_tras_nodo.attachChild(jupiter_nodo);
        
        mercu_nodo.attachChild(geomMercu);
        venus_nodo.attachChild(geomVenus);
        tierra_nodo.attachChild(geomTierra);
        marte_nodo.attachChild(geomMarte);
        jupiter_nodo.attachChild(geomJupiter);
        
        mercu_nodo.move(8, 0, 0);
        venus_nodo.move(14, 0, 0);
        tierra_nodo.move(22, 0, 0);
        marte_nodo.move(28, 0, 0);
        jupiter_nodo.move(36, 0, 0);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        if(ob==null){
            System.out.println("No está asignado el objeto");
            ob= rootNode.getChild("sol_node");
        }
        else{
            ob.rotate(0,FastMath.DEG_TO_RAD*0.4f,0);
        }
        //traslación
        if(mer_tras==null){
            System.out.println("No está asignado el objeto");
            mer_tras= rootNode.getChild("mercu_tras_nodo");
        }
        else{
            mer_tras.rotate(0,FastMath.DEG_TO_RAD*0.1f,0);
        }
        if(ven_tras==null){
            System.out.println("No está asignado el objeto");
            ven_tras= rootNode.getChild("venus_tras_nodo");
        }
        else{
            ven_tras.rotate(0,FastMath.DEG_TO_RAD*0.2f,0);
        }
        if(tie_tras==null){
            System.out.println("No está asignado el objeto");
            tie_tras= rootNode.getChild("tierra_tras_nodo");
        }
        else{
            tie_tras.rotate(0,FastMath.DEG_TO_RAD*0.3f,0);
        }
        if(mar_tras==null){
            System.out.println("No está asignado el objeto");
            mar_tras= rootNode.getChild("marte_tras_nodo");
        }
        else{
            mar_tras.rotate(0,FastMath.DEG_TO_RAD*0.4f,0);
        }
        if(jup_tras==null){
            System.out.println("No está asignado el objeto");
            jup_tras= rootNode.getChild("jupiter_tras_nodo");
        }
        else{
            jup_tras.rotate(0,FastMath.DEG_TO_RAD*0.4f,0);
        }
        //rotación
        if(mer_rot==null){
            System.out.println("No está asignado el objeto");
            mer_rot= rootNode.getChild("mercu_nodo");
        }
        else{
            mer_rot.rotate(0,FastMath.DEG_TO_RAD*0.1f,0);
        }
        if(ven_rot==null){
            System.out.println("No está asignado el objeto");
            ven_rot= rootNode.getChild("venus_nodo");
        }
        else{
            ven_rot.rotate(0,FastMath.DEG_TO_RAD*0.2f,0);
        }
        if(tie_rot==null){
            System.out.println("No está asignado el objeto");
            tie_rot= rootNode.getChild("tierra_nodo");
        }
        else{
            tie_rot.rotate(0,FastMath.DEG_TO_RAD*0.3f,0);
        }
        if(mar_rot==null){
            System.out.println("No está asignado el objeto");
            mar_rot= rootNode.getChild("marte_nodo");
        }
        else{
            mar_rot.rotate(0,FastMath.DEG_TO_RAD*0.4f,0);
        }
        if(jup_rot==null){
            System.out.println("No está asignado el objeto");
            jup_rot= rootNode.getChild("jupiter_nodo");
        }
        else{
            jup_rot.rotate(0,FastMath.DEG_TO_RAD*0.5f,0);
        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
