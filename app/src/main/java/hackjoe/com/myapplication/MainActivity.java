package hackjoe.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.tvHelloWorld)
    TextView tvHelloWorld;

    @Bind(R.id.btnOpenActivity)
    public Button btnOpenActivity;

    @Bind(R.id.btnStartService)
    public Button btnStartService;


    @OnClick(R.id.btnOverlayService)
    void onOverlayClick()
    {
        Intent overlayService = new Intent(this,OverlayService.class);
        startService(overlayService);
    }

    @OnClick(R.id.btnOpenActivity)
    void onOpenActivityClick() {
        Intent pureIntent = new Intent(this, PureActivity.class);
        startActivity(pureIntent);
    }

    @OnClick(R.id.btnStartService)
    void onOpenStartService()
    {
        Intent serviceIntent = new Intent(this,TrainingService.class);
        startService(serviceIntent);
    }

    @Override
    protected void onCreateFinished(Bundle savedInstanceState) {
        tvHelloWorld.setText(R.string.hellobutterknife);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}