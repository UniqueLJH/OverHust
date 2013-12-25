package com.unique.overhust.FirstInto;

import com.unique.overhust.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fhw on 12/24/13.
 */
public class Guides {
    public static final List<Data> IMG_DESCRIPTIONS = new ArrayList<Data>();

    static {
        Guides.IMG_DESCRIPTIONS.add(new Data(R.drawable.ic_overhust, true));
        Guides.IMG_DESCRIPTIONS.add(new Data(R.drawable.ic_launcher, true));
        Guides.IMG_DESCRIPTIONS.add(new Data(R.drawable.fg_d_9, true));
        Guides.IMG_DESCRIPTIONS.add(new Data(R.drawable.fg_xq_3, false));

    }

    public static final class Data {
        public final int imageId;
        //        public final int position;
        public final boolean isFinish;

        private Data(int imageId, boolean isfinish) {
            this.imageId = imageId;
//            this.position = position;
            this.isFinish = isfinish;
        }
    }
}
