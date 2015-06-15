package fh_muenster.de.autovermietungapp.android.android;


import fh_muenster.de.autovermietung.AutovermietungOnlineService;
import fh_muenster.de.autovermietung.Kunde;
import fh_muenster.de.autovermietung.exceptions.InvalidLoginException;
import fh_muenster.de.autovermietung.exceptions.NoSessionException;

/**
 * Created by Marian on 09.06.2015.
 */
public class AutovermietungOnlineServiceImplMock implements AutovermietungOnlineService {

    private Kunde user;

    public AutovermietungOnlineServiceImplMock() {

    }
    public AutovermietungOnlineServiceImplMock(String username, String password) {
        this.user = new Kunde(username, password);
    }
    @Override
    public Kunde login(String username, String password) throws InvalidLoginException {
      if(this.user.getEmail().equals(username) && this.user.getKpassword().equals(password))
        return this.user;
			else
				return null;
    }

    @Override
    public void logout() throws NoSessionException {
        this.user = null;
    }

}
