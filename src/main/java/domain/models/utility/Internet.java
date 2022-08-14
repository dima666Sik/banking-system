package domain.models.utility;

import domain.env.EnvironmentUtilities;

import java.math.BigDecimal;

public class Internet extends Utility{

    public Internet(String nameUtility, BigDecimal payForUtility, EnvironmentUtilities environmentUtilities) {
        super(nameUtility, payForUtility, environmentUtilities);
    }
}
