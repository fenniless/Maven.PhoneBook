package com.zipcodewilmington.phonebook;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * Created by leon on 1/23/18.
 */

public class PhoneBook {

    TreeMap<String, List<String>> phoneBook;

    public PhoneBook() {

        this.phoneBook = new TreeMap<String, List<String>>();
    }

    public void add(String name, String phoneNumber) {

            if(!phoneBook.containsKey(name)){
                List<String> numbers = new ArrayList<String>();
                numbers.add(phoneNumber);
                phoneBook.put(name, numbers);
            } else {
                List<String> numbers = phoneBook.get(name);
                numbers.add(phoneNumber);
            }
        }


    public void remove(String name) {

        phoneBook.remove(name);
    }

    public String lookup(String name) {
        List<String> result = phoneBook.get(name);

        return result.toString();
    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        } return "this entry does not exist";
    }

    public String display() {

        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            String result = (key +" : " +value);
            return result;
        }return "no entries";
    }

    public TreeMap<String, List<String>> getMap(){

        return phoneBook;
    }
}
