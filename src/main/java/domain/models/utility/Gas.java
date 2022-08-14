package domain.models.utility;

import domain.env.EnvironmentUtilities;

import java.math.BigDecimal;

public class Gas extends Utility{

    public Gas(String nameUtility, BigDecimal payForUtility, EnvironmentUtilities environmentUtilities) {
        super(nameUtility, payForUtility, environmentUtilities);
    }
}
