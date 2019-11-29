package zzy2day;

import java.io.File;

public class TestFile {
	public static void main(String[] args) {
//		File f = new File("f:/华为软挑");
//		System.out.println(f.exists());
//		for(File file :f.listFiles()) {
//			System.out.println(file.getName());
//		}
		TestFile testFile = new TestFile();
		testFile.disPlayTreeDir("C:\\Users\\zzy\\Pictures");
		
		
	}
	
	void disPlayTreeDir(String dir) {
		File f = new File(dir);
		tree(f,0);
	}
	void tree(File f,int level) {
		if (! f.exists())
			return;
		if(level > 1) {
			System.out.printf("|");
			for(int i =0;i<level-1;i++) {
				System.out.printf("\t");
			}
		}
			
		
		if(level > 0)
			System.out.printf("|-------");		
		System.out.printf(f.getName());
		if(f.isDirectory()) {
			System.out.printf("\\\n");
			for (File file:f.listFiles()) {
				tree(file,level+1);
			}
		}
		else {
			System.out.printf("\n");
		}
	}
}
