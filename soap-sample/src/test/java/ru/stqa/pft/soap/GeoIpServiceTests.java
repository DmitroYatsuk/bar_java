package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Kiro on 11.11.16.
 */
public class GeoIpServiceTests {

  @Test
  public void testMyIp(){
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("91.196.98.198");
    assertEquals(geoIP.getCountryCode(), "UKR");
  }

  @Test
  public void testInvalidIp(){
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("91.196.98.xxx");
    assertEquals(geoIP.getCountryCode(), "UKR");
  }
}
