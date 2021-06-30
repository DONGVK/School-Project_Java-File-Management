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

public class Test{
	public static void main(String[]args) {
		String s = "unfi.lol";
		System.out.println(Arrays.toString(s.split(".")));
	}
}