import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;

import com.dao.PatientDao;
import com.model.Patient;

public class TestPatientDao {
    @Test 
    public void addPatient_returnsId() throws SQLException{
        Patient p = new Patient(null, "Test", "Test", LocalDate.of(1986, 2, 23),"M", 75, 105, "B");
        PatientDao dao = new PatientDao();
        dao.add(p);

        assertNotEquals(p.getPatientId(),null);
    }

    @Test
    public void getPatient_returnsPatient(){
        Patient p = new Patient(null, "Test", "Test", LocalDate.of(1986, 2, 23),"M", 75, 105, "B");
        PatientDao dao = new PatientDao();
        dao.add(p);

        Optional<Patient> pt = dao.get(p.getPatientId());
        assertTrue(pt.isPresent());
        
        Patient pr = pt.get();
        assertEquals(p.getPatientId(), pr.getPatientId());
        assertEquals(p.getFirstName(), pr.getLastName());
        assertEquals(p.getDob(), pr.getDob());
        assertEquals(p.getBloodType(), pr.getBloodType());
        assertEquals(p.getSex(), pr.getSex());
        assertEquals(p.getHeightCm(), pr.getHeightCm());
        assertEquals(p.getWeightKg(),pr.getWeightKg());
    }
}
