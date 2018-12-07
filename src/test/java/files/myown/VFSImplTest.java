package files.myown;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by user
 * on 02.12.2018
 */

class VFSImplTest {

    private VFS vfs = new VFSImpl("");

    @BeforeAll
    private static void init(){
        File file = new File("src/main/resources/remove3.txt");
        File fileDir1 = new File("src/test/resources/deletion");
        File fileDir2 = new File("src/test/resources/deletion/again");
        File file1 = new File("src/test/resources/deletion/delete.txt");
        File file2 = new File("src/test/resources/deletion/again/again.txt");
        try {
            fileDir1.mkdir();
            fileDir2.mkdir();
            file.createNewFile();
            file1.createNewFile();
            file2.createNewFile();
            } catch (IOException ex){ ex.printStackTrace();}


    }

    @Test
    public void testIsDirectory(){
        assertTrue(vfs.isDirectory("src"));
    }

    @Test
    public void testNotDirectory(){
        assertFalse(vfs.isDirectory("src/main/java/files/myown/VFS.java"));
    }

    @Test
    public void testExists(){
        assertTrue(vfs.isExist("src/main/resources/remove1.txt"));
    }

    @Test
    public void testDelete(){
        assertTrue(vfs.isExist("src/main/resources/remove3.txt"));
        vfs.delete("src/main/resources/remove3.txt");
        assertFalse(vfs.isExist("src/main/resources/remove3.txt"));
    }

    @Test
    public void testGetBytes(){
        assertEquals(vfs.getBytes("src/main/resources/remove1.txt").length, 16);
    }

    @Test
    public void testGetText(){
        assertEquals(vfs.getUTF8Text("src/main/resources/remove2.txt"), "bla bla bla");
    }

    @Test
    public void testGetAbsolutePath(){
        assertEquals(vfs.getAbsolutePath("src/main/java/files/myown/VFS.java"), "C:\\Users\\user\\IdeaProjects\\myownfilesystem\\src\\main\\java\\files\\myown\\VFS.java");
    }

    @Test
    public void testDeleteRecursively(){
        vfs.removeDirectoryRecursively("src/test/resources/deletion");
        assertFalse(vfs.isExist("src/test/resources/deletion"));
        assertFalse(vfs.isExist("src/test/resources/deletion/delete.txt"));
        assertFalse(vfs.isExist("src/test/resources/deletion/again/again.txt"));
    }



}