package regression.issue3;

import org.jglrxavpok.hephaistos.mca.AnvilException;
import org.jglrxavpok.hephaistos.mca.ChunkColumn;
import org.jglrxavpok.hephaistos.mca.RegionFile;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Issue3 {

    @Before
    public void init() {

    }

    @Test
    public void loadAllChunks() throws IOException, AnvilException {
        String name = "src/test/resources/issue_3/r.0.0.mca";
        RegionFile file = new RegionFile(new RandomAccessFile(name, "rw"), 0, 0);
        for (int chunkX = 0; chunkX < 32; chunkX++) {
            for (int chunkZ = 0; chunkZ < 32; chunkZ++) {
                if(file.hasChunk(chunkX, chunkZ)) {
                    ChunkColumn column = file.getChunk(chunkX, chunkZ);
                    file.forget(column);
                }
            }
        }
    }

}
