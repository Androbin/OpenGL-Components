package de.androbin.opengl.cam;

import static de.androbin.lwjgl.util.Vector3fUtil.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.vector.*;

public interface Cam3D extends Cam {
  @ Override
  default void applyCamera() {
    final Vector3f rotation = getRotation();
    final Vector3f translation = getTranslation();
    
    glRotatef( rotation.z, 0f, 0f, 1f );
    glRotatef( rotation.x, 1f, 0f, 0f );
    glRotatef( rotation.y, 0f, 1f, 0f );
    glTranslatef( -translation.x, -translation.y, -translation.z );
  }
  
  Vector3f getRotation();
  
  Vector3f getTranslation();
  
  default Vector3f getViewVector( final Vector3f dst ) {
    return getDirVector( dst, getRotation() );
  }
}