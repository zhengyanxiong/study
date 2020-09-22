package com.example.function;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @Author Bernie
 * @Date 2020/3/18 21:13
 */
public class TestFunction {
    @Test
    public void Test(){
        Function<Integer,Integer> test = i-> i + 1;
        System.out.println("test.apply(5):"+test.apply(5));

        Function<Integer,Integer> a = i-> i +1;
        Function<Integer,Integer> b = i-> i * i;

        System.out.println("a.apply(b.apply(5)):"+a.apply(b.apply(5)));
        System.out.println("a.compose(b).apply(5):"+a.compose(b).apply(5));
        System.out.println("a.andThen(b).apply(5):"+a.andThen(b).apply(5));
    }

    @Test
    public void TestMap(){
        Map<String,Function<String,String>> actionMapper = new HashMap<>();
        actionMapper.put("A",params-> {return doAction1(params);});
        actionMapper.put("B",params-> {return doAction2(params);});
        actionMapper.put("C",params-> {return doAction3(params);});
        System.out.println(actionMapper.get("A").apply("A"));
    }

    private String doAction1(String param){
        return ("doAction1 "+param);
    }
    private String doAction2(String param){
        return ("doAction2 "+param);
    }
    private String doAction3(String param){
        return ("doAction3 "+param);
    }
}
