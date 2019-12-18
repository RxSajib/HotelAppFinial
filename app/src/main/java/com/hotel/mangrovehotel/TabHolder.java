package com.hotel.mangrovehotel;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class TabHolder extends FragmentPagerAdapter {
    public TabHolder(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                VisitUsFragment visitUsFragment = new VisitUsFragment();
                return visitUsFragment;

            case 1:
                BookingFragment bookingFragment = new BookingFragment();
                return bookingFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {

            case 0:
                return "Visit Us";

            case 1:
                return "Booking";
        }

        return super.getPageTitle(position);
    }
}
