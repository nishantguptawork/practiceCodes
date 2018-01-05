package com.designpatterns.abstractfactory;
import java.util.Scanner;

public class StdIOReaderWriter extends Display{
	
	private Scanner in;

	public StdIOReaderWriter(){
		in = new Scanner(System.in);
	}
	
	@Override
	public String read() {
		// TODO Auto-generated method stub
		return in.next();
	}

	@Override
	public int write(byte[] message) {
		// TODO Auto-generated method stub
		return 0;
	}

}
