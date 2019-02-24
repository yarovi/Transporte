package com.utilidad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Puerto {

//	String [] vectorpuerto = {"Puerto A", "Puerto XX","Puerto ABC"};
	ObjectMapper mapper = new ObjectMapper();
	ArrayNode arrayNode = mapper.createArrayNode();
	List<String> lstPuerto = new ArrayList<String>();
	
	public Puerto() {
		super();
		// TODO Auto-generated constructor stub
		
		lstPuerto.add("Puerto A");
		lstPuerto.add("Puerto XX");
		lstPuerto.add("Puerto ABC");

		

		Iterator ite = lstPuerto.iterator();
		while (ite.hasNext()) {
			ObjectNode objectNode = mapper.createObjectNode();
			String dato=ite.next().toString();
			objectNode.put("nombre", dato);
			arrayNode.add(objectNode);
			
		}
		//forma 2
//		lstPuerto.stream().forEach((p) -> {
//			ObjectNode objectNode = mapper.createObjectNode();
//			objectNode.put("nombre",p);
//			arrayNode.add(objectNode);
//		});
		
				
	}
	public String getListaPuerto(){
		//String jsonString =mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
		String jsonString2= arrayNode.toString();
		return jsonString2;
	}
}
