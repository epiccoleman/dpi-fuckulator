import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.DisplayMode;

public class DPIFuckulator {
    private static void fuckulateDisplayInfo(GraphicsDevice device, int deviceIndex) {
        DisplayMode dm = device.getDisplayMode();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int dpi = toolkit.getScreenResolution();

        System.out.println("\nScreen " + deviceIndex + " (" + device.getIDstring() + "):");
        System.out.println("Screen DPI: " + dpi);
        System.out.println("Screen Resolution: " + dm.getWidth() + "x" + dm.getHeight());
        System.out.println("Bit Depth: " + dm.getBitDepth());
        System.out.println("Refresh Rate: " + dm.getRefreshRate() + "Hz");

        // Keep the twips conversion for each display
        int proposedTwips = 9360;
        double pixels = (proposedTwips / 1440.0) * dpi;
        System.out.println("Twips to Pixels Conversion:");
        System.out.println(proposedTwips + " twips = " + Math.round(pixels) + " pixels (at " + dpi + " DPI)");
    }

    public static void main(String[] args) {
        GraphicsDevice[] devices = GraphicsEnvironment
            .getLocalGraphicsEnvironment()
            .getScreenDevices();

        System.out.println("Found " + devices.length + " display(s)");

        for (int i = 0; i < devices.length; i++) {
            fuckulateDisplayInfo(devices[i], i);
        }
    }
}
