package test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pipe42.data.pojos.Application;
import com.pipe42.main.Initialize;

import java.util.HashMap;
import java.util.Map;

public class PojoToMapTest {

    public static void main(String[] args) {

        Application app = new Application("6whsgt", "Maya", "2020", "c:/", "-help", "Loads of stuff to test");

        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> map = mapper.convertValue(app, new TypeReference<Map<String, String>>() {});

        System.out.println("map = " + map);

    }

}
