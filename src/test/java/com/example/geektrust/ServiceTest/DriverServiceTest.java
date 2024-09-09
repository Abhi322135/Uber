package com.example.geektrust.ServiceTest;

import com.example.geektrust.Constant;
import com.example.geektrust.Model.Driver;
import com.example.geektrust.Model.Location;
import com.example.geektrust.Repository.DriverRepository;
import com.example.geektrust.Service.DriverService;
import com.example.geektrust.Service.ServiceInterface.DriverServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DriverServiceTest {
    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private DriverService driverService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdd() {
        // Arrange
        Driver driver = new Driver("D1",new Location(10,20), Constant.FALSE); // Assuming a no-arg constructor for simplicity
        // Act
        driverService.add(driver);
        // Assert
        verify(driverRepository, times(1)).add(driver);
    }

    @Test
    public void testGetTopFiveDriver() {
        // Arrange
        Location riderLocation = new Location(10,10); // Assuming a no-arg constructor for simplicity
        List<Driver> expectedDrivers = Arrays.asList(new Driver("D1",new Location(10,20), Constant.FALSE),
                                                     new Driver("D2",new Location(8,10), Constant.FALSE),
                                                     new Driver("D3",new Location(10,20), Constant.FALSE),
                                                     new Driver("D4",new Location(10,16), Constant.FALSE),
                                                     new Driver("D5",new Location(10,9), Constant.FALSE));

        when(driverRepository.getTopFiveDriver(riderLocation)).thenReturn(expectedDrivers);

        // Act
        List<Driver> actualDrivers = driverService.getTopFiveDriver(riderLocation);

        // Assert
        assertEquals(expectedDrivers, actualDrivers);
        verify(driverRepository, times(1)).getTopFiveDriver(riderLocation);
    }

    @Test
    public void testUpdateDriver() {
        // Arrange
        Driver driver2 = new Driver("D1",new Location(10,22), Constant.FALSE);
        Driver driver = new Driver("D1",new Location(10,22), Constant.FALSE);// Assuming a no-arg constructor for simplicity
        driverService.add(driver2);
        // Act
        driverService.updateDriver(driver);
        // Assert
        verify(driverRepository, times(1)).updateDriverDetails(driver);
    }

    @Test
    public void testGetAllDriver() {
        // Arrange
        List<Driver> expectedDrivers = Arrays.asList(new Driver("D1",new Location(10,20), Constant.FALSE),
                                                     new Driver("D2",new Location(10,20), Constant.FALSE));
        when(driverRepository.getAllDriverList()).thenReturn(expectedDrivers);
        // Act
        List<Driver> actualDrivers = driverService.getAllDriver();
        // Assert
        assertEquals(expectedDrivers, actualDrivers);
        verify(driverRepository, times(1)).getAllDriverList();
    }

}
