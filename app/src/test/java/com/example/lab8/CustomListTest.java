package com.example.lab8;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return CustomList
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size + 1
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * get the size of the list
     * check if the size is 0
     */
    @Test
    public void getCountTest(){
        list = MockCityList();
        assertEquals(list.getCount(),0);

        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertEquals(list.getCount(),1);
    }

    /**
     * get the size of the list
     * add a city to the list, then delete it
     * check if the size of the list is equal to the initial size of the list - 1
     */
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City city1 = new City("Edmonton", "AB");
        list.addCity(city1);
        int listSize = list.getCount();
        list.deleteCity(city1);
        assertEquals(list.getCount(),listSize - 1);
    }

    /**
     * attempt to delete a city that does not exist in the list
     * ensure that an IllegalArgumentException is thrown
     */
    @Test
    public void deleteCityException(){
        list = MockCityList();

        City city1 = new City("Edmonton", "AB");
        
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(city1);
        });

    }

    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city1 = new City("Edmonton", "AB");
        list.addCity(city1);
        assertEquals(list.hasCity(city1),true);
    }

}
