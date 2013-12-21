package com.unique.overhust.CommonUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ArrayAdapter;

import com.unique.overhust.MapUtils.StreetPoiData;
import com.unique.overhust.R;

import java.util.ArrayList;

/**
 * Created by fhw on 12/6/13.
 */
public class AddPois {
    private ArrayList<StreetPoiData> pois = new ArrayList<StreetPoiData>();
    private Context mContext;

    public AddPois(Context mContext) {
        this.mContext = mContext;
        pois.add(new StreetPoiData(30511470, 114432596,
                getBm(R.drawable.fg_yy_1),
                getBm(R.drawable.fg_yy_1), 20));
        pois.add(new StreetPoiData(30511783, 114432732,
                getBm(R.drawable.fg_yy_2),
                getBm(R.drawable.fg_yy_2), 20));
        pois.add(new StreetPoiData(30512213, 114432778,
                getBm(R.drawable.fg_yy_3),
                getBm(R.drawable.fg_yy_3), 20));
        pois.add(new StreetPoiData(30512606, 114432765,
                getBm(R.drawable.fg_yy_4),
                getBm(R.drawable.fg_yy_4), 20));
        pois.add(new StreetPoiData(30512606, 114432765,
                getBm(R.drawable.fg_yy_5),
                getBm(R.drawable.fg_yy_5), 20));
        pois.add(new StreetPoiData(30514870, 114432102,
                getBm(R.drawable.fg_yy_6),
                getBm(R.drawable.fg_yy_6), 20));
        pois.add(new StreetPoiData(30514778, 114432947,
                getBm(R.drawable.fg_yy_7),
                getBm(R.drawable.fg_yy_7), 20));
        pois.add(new StreetPoiData(30515208, 114432191,
                getBm(R.drawable.fg_yy_8),
                getBm(R.drawable.fg_yy_8), 20));
        pois.add(new StreetPoiData(30515208, 114432191,
                getBm(R.drawable.fg_yy_9),
                getBm(R.drawable.fg_yy_9), 20));
        pois.add(new StreetPoiData(30515490, 114432915,
                getBm(R.drawable.fg_yy_10),
                getBm(R.drawable.fg_yy_10), 20));
        pois.add(new StreetPoiData(30515425, 114433457,
                getBm(R.drawable.fg_yy_11),
                getBm(R.drawable.fg_yy_11), 20));
        pois.add(new StreetPoiData(30515855, 114432604,
                getBm(R.drawable.fg_yy_12),
                getBm(R.drawable.fg_yy_12), 20));
        pois.add(new StreetPoiData(30514213, 114433852,
                getBm(R.drawable.fg_yy_13),
                getBm(R.drawable.fg_yy_13), 20));
        pois.add(new StreetPoiData(30514121, 114434898,
                getBm(R.drawable.fg_yy_14),
                getBm(R.drawable.fg_yy_14), 20));
        pois.add(new StreetPoiData(30514014, 114436325,
                getBm(R.drawable.fg_yy_15),
                getBm(R.drawable.fg_yy_15), 20));
        pois.add(new StreetPoiData(30514333, 114433884,
                getBm(R.drawable.fg_yy_16),
                getBm(R.drawable.fg_yy_16), 20));
        pois.add(new StreetPoiData(30514269, 114434973,
                getBm(R.drawable.fg_yy_17),
                getBm(R.drawable.fg_yy_17), 20));
        pois.add(new StreetPoiData(30514199, 114436186,
                getBm(R.drawable.fg_yy_18),
                getBm(R.drawable.fg_yy_18), 20));
        pois.add(new StreetPoiData(30514148, 114436829,
                getBm(R.drawable.fg_yy_19),
                getBm(R.drawable.fg_yy_19), 20));
        pois.add(new StreetPoiData(30514634, 114434056,
                getBm(R.drawable.fg_yy_20),
                getBm(R.drawable.fg_yy_20), 20));
        pois.add(new StreetPoiData(30515003, 114433831,
                getBm(R.drawable.fg_yy_21),
                getBm(R.drawable.fg_yy_21), 20));
        pois.add(new StreetPoiData(30515284, 114434417,
                getBm(R.drawable.fg_yy_22),
                getBm(R.drawable.fg_yy_22), 20));
        pois.add(new StreetPoiData(30515598, 114434325,
                getBm(R.drawable.fg_yy_23),
                getBm(R.drawable.fg_yy_23), 20));
        pois.add(new StreetPoiData(30515811, 114433301,
                getBm(R.drawable.fg_yy_24),
                getBm(R.drawable.fg_yy_24), 20));
        pois.add(new StreetPoiData(30515968, 114434116,
                getBm(R.drawable.fg_yy_25),
                getBm(R.drawable.fg_yy_25), 20));
        pois.add(new StreetPoiData(30516176, 114433333,
                getBm(R.drawable.fg_yy_26),
                getBm(R.drawable.fg_yy_26), 20));
        pois.add(new StreetPoiData(30516176, 114433333,
                getBm(R.drawable.fg_yy_27),
                getBm(R.drawable.fg_yy_27), 20));
        pois.add(new StreetPoiData(30511208, 114404215,
                getBm(R.drawable.fg_zs_1),
                getBm(R.drawable.fg_zs_1), 20));
        pois.add(new StreetPoiData(30511808, 114404129,
                getBm(R.drawable.fg_zs_2),
                getBm(R.drawable.fg_zs_2), 20));
        pois.add(new StreetPoiData(30511115, 114403421,
                getBm(R.drawable.fg_zs_3),
                getBm(R.drawable.fg_zs_3), 20));
        pois.add(new StreetPoiData(30511226, 114403410,
                getBm(R.drawable.fg_zs_4),
                getBm(R.drawable.fg_zs_4), 20));
        pois.add(new StreetPoiData(30511713, 114403314,
                getBm(R.drawable.fg_zs_5),
                getBm(R.drawable.fg_zs_5), 20));
        pois.add(new StreetPoiData(30512009, 114403389,
                getBm(R.drawable.fg_zs_6),
                getBm(R.drawable.fg_zs_6), 20));
        pois.add(new StreetPoiData(30511029, 114402466,
                getBm(R.drawable.fg_zs_7),
                getBm(R.drawable.fg_zs_7), 20));
        pois.add(new StreetPoiData(30511186, 114402434,
                getBm(R.drawable.fg_zs_8),
                getBm(R.drawable.fg_zs_8), 20));
        pois.add(new StreetPoiData(30511186, 114402434,
                getBm(R.drawable.fg_zs_9),
                getBm(R.drawable.fg_zs_9), 20));
        pois.add(new StreetPoiData(30512129, 114402402,
                getBm(R.drawable.fg_zs_10),
                getBm(R.drawable.fg_zs_10), 20));
        pois.add(new StreetPoiData(30510918, 114401737,
                getBm(R.drawable.fg_zs_11),
                getBm(R.drawable.fg_zs_11), 20));
        pois.add(new StreetPoiData(30511084, 114401694,
                getBm(R.drawable.fg_zs_12),
                getBm(R.drawable.fg_zs_12), 20));
        pois.add(new StreetPoiData(30511583, 114401608,
                getBm(R.drawable.fg_zs_13),
                getBm(R.drawable.fg_zs_13), 20));
        pois.add(new StreetPoiData(30510650, 114421440,
                getBm(R.drawable.fg_qy_1),
                getBm(R.drawable.fg_qy_1), 20));
        pois.add(new StreetPoiData(30512120, 114420453,
                getBm(R.drawable.fg_qy_2),
                getBm(R.drawable.fg_qy_2), 20));
        pois.add(new StreetPoiData(30511750, 114419520,
                getBm(R.drawable.fg_qy_3),
                getBm(R.drawable.fg_qy_3), 20));
        pois.add(new StreetPoiData(30512203, 114419627,
                getBm(R.drawable.fg_qy_4),
                getBm(R.drawable.fg_qy_4), 20));
        pois.add(new StreetPoiData(30512397, 114417782,
                getBm(R.drawable.fg_qy_5),
                getBm(R.drawable.fg_qy_5), 20));
        pois.add(new StreetPoiData(30511158, 114421558,
                getBm(R.drawable.fg_qy_6),
                getBm(R.drawable.fg_qy_6), 20));
        pois.add(new StreetPoiData(30511638, 114421580,
                getBm(R.drawable.fg_qy_7),
                getBm(R.drawable.fg_qy_7), 20));
        pois.add(new StreetPoiData(30511693, 114420421,
                getBm(R.drawable.fg_qy_8),
                getBm(R.drawable.fg_qy_8), 20));
        pois.add(new StreetPoiData(30512387, 114421730,
                getBm(R.drawable.fg_qy_9),
                getBm(R.drawable.fg_qy_9), 20));
        pois.add(new StreetPoiData(30511924, 114421676,
                getBm(R.drawable.fg_qy_10),
                getBm(R.drawable.fg_qy_10), 20));
        pois.add(new StreetPoiData(30511638, 114421623,
                getBm(R.drawable.fg_qy_11),
                getBm(R.drawable.fg_qy_11), 20));
        pois.add(new StreetPoiData(30511160, 114421549,
                getBm(R.drawable.fg_qy_12),
                getBm(R.drawable.fg_qy_12), 20));
        pois.add(new StreetPoiData(30510855, 114421474,
                getBm(R.drawable.fg_qy_13),
                getBm(R.drawable.fg_qy_13), 20));
        pois.add(new StreetPoiData(30514603, 114406716,
                getBm(R.drawable.fg_xq_1),
                getBm(R.drawable.fg_xq_1), 20));
        pois.add(new StreetPoiData(30515056, 114406566,
                getBm(R.drawable.fg_xq_2),
                getBm(R.drawable.fg_xq_2), 20));
        pois.add(new StreetPoiData(30513623, 114406319,
                getBm(R.drawable.fg_xq_3),
                getBm(R.drawable.fg_xq_3), 20));
        pois.add(new StreetPoiData(30514958, 114405676,
                getBm(R.drawable.fg_xq_4),
                getBm(R.drawable.fg_xq_4), 20));
        pois.add(new StreetPoiData(30513507, 114408615,
                getBm(R.drawable.fg_xq_5),
                getBm(R.drawable.fg_xq_5), 20));
        pois.add(new StreetPoiData(30514736, 114405831,
                getBm(R.drawable.fg_xq_6),
                getBm(R.drawable.fg_xq_6), 20));
        pois.add(new StreetPoiData(30514112, 114409858,
                getBm(R.drawable.fg_xq_7),
                getBm(R.drawable.fg_xq_7), 20));
        pois.add(new StreetPoiData(30514704, 114408528,
                getBm(R.drawable.fg_xq_8),
                getBm(R.drawable.fg_xq_8), 20));
        pois.add(new StreetPoiData(30515074, 114408571,
                getBm(R.drawable.fg_xq_9),
                getBm(R.drawable.fg_xq_9), 20));
        pois.add(new StreetPoiData(30514796, 114407777,
                getBm(R.drawable.fg_xq_10),
                getBm(R.drawable.fg_xq_10), 20));
        pois.add(new StreetPoiData(30515259, 114407755,
                getBm(R.drawable.fg_xq_11),
                getBm(R.drawable.fg_xq_11), 20));
        pois.add(new StreetPoiData(30514344, 114407959,
                getBm(R.drawable.fg_xq_12),
                getBm(R.drawable.fg_xq_12), 20));
        pois.add(new StreetPoiData(30514066, 114407991,
                getBm(R.drawable.fg_xq_13),
                getBm(R.drawable.fg_xq_13), 20));
        pois.add(new StreetPoiData(30511071, 114406865,
                getBm(R.drawable.fg_x_1),
                getBm(R.drawable.fg_x_1), 20));
        pois.add(new StreetPoiData(30510434, 114407895,
                getBm(R.drawable.fg_x_2),
                getBm(R.drawable.fg_x_2), 20));
        pois.add(new StreetPoiData(30510184, 114408882,
                getBm(R.drawable.fg_x_3),
                getBm(R.drawable.fg_x_3), 20));
        pois.add(new StreetPoiData(30511367, 114409300,
                getBm(R.drawable.fg_x_4),
                getBm(R.drawable.fg_x_4), 20));
        pois.add(new StreetPoiData(30510545, 114410051,
                getBm(R.drawable.fg_x_5),
                getBm(R.drawable.fg_x_5), 20));
        pois.add(new StreetPoiData(30510101, 114410041,
                getBm(R.drawable.fg_x_6),
                getBm(R.drawable.fg_x_6), 20));
        pois.add(new StreetPoiData(30510914, 114406060,
                getBm(R.drawable.fg_x_7),
                getBm(R.drawable.fg_x_7), 20));
        pois.add(new StreetPoiData(30510646, 114406382,
                getBm(R.drawable.fg_x_8),
                getBm(R.drawable.fg_x_8), 20));
        pois.add(new StreetPoiData(30509851, 114407101,
                getBm(R.drawable.fg_x_9),
                getBm(R.drawable.fg_x_9), 20));
        pois.add(new StreetPoiData(30509036, 114407995,
                getBm(R.drawable.fg_x_12),
                getBm(R.drawable.fg_x_12), 20));
        pois.add(new StreetPoiData(30509519, 114413549,
                getBm(R.drawable.fg_n_1),
                getBm(R.drawable.fg_n_1), 20));
        pois.add(new StreetPoiData(30509500, 114411414,
                getBm(R.drawable.fg_n_2),
                getBm(R.drawable.fg_n_2), 20));
        pois.add(new StreetPoiData(30510073, 114411596,
                getBm(R.drawable.fg_n_3),
                getBm(R.drawable.fg_n_3), 20));
        pois.add(new StreetPoiData(30509389, 114410996,
                getBm(R.drawable.fg_n_4),
                getBm(R.drawable.fg_n_4), 20));
        pois.add(new StreetPoiData(30509001, 114415770,
                getBm(R.drawable.fg_n_5),
                getBm(R.drawable.fg_n_5), 20));
        pois.add(new StreetPoiData(30508751, 114415705,
                getBm(R.drawable.fg_n_6),
                getBm(R.drawable.fg_n_6), 20));
        pois.add(new StreetPoiData(30512181, 114415963,
                getBm(R.drawable.fg_d_1),
                getBm(R.drawable.fg_d_1), 20));
        pois.add(new StreetPoiData(30511589, 114415416,
                getBm(R.drawable.fg_d_2),
                getBm(R.drawable.fg_d_2), 20));
        pois.add(new StreetPoiData(30511478, 114416510,
                getBm(R.drawable.fg_d_3),
                getBm(R.drawable.fg_d_3), 20));
        pois.add(new StreetPoiData(30511312, 114418152,
                getBm(R.drawable.fg_d_4),
                getBm(R.drawable.fg_d_4), 20));
        pois.add(new StreetPoiData(30511783, 114418162,
                getBm(R.drawable.fg_d_5),
                getBm(R.drawable.fg_d_5), 20));
        pois.add(new StreetPoiData(30510924, 114417615,
                getBm(R.drawable.fg_d_6),
                getBm(R.drawable.fg_d_6), 20));
        pois.add(new StreetPoiData(30510850, 114418538,
                getBm(R.drawable.fg_d_7),
                getBm(R.drawable.fg_d_7), 20));
        pois.add(new StreetPoiData(30512892, 114416027,
                getBm(R.drawable.fg_d_8),
                getBm(R.drawable.fg_d_8), 20));
        pois.add(new StreetPoiData(30513383, 114427180,
                getBm(R.drawable.fg_d_9),
                getBm(R.drawable.fg_d_9), 20));
        pois.add(new StreetPoiData(30512276, 114434347,
                getBm(R.drawable.fg_d_12),
                getBm(R.drawable.fg_d_12), 20));
    }

    private Bitmap getBm(int resId) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inScaled = false;

        return BitmapFactory.decodeResource(mContext.getResources(), resId, options);
    }

    public ArrayList<StreetPoiData> getPois() {
        return pois;
    }
}
