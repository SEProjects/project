package fh_muenster.de.autovermietungapp.android.android;

import android.app.Application;

import fh_muenster.de.autovermietung.AutovermietungOnlineService;
import fh_muenster.de.autovermietung.Kunde;


/**
 * Created by Marian on 09.06.2015.
 */
public class AutovermietungApplication extends Application {

    private Kunde user;
    private AutovermietungOnlineService autovermietungOnlineService;

    public AutovermietungApplication() { this.autovermietungOnlineService = new AutovermietungOnlineServiceImplMock("test", "123");}

    public Kunde getUser() {
        return this.user;
    }

    public void setUser(Kunde user) {
        this.user = user;
    }

    public AutovermietungOnlineService getAutovermietungOnlineService() {
        return this.autovermietungOnlineService;
    }
}
