package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

import javax.swing.JFileChooser;

import db.DBConnection;

public class Test{
	public static void main(String[]args) {
		try {
			boolean b = DBConnection.existsFile("./stock_file/grapefruit.jpg");
			System.out.println(b);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}