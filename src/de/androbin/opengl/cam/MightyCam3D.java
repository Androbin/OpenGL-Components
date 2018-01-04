package de.androbin.opengl.cam;

import static de.androbin.lwjgl.util.Vector3fUtil.*;
import static org.lwjgl.input.Keyboard.*;
import de.androbin.shell.input.*;
import org.lwjgl.util.vector.*;

public class MightyCam3D extends BasicCam3D {
  public float speed;
  
  public KeyRecord keys;
  
  public MightyCam3D( final Vector3f pos, final Vector3f dir,
      final float sensitivity, final float speed ) {
    super( pos, dir, sensitivity );
    
    this.speed = speed;
    
    keys = new KeyRecord();
  }
  
  public boolean move( final float delta ) {
    final float distance = speed * delta;
    final Vector3f dv = new Vector3f();
    
    boolean update = false;
    
    /*  */ if ( keys.check( KEY_W ) ) {
      Vector3f.add( pos, (Vector3f) getDirVector( dv, dir.getY() ).scale( distance ), pos );
      update = true;
    } else if ( keys.check( KEY_S ) ) {
      Vector3f.add( pos, (Vector3f) getDirVector( dv, dir.getY() ).scale( -distance ), pos );
      update = true;
    }
    
    /*  */ if ( keys.check( KEY_A ) ) {
      Vector3f.add( pos, (Vector3f) getDirVector( dv, dir.getY() - 90f ).scale( distance ), pos );
      update = true;
    } else if ( keys.check( KEY_D ) ) {
      Vector3f.add( pos, (Vector3f) getDirVector( dv, dir.getY() + 90f ).scale( distance ), pos );
      update = true;
    }
    
    /*  */ if ( keys.check( KEY_R ) ) {
      add( pos, 1, distance );
      update = true;
    } else if ( keys.check( KEY_F ) ) {
      sub( pos, 1, distance );
      update = true;
    }
    
    return update;
  }
}