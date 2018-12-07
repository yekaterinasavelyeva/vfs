package files.myown;

import java.util.Iterator;

/**
 * Created by user
 * on 02.12.2018
 */

public interface VFS {

    boolean isExist(String path);

    boolean isDirectory(String path);

    String getAbsolutePath(String file);

    byte [] getBytes(String file);

    String getUTF8Text(String file);

    Iterator <String> getIterator(String startDir);

    String getRoot();

    boolean delete (String file);

    void removeDirectoryRecursively(String path);


}
