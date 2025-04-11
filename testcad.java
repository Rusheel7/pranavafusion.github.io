import org.jdx.dxf.DXFDocument;
import org.jdx.dxf.entities.DXFEntity;
import org.jdx.dxf.entities.DXFCircle;
import org.jdx.dxf.entities.DXFLine;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DXFReader {
    public static void main(String[] args) {
        try {
            // Load the DXF file
            File dxfFile = new File("path_to_your_file.dxf");  // Replace with your DXF file path
            DXFDocument doc = DXFDocument.load(dxfFile);
            
            // Print out all entities (like lines, circles, etc.)
            List<DXFEntity> entities = doc.getEntities();
            for (DXFEntity entity : entities) {
                if (entity instanceof DXFLine) {
                    DXFLine line = (DXFLine) entity;
                    System.out.println("Line: Start=(" + line.getStartPoint() + "), End=(" + line.getEndPoint() + ")");
                } else if (entity instanceof DXFCircle) {
                    DXFCircle circle = (DXFCircle) entity;
                    System.out.println("Circle: Center=(" + circle.getCenter() + "), Radius=" + circle.getRadius());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
