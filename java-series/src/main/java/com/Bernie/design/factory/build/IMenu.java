package com.Bernie.design.factory.build;

import com.Bernie.design.factory.build.matter.Matter;

/**
 * @Author Bernie
 * @Date 2020/11/24/024 22:18
 */
public interface IMenu {
    IMenu appendCeiling(Matter matter); // 吊顶
    IMenu appendCoat(Matter matter);    // 涂料
    IMenu appendFloor(Matter matter);   // ࣈ地板
    IMenu appendTile(Matter matter);    // 地砖Ꮉ
    String getDetail();                 // 明细
}
