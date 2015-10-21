package hackjoe.com.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class TrainingService extends Service {
    private int startCount = 0;
    private int startCountExtended = 0;

    public TrainingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startCount++;
        Toast.makeText(this, "Start Count" + startCount, Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startCountExtended++;
        Toast.makeText(this,"started" + startCountExtended,Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }
}