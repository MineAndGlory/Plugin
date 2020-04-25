package fr.fingarde.mineandglory.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FloatUtils
{
    public  static float scaleDown(float value)
    {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.DOWN);
        return bd.floatValue();
    }
}
