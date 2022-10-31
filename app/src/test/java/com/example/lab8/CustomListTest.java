package com.example.lab8;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    void testHasCity(){
        list = MockCityList();
        City city = new City("Toronto","Ontario");
        City city2 = new City("Calgary","Alberta");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(city2));


    }
    @Test

    void testdelete(){
        list = MockCityList();
        City city2 = new City("Calgary","Alberta");
        City city3 = new City("Vancouver","British Columbia");
        list.addCity(city3);
        assertThrows( IllegalArgumentException.class, ()->{
            list.delete(city2);
        });
        list.delete(city3);

    }
}
