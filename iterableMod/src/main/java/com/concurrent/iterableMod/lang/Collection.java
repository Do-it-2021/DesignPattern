package com.concurrent.iterableMod.lang;

public interface Collection<E, L> extends Interable<E> {

	boolean add(E e);
	
	boolean remove(E e);
	
	boolean addLink(String key,L l);
	
	boolean removeLink(String key);

}
