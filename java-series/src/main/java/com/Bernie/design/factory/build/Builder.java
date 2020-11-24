package com.Bernie.design.factory.build;

import com.Bernie.design.factory.build.matter.ceiling.LevelOneCeiling;
import com.Bernie.design.factory.build.matter.ceiling.LevelTwoCeiling;
import com.Bernie.design.factory.build.matter.coat.DuluxCoat;
import com.Bernie.design.factory.build.matter.coat.LiBangCoat;
import com.Bernie.design.factory.build.matter.floor.ShengXiangFloor;
import com.Bernie.design.factory.build.matter.tile.MarcoPloloTtle;

/**
 * @Author Bernie
 * @Date 2020/11/24/024 22:50
 */
public class Builder {
    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area,DecorationGrade.LIGHT_LUXURY_PASTORAL.grade)
                .appendCeiling(new LevelTwoCeiling())
                .appendCoat(new DuluxCoat())
                .appendFloor(new ShengXiangFloor());
    }

    public IMenu levelTwo(Double area) {
        return new DecorationPackageMenu(area,DecorationGrade.LUXURY_EUROPEAN_STYLE.grade)
                .appendCeiling(new LevelOneCeiling())
                .appendCoat(new LiBangCoat())
                .appendFloor(new ShengXiangFloor())
                .appendTile(new MarcoPloloTtle());
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        System.out.println(builder.levelOne(100.34D).getDetail());
    }
}
