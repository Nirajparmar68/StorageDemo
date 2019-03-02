package pcs.mca.atmiya.storagedemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new FileFragment();
            case 1:return new PreferenceFragment();
            case 2:return new DatabaseFragment();
            case 3:return new ContentProviderFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
