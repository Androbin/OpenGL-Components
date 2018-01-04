package de.androbin.opengl.cam;

import static de.androbin.math.util.floats.FloatMathUtil.*;
import de.androbin.shell.input.*;
import org.lwjgl.util.vector.*;

public class BasicCam3D extends AbstractCam3D {
  public float sensitivity;
  
  public MouseTrack mouseTrack;
  
  public BasicCam3D( final float sensitivity ) {
    this.sensitivity = sensitivity;
    
    mouseTrack = new MouseTrack();
  }
  
  public BasicCam3D( final Vector3f pos, final Vector3f dir,
      final float sensitivity ) {
    super( pos, dir );
    
    this.sensitivity = sensitivity;
    
    mouseTrack = new MouseTrack();
  }
  
  public boolean rotate() {
    final int dx = mouseTrack.getDX();
    final int dy = mouseTrack.getDY();
    
    mouseTrack.reset();
    
    return rotate( dx, dy );
  }
  
  public boolean rotate( final int dx, final int dy ) {
    if ( ( dx | dy ) == 0 ) {
      return false;
    }
    
    rotate( dx * sensitivity, dy * sensitivity );
    return true;
  }
  
  public void rotate( final float mx, final float my ) {
    final Vector3f dir = getRotation();
    
    final float dx = dir.x - my;
    final float dy = dir.y + mx;
    
    dir.set( bound( -90f, dx, 90f ), dy % 360f );
  }
}