package ru.malik.rss.Calculation.mvc.events.listners;

import java.util.EventListener;

public interface MyEventListener<T> extends EventListener{
	public void before(T event);
	public void after(T event);
	public void call(T event);
}
