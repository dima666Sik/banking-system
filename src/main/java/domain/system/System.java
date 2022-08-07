package domain.system;

import domain.iface.I_System;
import domain.models.User;

import java.math.BigDecimal;

public class System implements I_System {
    User user;

    public System(User user) {
        this.user = user;
    }


    @Override
    public void replenishOnTheCard(BigDecimal replenishAmount) {

    }

    @Override
    public void replenishOnTheCard(BigDecimal replenishAmount, long rechargeableCard) {

    }

    @Override
    public void withdrawingMoney(BigDecimal withdrawingAmount) {

    }

    @Override
    public void replenishPhone(BigDecimal replenishAmount) {

    }

    @Override
    public void replenishPhone(BigDecimal replenishAmount, long numberPhone) {

    }
}
