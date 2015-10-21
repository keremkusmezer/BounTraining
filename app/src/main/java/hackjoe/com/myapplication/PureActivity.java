package hackjoe.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PureActivity extends Activity {

    TextView tvHelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHelloWorld = (TextView) findViewById(R.id.tvHelloWorld);
        tvHelloWorld.setText("Hello Pure Activity Text View");
    }
}
