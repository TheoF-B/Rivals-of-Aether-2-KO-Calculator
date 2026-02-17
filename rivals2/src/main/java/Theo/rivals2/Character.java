package Theo.rivals2;

public enum Character {
  ABSA(80, 0.95, 17), CLAIREN(87, 1.3, 28.35), ETALUS(106, 1.5, 27.6), FLEET (85, 1.2, 20.6), 
  FORSBURN(95, 1.35, 27), KRAGG(108, 1.55, 28.8), LOXODONT(110, 1.25, 21), MAYPUL(82, 1.55, 28.3), 
  OLYMPIA(78, 1.6, 33.07), ORCANE(100, 1.33, 25), RANNO(90, 1.32, 22.72), 
  WRASTOR(71, 1.1, 22.6), ZETTERBURN(95, 1.4, 28);
  
  public double getWeight() {
    return weight;
  }

  public double getHitstunGrav() {
    return hitstunGrav;
  }
  
  public double getMaxFallSpeed() {
    return maxFallSpeed;
  }

  private double weight;
  private double hitstunGrav;
  private double maxFallSpeed;
  
  private Character(double weight, double hitstunGrav, double maxFallSpeed) {
    this.weight = weight;
    this.hitstunGrav = hitstunGrav;
    this.maxFallSpeed = maxFallSpeed;
  }
}
