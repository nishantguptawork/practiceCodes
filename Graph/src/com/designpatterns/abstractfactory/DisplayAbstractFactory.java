package com.designpatterns.abstractfactory;

public class DisplayAbstractFactory {
	public static Display getDisplay(IDisplayAbstractFactory aFactoryObject){
		return aFactoryObject.createDisplay();
	}
}
