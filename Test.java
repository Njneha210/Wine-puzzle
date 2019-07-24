package com.app.emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Test {

	public static void main(String[] args) {
		Map<Integer, Integer> sellerMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> buyerMap = null;
		List<Map<Integer, Integer>> buyerList = new ArrayList<Map<Integer,Integer>>();
		for(int i = 1; i<=100;i++){
			sellerMap.put(i, 0);
		}

		for(int i = 1; i<=5;i++){
			buyerMap = new HashMap<Integer, Integer>();
			for(int j = 1; j<=10;j++){
				buyerMap.put(j, 0);
			}
			buyerList.add(buyerMap);
		}
		int count=0;
		//////////////////
		Iterator<Map<Integer, Integer>> itr = buyerList.iterator();
		while (itr.hasNext()) {
			Map<Integer, Integer> buyer = itr.next();
			Set<Integer> buyerKeys = buyer.keySet();
			Iterator<Integer> buyerItr = buyerKeys.iterator();
			while (buyerItr.hasNext()) {
				Integer key =  buyerItr.next();
				if(sellerMap.containsKey(key) && sellerMap.get(key) == 0){
					count=0;
					for(Integer i : buyer.keySet()){
						if(buyer.get(i)==1){
							count++;
						}
					}
					if(count <3){
						sellerMap.put(key, 1);
						buyer.put(key, 1);
						System.out.println("Wine delivered successfully");
					}else{
						buyer.put(key, 4);
						System.out.println("Can't sell more than 3");
					}
					
				}else{
					buyer.put(key, 3);
					System.out.println("Wine already sold, not exist in the stock");
				}
			}
		}
		
	}

}
