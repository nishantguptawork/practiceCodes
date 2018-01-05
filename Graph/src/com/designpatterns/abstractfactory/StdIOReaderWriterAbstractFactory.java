package com.designpatterns.abstractfactory;

public class StdIOReaderWriterAbstractFactory implements IDisplayAbstractFactory{

	private Display singletonStdIOObject;
	
	public StdIOReaderWriterAbstractFactory() {
		// TODO Auto-generated constructor stub
		singletonStdIOObject = null;
	}
	
	@Override
	public Display createDisplay() {
		// TODO Auto-generated method stub
		if(singletonStdIOObject == null){
			singletonStdIOObject = new StdIOReaderWriter();
		}
		return singletonStdIOObject;
	}

}
