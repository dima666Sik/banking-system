package domain.models.utility;

import domain.env.EnvironmentUtilities;

import java.math.BigDecimal;

public class TV extends Utility{

    public TV(String nameUtility, BigDecimal payForUtility, EnvironmentUtilities environmentUtilities) {
        super(nameUtility, payForUtility, environmentUtilities);
    }
}
