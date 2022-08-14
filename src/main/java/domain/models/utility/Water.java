package domain.models.utility;

import domain.env.EnvironmentUtilities;

import java.math.BigDecimal;

public class Water extends Utility{

    public Water(String nameUtility, BigDecimal payForUtility, EnvironmentUtilities environmentUtilities) {
        super(nameUtility, payForUtility, environmentUtilities);
    }
}
