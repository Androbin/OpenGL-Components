package de.androbin.opengl.cam;

import org.lwjgl.util.vector.*;

public abstract class AbstractCam3D implements Cam3D {
  public Vector3f pos;
  public Vector3f dir;
  
  public AbstractCam3D() {
    this( new Vector3f(), new Vector3f() );
  }
  
  public AbstractCam3D( final Vector3f pos, final Vector3f dir ) {
    this.pos = pos;
    this.dir = dir;
  }
  
  @ Override
  public Vector3f getRotation() {
    return dir;
  }
  
  @ Override
  public Vector3f getTranslation() {
    return pos;
  }
}