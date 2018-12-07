package files.myown;

/**
 * Created by user
 * on 02.12.2018
 */

public class Main {
    public static void main(String [] args){
        VFS vfs = new VFSImpl("");
        ((VFSImpl) vfs).printDirectory("src");

        System.out.println("Is src directory a directory: " + vfs.isDirectory("."));
    }
}
