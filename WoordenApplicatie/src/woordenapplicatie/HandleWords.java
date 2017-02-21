/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Yannick
 */
public class HandleWords {
    
    
    
    public HandleWords() {
        
    }
    
    public Queue<String> haalWoordenOp(String input) {
        long startTime = System.currentTimeMillis();
        String[] in = input.split("[,.\\s\\n]");
        Queue<String> woorden = new LinkedList<>();
        for (String word : in) {
            if (!word.isEmpty()) {
                woorden.add(word.toLowerCase().replaceAll("é", "e"));
            }
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Dat duurde: " + (finishTime - startTime) + " ms");
        return woorden;
    }
    
    public String[] haalWoordenOpC(String input) {
        return input.split("[,.\\s\\n]");
    }
    
    public String sorteerWoorden(String input) {
        Set<String> words = new TreeSet<>(Collections.reverseOrder());
        for ( String s : haalWoordenOp(input)) {
             words.add(s);
        }
        return words.toString();
    }
    
    public String telWoorden(String input) {
        Set<String> singleWord = new HashSet<>();
        for (String s : haalWoordenOp(input)) {
            singleWord.add(s);
        }
        return String.format("Aantal uit input: " + haalWoordenOp(input).size()
                + "\nAantal uniek: " + singleWord.size());
    }
    
    public String frequentieVanWoorden(String input) {
        TreeMap<String, Integer> ongesorteerdeMap = new TreeMap();
        for ( String s : haalWoordenOp(input)) {
            Integer count = ongesorteerdeMap.get(s);
            if (count == null) {
                ongesorteerdeMap.put(s,1);
            }
            else {
                ongesorteerdeMap.put(s,count + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> gesorteerdeLijst = new LinkedList<>(ongesorteerdeMap.entrySet());
        
        Collections.sort(gesorteerdeLijst, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> compOne,
                               Map.Entry<String, Integer> compTwo)
            {
                return compOne.getValue().compareTo(compTwo.getValue());
            }
        });
        return gesorteerdeLijst.toString();
    }
    
    
    public String cooncerdantie(String input)
    {
        //Haal regels op
        String[] rules = input.split("\n");
        //Hashmap, zodat ik 
        Map<String, TreeSet<Integer>> map = new HashMap<>();
        int ruleNumber = 0;
        for (String w : rules) {
            ruleNumber++;
            String[] strings = haalWoordenOpC(w);
            for(String s : strings){
                if(map.containsKey(s)){
                    TreeSet<Integer> temp = map.get(s);
                    temp.add(ruleNumber);
                    map.put(s, temp);
                }
                else{
                    TreeSet<Integer> temp = new TreeSet();
                    temp.add(ruleNumber);
                    map.put(s, temp);
                }
            }
        }
        //geen digit of spatie meer,dan een new line, zodat ales op een nieuwe regel kom.
     return map.toString().replaceAll(", (?!\\d)", "\n");
    }
    
    
}
