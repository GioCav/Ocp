package giocavi.ocp.file;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.attribute.DosFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by Giovanni on 22/10/2016.
 */
class Mime implements Consumer<Path> {
    private Path targetdir;
    private Path sourcedir;
    public Mime(Path targetdir, Path sourcedir) throws IOException {
        this.targetdir = targetdir;
        this.sourcedir = sourcedir;
        if (!Files.exists(targetdir)) Files.createDirectories(targetdir);
    }
    public void accept (Path p)  {
        if (!p.isAbsolute()) {
            Path newdir = targetdir.resolve(sourcedir.relativize(p));
            if ((!Files.exists(newdir)) && Files.isDirectory(p)) try {
                Files.createDirectory(newdir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PathsExamples {

    public static void main(String[] args) throws IOException {
        Path p = Paths.get("giovanni.txt");
        System.out.println(p);
        System.out.println(p.toAbsolutePath());
        try {
            if (Files.exists(p)) Files.delete(p);
            Thread.sleep(0);
            Files.createFile(p);
            System.out.println(Files.size(p));
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter printer = new PrintWriter(Files.newBufferedWriter(p))) {
           printer.print("Today is :\n");
            DateTimeFormatter f = DateTimeFormatter.ofPattern("YYYY, EEEE d MMMM");
            printer.println(LocalDateTime.now().format(f));
            printer.println(Locale.getDefault());
        } catch (IOException e) {

        }
        //Might throw IOException
        System.out.println(p.toRealPath(LinkOption.NOFOLLOW_LINKS));
        System.out.println(p.relativize(Paths.get("pippo.doc")));
        System.out.println(p.resolve(Paths.get("pippo.doc")));
        System.out.println(Files.exists(p));
        System.out.println(Files.exists(p.resolve(Paths.get("pippo.doc"))));
        Path dir = Paths.get("src/main/java/giocavi/ocp/autogen");
        boolean b = false;
        if(Files.list(dir).count() == 0)  b = Files.deleteIfExists(dir);
        System.out.println("Directory deleted :" + b);
        // Files.createDirectory(dir);
        Path copy = Files.copy(p, dir.resolve(p), StandardCopyOption.REPLACE_EXISTING);
        System.out.println(copy);
        List<String> stringList = Files.readAllLines(p);
        Stream<String> stringStream = Files.lines(p);
        stringStream.map(x -> x + "\t").forEach(System.out::print);
        System.out.println("fine");
        System.out.println(Files.size(p));
        DosFileAttributes gioatt = Files.readAttributes(p, DosFileAttributes.class);
        System.out.println(gioatt.creationTime().toInstant());
        Path javadir = Paths.get("src", "main", "java");
        Files.walk(javadir).map(x -> javadir.relativize(x)).forEach(System.out::println);
        Consumer<Path> mime = new Mime(Paths.get("backup2"), javadir);
        Files.walk(javadir, 2).forEach(mime);
        Files.find(javadir, 5, (x,a) -> x.getFileName().toString().endsWith(".java")).forEach(System.out::println);
    }
}
