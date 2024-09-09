package com.example.geektrust.ServiceTest;

import com.example.geektrust.Model.Location;
import com.example.geektrust.Model.Rider;
import com.example.geektrust.Repository.RiderRepository;
import com.example.geektrust.Service.RiderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class RiderServiceTest {
    @Mock
    private RiderRepository riderRepository;

    @InjectMocks
    private RiderService riderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddRider() {
        // Arrange
        Rider rider = new Rider("R1",new Location(10,20)); // Assuming a no-arg constructor for simplicity
        // Act
        riderService.addRider(rider);
        // Assert
        verify(riderRepository, times(1)).add(rider);
    }

    @Test
    public void testUpdateRider() {
        // Arrange
        Rider rider = new Rider("R1",new Location(10,20)); // Assuming a no-arg constructor for simplicity
        Rider rider1 = new Rider("R1",new Location(10,20));
        riderService.addRider(rider1);
        // Act
        riderService.updateRider(rider);

        // Assert
        verify(riderRepository, times(1)).update(rider);
    }

    @Test
    public void testGetRiderById() {
        // Arrange
        String id = "R1";
        Rider expectedRider = new Rider("R1",new Location(10,20)); // Assuming a no-arg constructor for simplicity
        expectedRider.setId(id);
        riderRepository.add(expectedRider);
        when(riderRepository.getById(id)).thenReturn(Optional.of(expectedRider));

        // Act
        Optional<Rider> actualRider = riderService.getRiderById(id);

        // Assert
        assertTrue(actualRider.isPresent());
        assertEquals(expectedRider, actualRider.get());
        verify(riderRepository, times(1)).getById(id);
    }

}
