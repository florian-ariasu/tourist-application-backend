import org.example.Main;
import org.example.PathTypes;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private static final String MAIN_PATH = String.join(File.separator, "src", "main", "resources");

    @Test
    public void basicMuseumsLoad01() throws IOException {
        String filePath = prepareFilePath("01-basic-museums-load", "museums_01");
        emptyOutput(prepareFilePath("01-basic-museums-load", ""));
        Main.main(new String[]{PathTypes.MUSEUMS.getValue(), filePath});
        assertTrue(areFilesEqual(filePath));
    }

    @Test
    public void erroredMuseumsLoad02() throws IOException {
        String filePath = prepareFilePath("02-errored-museums-load", "museums_02");
        emptyOutput(prepareFilePath("02-errored-museums-load", ""));
        Main.main(new String[]{PathTypes.MUSEUMS.getValue(), filePath});
        assertTrue(areFilesEqual(filePath));
    }

    @Test
    public void basicGroupsLoad03() throws IOException {
        String filePath = prepareFilePath("03-basic-groups", "groups_01");
        emptyOutput(prepareFilePath("03-basic-groups", ""));
        Main.main(new String[]{PathTypes.GROUPS.getValue(), filePath});
        assertTrue(areFilesEqual(filePath));
    }

    @Test
    public void erroredGroupGuide04() throws IOException {
        String filePath = prepareFilePath("04-errored-guide", "groups_02");
        emptyOutput(prepareFilePath("04-errored-guide", ""));
        Main.main(new String[]{PathTypes.GROUPS.getValue(), filePath});
        assertTrue(areFilesEqual(filePath));
    }

    @Test
    public void erroredGroupMembers05() throws IOException {
        String filePath = prepareFilePath("05-errored-members", "groups_03");
        emptyOutput(prepareFilePath("05-errored-members", ""));
        Main.main(new String[]{PathTypes.GROUPS.getValue(), filePath});
        assertTrue(areFilesEqual(filePath));
    }

    @Test
    public void findGroups06() throws IOException {
        String filePath = prepareFilePath("06-find-groups", "groups_04");
        emptyOutput(prepareFilePath("06-find-groups", ""));
        Main.main(new String[]{PathTypes.GROUPS.getValue(), filePath});
        assertTrue(areFilesEqual(filePath));
    }

    @Test
    public void museumNotificator07() throws IOException {
        String filePath01 = prepareFilePath("07-museum-listener", "museums_03");
        String filePath02 = prepareFilePath("07-museum-listener", "groups_05");
        String filePath03 = prepareFilePath("07-museum-listener", "events_01");
        emptyOutput(prepareFilePath("07-museum-listener", ""));
        Main.main(new String[]{PathTypes.LISTENER.getValue(), filePath01, filePath02, filePath03});
        assertTrue(areFilesEqual(filePath01) && areFilesEqual(filePath02));
        assertTrue(areEventsEqual(filePath03));
    }

    private boolean areFilesEqual(String filePath) throws IOException {
        List<String> lines1 = Files.readAllLines(Path.of(filePath + ".out"));
        List<String> lines2 = Files.readAllLines(Path.of(filePath + ".ref"));

        if (lines1.size() != lines2.size()) {
            return false;
        }

        for (int i = 0; i < lines1.size(); i++) {
            String line1 = lines1.get(i).trim();
            String line2 = lines2.get(i).trim();

            if (!line1.equals(line2)) {
                return false;
            }
        }

        return true;
    }

    private boolean areEventsEqual(String filePath) throws IOException {
        List<String> lines1 = Files.readAllLines(Path.of(filePath + ".out"));
        List<String> lines2 = Files.readAllLines(Path.of(filePath + ".ref"));

        if (lines1.size() != lines2.size()) {
            return false;
        }

        for (String line1 : lines1) {
            if (!lines2.contains(line1)) {
                return false;
            }
        }

        return true;
    }

    private void emptyOutput(String filePath) {
        File[] files = new File(filePath).listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".out")) {
                file.delete();
            }
        }
    }

    private String prepareFilePath(String dirName, String fileName) {
        return String.join(File.separator, MAIN_PATH, dirName, fileName);
    }
}
