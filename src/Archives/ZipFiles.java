package Archives;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.*;

public class ZipFiles {

    public void archive(String filename) {
        String zipname = filename.replace("txt", "zip");

        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipname));
            FileInputStream fis = new FileInputStream(filename)) {

            ZipEntry entry1 = new ZipEntry(filename);
            zos.putNextEntry(entry1);

            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            zos.write(buffer);

            System.out.println("Archivation was finished successfully, check " + filename);
            zos.closeEntry();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void unarchive(String path){

        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(path)))
        {
            ZipEntry entry;
            String name;

            while((entry = zis.getNextEntry()) != null){

                name = entry.getName();

                FileOutputStream fout = new FileOutputStream(name);

                for (int c = zis.read(); c != -1; c = zis.read())
                    fout.write(c);

                fout.flush();
                zis.closeEntry();
                fout.close();
            }
        }

        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
