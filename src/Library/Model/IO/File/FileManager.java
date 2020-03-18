package Library.Model.IO.File;

import Library.Model.Library;

public interface FileManager {
    Library importData();
    void exportData(Library library);
}
