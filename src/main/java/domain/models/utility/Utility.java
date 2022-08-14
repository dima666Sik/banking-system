package domain.models.utility;

import domain.env.EnvironmentUtilities;

import java.math.BigDecimal;

public abstract class Utility {
     private String nameUtility;
     private BigDecimal payForUtility;
     private EnvironmentUtilities environmentUtilities;

     public Utility(String nameUtility, BigDecimal payForUtility, EnvironmentUtilities environmentUtilities) {
          this.nameUtility = nameUtility;
          this.payForUtility = payForUtility;
          this.environmentUtilities = environmentUtilities;
     }

     public EnvironmentUtilities getEnvironmentUtilities() {
          return environmentUtilities;
     }

     public String getNameUtility() {
          return nameUtility;
     }

     public void setNameUtility(String nameUtility) {
          this.nameUtility = nameUtility;
     }

     public BigDecimal getPayForUtility() {
          return payForUtility;
     }

     public void setPayForUtility(BigDecimal payForUtility) {
          this.payForUtility = payForUtility;
     }
}
