package com.designpatterns.factory;

public class DisplayFactory {
	public static Display getDisplayObject(String aDisplayType){
		// returnObject variable is kept to avoid multiple return statements in code below
		Display returnObject = null;
		if("File".equalsIgnoreCase(aDisplayType)){
			returnObject = new FileReaderWriter();
		}
		else if("StdIO".equalsIgnoreCase(aDisplayType)){
			returnObject = new StdIOReaderWriter();
		}
		else{
			// TODO : defined new type of exception
			// throw new class type of exception
		}
		return returnObject;
	}
}
