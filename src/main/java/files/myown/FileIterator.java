package files.myown;

import org.apache.commons.vfs2.VFS;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by user
 * on 02.12.2018
 */

public class FileIterator implements Iterator<String> {

    private Queue <File> files = new LinkedList<File>();

    public FileIterator(VFSImpl vfs, String path) {
     files.add(new File(vfs.getRoot() + path));
    }

    public void remove() {
        File file = files.peek();
        if(file.isDirectory()){
            for(File subFile : file.listFiles()){
                subFile.delete();
            }
        }
        files.poll().delete();
    }
    //public void forEachRemaining(Consumer<? super String> action) {}


    public boolean hasNext() {
        return !files.isEmpty();
    }

    public String next() {
        File file = files.peek();
        if(file.isDirectory()){
            for(File subFile : file.listFiles()){
                files.add(subFile);
            }
        }
        return files.poll().getAbsolutePath();
    }
}
