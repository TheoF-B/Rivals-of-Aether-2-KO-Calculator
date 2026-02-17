package Theo.rivals2;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class Calculator {
  
  private static Scanner scan = new Scanner(System.in);
  
  private static int getInt(String message) {
    System.out.println(message);
    int integer = -1;
    while (integer < 0) {
      try {
        integer = scan.nextInt();
      } catch (Exception e) {
        scan.next();
      }
      if (integer < 0) {
        System.out.println("Please enter a valid positive integer.");
      } 
    }
    return integer;
  }
  
  private static double getDouble(String message) {
    System.out.println(message);
    double num = -1;
    while (num < 0) {
      try {
        num = scan.nextDouble();
      } catch (Exception e) {
        scan.next();
      }
      if (num < 0) {
        System.out.println("Please enter a valid positive number.");
      } 
    }
    return num;
  }
  
  private static double calculateHeight(Character character, int angle, 
      double baseKB, double kbGrowth, int percent) {
    double velocity = 3 * (baseKB + kbGrowth * 0.12 * (double) percent * 200 / (character.getWeight() + 100));
    double sinAngle = Math.sin(Math.toRadians((double) angle));
    double verticalVelocity = velocity * sinAngle;
    double personalVelocity = 0;
    double kbAcceleration = (0.54 * sinAngle);
    double personalAccel = character.getHitstunGrav(); 
    double maxFallSpeed = character.getMaxFallSpeed();
    double heightGain = 0;
    
    do { 
      if (personalVelocity < maxFallSpeed) {
        personalVelocity += personalAccel;
      } 
      if (personalVelocity > maxFallSpeed) {
        personalVelocity = maxFallSpeed;
      }
      verticalVelocity -= kbAcceleration;
      heightGain = heightGain + verticalVelocity - personalVelocity;
      
    } while (verticalVelocity - personalVelocity > 0);
    
    return heightGain;
  }
  
  private static int calculateVerticalDeathPercent(Character character, int angle, 
      double baseKB, double kbGrowth, double stageHeight) {
    
    for (int i = 30; i < 999; i++) {
      if (calculateHeight(character, angle, baseKB, kbGrowth, i) > stageHeight) {
        return i;
      }
    }
    return 0;
  }
  
  public static void main(String[] args) {
    
    boolean allStages;
    
    while (true) {
      try {
        System.out.println("All stages? y/n");
        String trial = scan.next().toLowerCase();
        if (trial.equals("y")) {
          allStages = true;
          break;
        } else if (trial.equals("n")) {
          allStages = false;
          break;
        }
      } catch (Exception e) {
        ;
      }
      System.out.println("Please enter y or n");
    }
    if (allStages) {
      int angle = getInt("Enter an angle: ");
      double baseKB = getDouble("Enter base knockback: ");
      double kbGrowth = getDouble("Enter knockback growth: ");
      int damage = getInt("Enter damage: ");
      
      for (Stage stage : Stage.values()) {
        for (int i = 0; i < stage.getPlatDistances().length; i++) {
          System.out.println(stage.name() + " Platform " + i + "\n");
          for (Character character : Character.values()) {
            System.out.println(character.name() + " - " 
                + (calculateVerticalDeathPercent(character, angle, baseKB, kbGrowth, stage.getPlatDistances()[i]) - damage));
          }
          System.out.println();
        }
      }
    }
    else {
      int angle = getInt("Enter an angle: ");
      double baseKB = getDouble("Enter base knockback: ");
      double kbGrowth = getDouble("Enter knockback growth: ");
      int damage = getInt("Enter damage: ");
      double stageHeight = getDouble("Enter stage height: ");
    
      for (Character character : Character.values()) {
        System.out.println(character.name() + " - " 
            + (calculateVerticalDeathPercent(character, angle, baseKB, kbGrowth, stageHeight) - damage));
      }
    }
  }
}
