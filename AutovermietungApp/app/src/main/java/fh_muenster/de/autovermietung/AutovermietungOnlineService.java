package fh_muenster.de.autovermietung;

import fh_muenster.de.autovermietung.exceptions.InvalidLoginException;
import fh_muenster.de.autovermietung.exceptions.NoSessionException;

/**
 * Created by Marian on 09.06.2015.
 */
public interface AutovermietungOnlineService {
    public Kunde login(String username, String password)
            throws InvalidLoginException;
    public void logout()
            throws NoSessionException;
}
