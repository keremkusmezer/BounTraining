package hackjoe.com.myapplication;

import android.app.Activity;
import android.app.KeyguardManager;
import android.os.Bundle;

import butterknife.ButterKnife;

public abstract class BaseActivity extends Activity {

    protected boolean shouldDismissKeyguard()
    {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(shouldDismissKeyguard())
        {
            KeyguardManager keyguardManager = (KeyguardManager)   getSystemService(Activity.KEYGUARD_SERVICE);
            KeyguardManager.KeyguardLock lock = keyguardManager.newKeyguardLock(KEYGUARD_SERVICE);
            lock.disableKeyguard();
        }
        setContentView(getContentView());
        ButterKnife.bind(this);
        onCreateFinished(savedInstanceState);
    }

    protected abstract void onCreateFinished(Bundle savedInstanceState);

    protected abstract int getContentView();
}
