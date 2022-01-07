package com.concurrent.iterableMod.group;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.concurrent.iterableMod.lang.Collection;
import com.concurrent.iterableMod.lang.Iterator;

public class GroupStructure implements Collection<Employee, Link> {
	
	private String groupId;//组织id
	
	private String groupName;//组织名称
	
	private Map<String,Employee> employeeMap = new ConcurrentHashMap<String,Employee>();//雇员列表
	
	private Map<String,List<Link>> linkMap = new ConcurrentHashMap<String,List<Link>>();//组织建构关系
	
	private Map<String,String> invertedMap = new ConcurrentHashMap<String,String>();//反向关系链
	
	public GroupStructure(String groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}



	@Override
	public boolean add(Employee e) {
	
		return null!=employeeMap.put(e.getuId(),e);
	}

	@Override
	public boolean remove(Employee e) {
		
		return null != employeeMap.remove(e.getuId());
	}

	@Override
	public boolean addLink(String key, Link l) {
		
		invertedMap.put(l.getToId(),l.getFromId());
		
		if(linkMap.containsKey(key)) {
			
			return linkMap.get(key).add(l);
			
		}else {
			
			List<Link> links = new LinkedList<Link>();
			
			links.add(l);
			
			linkMap.put(key,links);
			
			return true;
			
		}
		
	}

	@Override
	public boolean removeLink(String key) {
		
		return null != linkMap.remove(key);
	}



	@Override
	public Iterator<Employee> iterator() {
		
		return new Iterator<Employee>() {
			
			HashMap<String,Integer> keyMap = new HashMap<String,Integer>();
			
			int totalIdx = 0;
			private String fromId = groupId;
			
			private String toId = groupId;
			
			public boolean hasNext() {
				
				return totalIdx<employeeMap.size();
			}
			
			public Employee next() {
				
				List<Link> links = linkMap.get(toId);
				
				int cursorIdx = getCursorIdx(toId);
				//同级节点扫描
				if(null==links) {
					cursorIdx = getCursorIdx(fromId);
					links = linkMap.get(fromId);
				}
				
				//上级节点扫描
				while(cursorIdx > links.size()-1) {
					
					fromId = invertedMap.get(fromId);
					
					cursorIdx = getCursorIdx(fromId);
					
					links = linkMap.get(fromId);
					
				}
				
				//获取节点
				Link link = links.get(cursorIdx);
				
				toId = link.getToId();
				
				fromId = link.getFromId();
				
				totalIdx++;
				
				return employeeMap.get(link.getToId());
				
			}
			
			public int getCursorIdx(String key) {
				
				int idx = 0;
				if(keyMap.containsKey(key)) {
					
					idx = keyMap.get(key);

					keyMap.put(key, ++idx);
				}else {
					
					keyMap.put(key, idx);
				}
				
				return idx;
				
			}
			
		};
	}
	
	
}
