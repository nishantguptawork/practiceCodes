package com.designpatterns.abstractfactory;

public class FileReaderWriterAbstractFactory implements IDisplayAbstractFactory{

	private Display singletonDisplayObject;
	
	public FileReaderWriterAbstractFactory() {
		// TODO Auto-generated constructor stub
		singletonDisplayObject = null;
	}
	
	@Override
	public Display createDisplay() {
		// TODO Auto-generated method stub
		if(singletonDisplayObject == null){
			singletonDisplayObject = new FileReaderWriter();
		}
		return singletonDisplayObject;
	}

}
