package com.zipcodewilmington.phonebook;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.List;
import java.util.TreeMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {


    @Test
    public void add() {
        //given
        PhoneBook phoneBook = new PhoneBook();

        String name = "joe";
        String phoneNumber = "1234567890";
        //when
        phoneBook.add(name, phoneNumber);
        //then
        Assert.assertTrue(phoneBook.lookup(name).contains(phoneNumber));
    }
    @Test
    public void add2() {
        //given
        PhoneBook phoneBook = new PhoneBook();

        String name = "joe";
        String phoneNumber = "1234567890";
        String phoneNumber2 = "0987654321";
        //when
        phoneBook.add(name, phoneNumber);
        phoneBook.add(name, phoneNumber2);
        //then
        Assert.assertTrue(phoneBook.lookup(name).contains(phoneNumber));
    }

    @Test
    public void remove() {
        //given
        PhoneBook phoneBook = new PhoneBook();
        TreeMap<String, List<String>> map = phoneBook.getMap();
        String name = "joe";
        //when
        phoneBook.add("joe", "1234567890");
        phoneBook.remove(name);
        //then
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void lookup() {
        //given
        PhoneBook phoneBook = new PhoneBook();
        String name = "joe";
        String phoneNumber = "1234567890";
        //when
        phoneBook.add(name, phoneNumber);
        String expected = "[" + phoneNumber +"]";
        String actual = phoneBook.lookup(name);
        //then
        Assert.assertEquals(expected, actual);;
    }

    @Test
    public void reverseLookup() {
        //given
        PhoneBook phoneBook = new PhoneBook();
        String name = "joe";
        String phoneNumber = "1234567890";
        //when
        phoneBook.add(name, phoneNumber);
        //then
        String expected = name;
        String actual = phoneBook.reverseLookup(phoneNumber);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void display() {
        //given
        PhoneBook phoneBook = new PhoneBook();
        String name = "joe";
        String phoneNumber = "1234567890";
        //when
        phoneBook.add(name, phoneNumber);
        String expected = "joe : [1234567890]";

        Assert.assertEquals(phoneBook.display(), expected);

    }
}
