package repository;

import com.various.restservice.Application;
import com.various.restservice.entity.FuelData;
import com.various.restservice.entity.FuelStatistics;
import com.various.restservice.repository.FuelDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = Application.class)
public class RepositoryDestructiveTests {

    @Autowired
    FuelDataRepository fuelDataRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void contextLoads() {
        assertThat(fuelDataRepository).isNotNull();
    }

    @Test
    public void testFuelStatistics() {

        List<FuelData> fuelDataListOriginal = fuelDataRepository.findAll();
        List <FuelStatistics> statsBefore = fuelDataRepository.findFuelStatistics(2017, 3);

        //given
        FuelData fuelData = new FuelData();
        fuelData.setDate(new Date(2017 - 1900, 03 - 1, 01));
        fuelData.setDriverId(12345);
        fuelData.setFuelType("D");
        fuelData.setPrice("2.99");
        fuelData.setVolume("30.00");
        entityManager.persist(fuelData);
        entityManager.flush();

        //when
        List <FuelStatistics> statsAfter = fuelDataRepository.findFuelStatistics(2017, 3);

        //then

        long plusVolume = 3000;
        long plusSum = (long) (299 * 3000)/100;
        assert(statsBefore.get(0).getTotalSum() + plusSum == statsAfter.get(0).getTotalSum());
        assert(statsBefore.get(0).getVolumeSum() + plusVolume== statsAfter.get(0).getVolumeSum());
    }

}