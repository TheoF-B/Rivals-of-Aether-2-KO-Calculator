package Theo.rivals2;

public enum Stage {
  AETHERIAN(2180, 1930, 0), GODAI(2030, 1790, 0), HODOJO(2195, 1935, 1675), JULESVALE(2170, 1900, 1630),
  MERCHANT(2140, 1860, 1660), ARMADA(2080, 1780, 0), CAPITAL(2254, 2004, 1754), HARBOUR(1940, 1670, 1620),
  ROCKWALL(2130, 1870, 1610), TEMPEST(2260, 2030, 1880);
  
  private double[] platDistances;
  
  public double[] getPlatDistances() {
    return platDistances;
  }

  private Stage(double stageDistance, double plat1Distance, double plat2Distance) {
    if (plat2Distance == 0) {
      platDistances = new double[2];
    } else {
      platDistances = new double[3];
      platDistances[2] = plat2Distance;
    }
    platDistances[0] = stageDistance;
    platDistances[1] = plat1Distance;
  }
}
