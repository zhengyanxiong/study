package com.Bernie.Array;

import com.Bernie.dao.MenuEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Bernie
 * @Date 2020/4/21 21:32
 */
public class TreeStructure {
    private List<MenuEntity> entityList = new ArrayList<>();

    public List<MenuEntity> getEntityList() {
        return entityList;
    }

    public void init(){
        for (int i=0;i<5;i++){
            MenuEntity menuEntity = new MenuEntity();
            List<MenuEntity> list = new ArrayList<>();
            menuEntity.setId(i);
            menuEntity.setName("a"+i);
            menuEntity.setParentID(0);
            menuEntity.setParentName("");
            for (int j=0;j<3;j++){
                MenuEntity c = new MenuEntity();
                c.setId(j+5*i + 1);
                c.setName("b"+j+5*i + 1);
                c.setParentID(menuEntity.getId());
                c.setParentName(menuEntity.getName());
                list.add(c);
                menuEntity.setChildren(list);
            }
            entityList.add(menuEntity);
        }
    }

    public List<MenuEntity> result = new ArrayList<>();
    public List<MenuEntity> prentResult = new ArrayList<>();
    public void findTree(List<MenuEntity> entityList, String value) {
        for (MenuEntity entity : entityList) {
            if (entity.getName().contains(value)) {
                if (entity.getChildren()!=null) {
                    result.add(entity);
                } else {
                    result.add(findPrent(this.entityList, entity.getParentID()));
                }

            } else {
                if (entity.getChildren() != null) {
                    findTree(entity.getChildren(), value);
                }
            }
        }
    }

    public MenuEntity findPrent(List<MenuEntity> menuEntities, int value) {
        for (MenuEntity menu : menuEntities) {
            if (menu.getId() == value) {
               return menu;
            }
        }
        return null;
    }

    public static void main(String[] args){
        TreeStructure structure = new TreeStructure();
        structure.init();
        System.out.println("列表："+ structure.getEntityList());
        System.out.println("---------------");
        structure.findTree(structure.getEntityList(), "b001");
        System.out.println("结果："+structure.result.toString());
    }
}
