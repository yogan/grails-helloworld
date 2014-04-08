package helloworld;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Taskboard {
	public List<String> columnNames() 
	{
		List<String> result = new LinkedList<String>(); 
		for (Map.Entry<Integer, String> entry : myColumns.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}
	
	public Map<Integer,String> myColumns = new HashMap<Integer,String>();
	public Map<Integer,List<Task>> myTasksPerColumn = new HashMap<Integer,List<Task>>();
	public String myName = "";
}