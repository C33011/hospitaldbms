import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.Main;
import com.model.Patient;

public class TestConnection {
    @Test
    public void givenConnection_thenFetchDbData() throws SQLException{
        List<Patient> patients = Main.fetchData();

        assertNotEquals(0, patients.size());
    }
}
