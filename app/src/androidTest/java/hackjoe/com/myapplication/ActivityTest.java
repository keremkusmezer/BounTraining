package hackjoe.com.myapplication;

import android.test.ActivityInstrumentationTestCase2;

public class ActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;

    public ActivityTest() {
        super(MainActivity.class);
    }



    @Override
    public void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
    }

    public void testActivityText() throws Exception {
        assertNotNull(mainActivity.tvHelloWorld);
        assertEquals(mainActivity.tvHelloWorld.getText(),mainActivity.getString(R.string.hellobutterknife));
    }
}
