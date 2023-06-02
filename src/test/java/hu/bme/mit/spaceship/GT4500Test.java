package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;

  @BeforeEach
  public void init(){
    this.ship = mock(GT4500.class);
    when(ship.fireTorpedo(FiringMode.SINGLE)).thenReturn(true);
    when(ship.fireTorpedo(FiringMode.ALL)).thenReturn(true);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(ship, times(1)).fireTorpedo(FiringMode.SINGLE);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    verify(ship, times(1)).fireTorpedo(FiringMode.ALL);
  }

  @Test
  public void fire_All_Ammo_Success(){
    int counter = 0;
    for(int i = 0; i < 10; i++){
      boolean result = ship.fireTorpedo(FiringMode.ALL);
      if(result){
        counter++;
      }
    }
    assertEquals(10, counter);
  }

}
