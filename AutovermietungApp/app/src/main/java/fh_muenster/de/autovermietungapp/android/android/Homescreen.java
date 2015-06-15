package fh_muenster.de.autovermietungapp.android.android;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import fh_muenster.de.autovermietung.Kunde;
import fh_muenster.de.autovermietung.exceptions.InvalidLoginException;
import fh_muenster.de.autovermietungapp.R;

/**
 * Created by marian on 08.06.15.
 */
public class Homescreen extends Activity {

	private TransitionManager mTransitionManager;
	private Scene mScene1;
	private Scene mScene2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homescreen);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
							.add(R.id.container, new TransitionFragment())
							.commit();
		}
		ViewGroup container = (ViewGroup)findViewById(R.id.container);
		TransitionInflater transitionInflater = TransitionInflater.from(this);
		mTransitionManager = transitionInflater.inflateTransitionManager(R.transition.transition_manager, container);
		mScene1 = Scene.getSceneForLayout(container, R.layout.fragment_transition_scene_1, this);
		mScene2 = Scene.getSceneForLayout(container, R.layout.fragment_transition_scene_2, this);
	}

	public void goToScene1(View view) {
		mTransitionManager.transitionTo(mScene1);
	}

	public void goToScene2(View view) {
		mTransitionManager.transitionTo(mScene2);
	}

	public void goToLogIn(View view) {
		EditText email = (EditText) findViewById(R.id.emailAdresse);
		EditText password = (EditText) findViewById(R.id.password);

		if(email.getText().toString().equals("") && password.getText().toString().equals(""))
		{
			//Toast anzeigen
			CharSequence text = "Fehlende Logindaten bitte in den Einstellungen eintragen!";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(email.getContext(), text, duration);
			toast.show();
		}
		else
		{
			LoginTask loginTask = new LoginTask(email.getContext());
			//Proxy asynchron aufrufen
			loginTask.execute(email.getText().toString(), password.getText().toString());
		}
	}


	private class LoginTask extends AsyncTask<String, Integer, Kunde> {
		//Dem Konstruktor der Klasse wird der aktuelle Kontext der Activity übergeben
		//damit auf die UI-Elemente zugegriffen werden kann und Intents gestartet werden können, usw.
		public LoginTask(Context email) {this.email = email;}

		private Context email;
		@Override
		protected Kunde doInBackground(String... params){
			OnlineServiceImpl myApp = new OnlineServiceImpl();
			try {
				Kunde myCustomer = myApp.login(params[0], params[1]);
				return myCustomer;
			} catch (InvalidLoginException e) {
				e.printStackTrace();
			}
			return null;
		}

		protected void onProgessUpdate(Integer... values)
		{
			//wird in diesem Beispiel nicht verwendet
		}

		protected void onPostExecute(Kunde result)
		{
			if(result != null)
			{
				//erfolgreich eingeloggt

				//Toast anzeigen
				CharSequence text = "Login erfolgreich! Angemeldeter Benutzername: " + result.getEmail();
				int duration = Toast.LENGTH_SHORT;
				Toast toast = Toast.makeText(email, text, duration);
				toast.show();

				//Nächste Activity anzeigen
				/*Intent i = new Intent(context, BankingActivity.class);
				startActivity(i);*/
			}
			else
			{
				//Toast anzeigen
				CharSequence text = "Login fehlgeschlagen!";
				int duration = Toast.LENGTH_SHORT;
				Toast toast = Toast.makeText(email, text, duration);
				toast.show();
			}
		}
	}
}
