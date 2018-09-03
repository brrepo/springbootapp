package repository;

import com.various.restservice.Application;
import com.various.restservice.entity.FuelData;
import com.various.restservice.repository.FuelDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = Application.class)
public class RepositoryTests {

    @Autowired
    FuelDataRepository fuelDataRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void contextLoads() {
        assertThat(fuelDataRepository).isNotNull();
    }

    @Test
    public void testRecordAdded() {

        List<FuelData> fuelDataListOriginal = fuelDataRepository.findAll();

        //given
        FuelData fuelData = new FuelData();
        fuelData.setDate(new Date(2100, 03, 01));
        fuelData.setDriverId(12345);
        fuelData.setFuelType("D");
        fuelData.setPrice("2.99");
        fuelData.setVolume("30.01");
        entityManager.persist(fuelData);
        entityManager.flush();

        //when
        List<FuelData> fuelDataListAfter = fuelDataRepository.findAll();

        //then
        assertThat(fuelDataListAfter.size() - fuelDataListOriginal.size()).isEqualTo(1);
        assertThat(fuelDataListAfter.get(fuelDataListAfter.size() - 1)).isEqualTo(fuelData);
    }

    @Test
    public void testTransactionYearEqualsAndTransactionMonthEquals() {

        List<FuelData> fuelDataListBefore =
                fuelDataRepository.findByTransactionYearEqualsAndTransactionMonthEquals(2017,3);
        //given
        FuelData fuelData = new FuelData();
        fuelData.setDate(new Date(2017 - 1900, 03 - 1, 01));
        fuelData.setDriverId(5007);
        fuelData.setFuelType("D");
        fuelData.setPrice("2.99");
        fuelData.setVolume("30.01");
        entityManager.persist(fuelData);
        entityManager.flush();

        //when
        List<FuelData> fuelDataListAfter =
                fuelDataRepository.findByTransactionYearEqualsAndTransactionMonthEquals(2017,3);

        //then
        assertThat(fuelDataListAfter.size() - fuelDataListBefore.size()).isEqualTo(1);
        assertThat(fuelDataListAfter.get(fuelDataListAfter.size() - 1)).isEqualTo(fuelData);
    }

    @Test
    public void testTransactionYearEqualsAndTransactionMonthEqualsAndDriverIdEquals() {

        List<FuelData> fuelDataListBefore =
                fuelDataRepository.findByTransactionYearEqualsAndTransactionMonthEquals(2017,3);
        //given
        FuelData fuelData = new FuelData();
        fuelData.setDate(new Date(2017 - 1900, 03 - 1, 01));
        fuelData.setDriverId(5007);
        fuelData.setFuelType("D");
        fuelData.setPrice("2.99");
        fuelData.setVolume("30.01");
        entityManager.persist(fuelData);
        entityManager.flush();

        //when
        List<FuelData> fuelDataListAfter =
                fuelDataRepository.findByTransactionYearEqualsAndTransactionMonthEqualsAndDriverIdEquals(2017,3, 5007);

        //then
        assertThat(fuelDataListAfter.size() - fuelDataListBefore.size()).isEqualTo(1);
        assertThat(fuelDataListAfter.get(fuelDataListAfter.size() - 1)).isEqualTo(fuelData);
    }


}