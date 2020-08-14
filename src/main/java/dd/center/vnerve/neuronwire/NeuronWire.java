package dd.center.vnerve.neuronwire;

import dd.center.vnerve.data.bilibili.live.RoomMessage;
import dd.center.vnerve.neuronwire.deserialize.DeserializeFailedException;
import dd.center.vnerve.neuronwire.deserialize.ProtobufDeserializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Charlie Jiang
 * @since rv1
 */
public class NeuronWire {
    public static void main(String[] args) throws IOException, DeserializeFailedException {
        ProtobufDeserializer desc = new ProtobufDeserializer();
        File file = new File("C:\\Users\\cqjjj\\source\\repos\\vNerveVisualizer\\vNerveVisualizer\\bin\\Debug\\blv.22055164.gift.bin");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        RoomMessage result = desc.deserialize(data);
        return;
    }
}
