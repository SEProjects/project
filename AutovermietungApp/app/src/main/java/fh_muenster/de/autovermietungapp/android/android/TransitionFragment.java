package fh_muenster.de.autovermietungapp.android.android;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fh_muenster.de.autovermietungapp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TransitionFragment extends Fragment {

	public TransitionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_transition_scene_2, container, false);
		return rootView;
	}

}
