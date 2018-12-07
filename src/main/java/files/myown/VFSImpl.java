package files.myown;


import java.io.*;
import java.util.Iterator;

/**
 * Created by user
 * on 02.12.2018
 */

public class VFSImpl implements VFS{
    private String root;

    public VFSImpl(String root){

        this.root = root;
    }

    public String getRoot(){
        return root;
    }

    public Iterator <String> getIterator(String startDir){
        return new FileIterator(this, startDir);
    }

    public void printDirectory(String dir){
        Iterator <String> iterator = this.getIterator(dir);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void removeDirectoryRecursively(String path){
      Iterator <String> iterator = this.getIterator(path);
       while (iterator.hasNext()) {
           new File(iterator.next()).delete();

        }
        File dir = new File(path);
        File[] listFiles = dir.listFiles();
        for(File file : listFiles){
            System.out.println("Deleting "+file.getName());
            file.delete();
        }
        //now directory is empty, so we can delete it
        System.out.println("Deleting Directory. Success = "+dir.delete());
    }

    public boolean isDirectory(String path) {
        return new File(path).isDirectory();
    }

    public String getAbsolutePath(String file) {
        return new File(file).getAbsolutePath();
    }

    public byte[] getBytes(String file) {
        FileInputStream fin = null;
        byte[] buffer = null;

        try {
            fin = new FileInputStream(file);
            buffer = new byte[fin.available()];
            fin.read(buffer, 0, fin.available());
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return buffer;
    }

    public String getUTF8Text(String file) {
        String s = null;
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((s=br.readLine())!=null){
                builder.append(s);
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return builder.toString();
    }

    public boolean isExist(String path){
        return  new File(path).exists();
    }

    public boolean delete (String file) {
        if(new File(file).exists()){
        new File(file).delete();
        return true;
        }
        return false;
    }
   }


