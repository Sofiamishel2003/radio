import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import junit.framework.TestCase;
public class test extends TestCase{
    radio_metodos radio;
    private void prueba()
    {
        radio = new radio_metodos();
    }
    public void testOn()
    {
        prueba();
        radio.on();
        assertEquals(true, radio.isOn());
    }
    public void testFM() throws Exception
    {
        prueba();
        radio.setFrequence("2");
        assertEquals("FM", radio.getFrequence());
    }
    public void testForward()
    {
        prueba();
        radio.Forward();
        assertEquals(540, radio.getAMActualStation());
    }
}
