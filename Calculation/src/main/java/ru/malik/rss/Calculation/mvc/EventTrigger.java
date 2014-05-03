package ru.malik.rss.Calculation.mvc;

import java.util.EventListener;
// TODO: Хрен знает зачем создал этот интерфейс =(((
public interface EventTrigger<T extends EventListener> {
	public void addListener(T listener);
	public void removeListener(T listener);
}
