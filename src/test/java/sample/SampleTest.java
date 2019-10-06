package sample;

import com.google.common.collect.Range;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class SampleTest {

    @Test()
    @Parameters({"platformName","systemPort","deviceName","deviceVersion","deviceId"})
    public void sampleTest(String platformName,Integer systemPort, String deviceName,
                           String deviceVersion, String deviceId) {
        assertThat(platformName).isNotEmpty();
        assertThat(systemPort).isIn(Range.open(8200, 8299));
        assertThat(deviceName).isNotEmpty();
        assertThat(deviceVersion).isNotEmpty();
        assertThat(deviceId).isNotEmpty();
    }
}
