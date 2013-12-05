package com.unique.overhust.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.unique.overhust.MainActivity.MainActivity;
import com.unique.overhust.MapUtils.ImageScrollView;
import com.unique.overhust.MapUtils.Images;
import com.unique.overhust.MapUtils.SearchCheeses;
import com.unique.overhust.R;

import org.xmlpull.v1.XmlPullParser;

import java.util.jar.Attributes;

/**
 * Created by fhw on 11/17/13.
 */
public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {
    private View searchView;

    private SearchView mSearchView;
    private ListView mListView;

    private Context mContext;
    private MainActivity mMainActivity;

    private ArrayAdapter<String> mAdapter;

    private final String[] mStrings = SearchCheeses.sCheeseStrings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        searchView = inflater.inflate(R.layout.fragment_search, null);
        mMainActivity = (MainActivity) getActivity();
        mContext = mMainActivity;

        findViews();

        mAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_expandable_list_item_1, mStrings);
        mListView.setAdapter(mAdapter);
        mListView.setTextFilterEnabled(true);
        mListView.setOnItemClickListener(new ListViewListener());
        setupSearchView();

        return searchView;
    }

    public void findViews() {
        mSearchView = (SearchView) searchView.findViewById(R.id.search_view);
        mListView = (ListView) searchView.findViewById(R.id.search_list);
    }

    private void setupSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setSubmitButtonEnabled(false);
        mSearchView.setQueryHint("OverHust");
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            mListView.clearTextFilter();
        } else {
            mListView.setFilterText(newText.toString());
        }
        return true;
    }

    class ListViewListener implements AdapterView.OnItemClickListener {
        ImageScrollView mImageSrollView;
        Resources mResources = mContext.getResources();
        XmlPullParser parser = mResources.getXml(R.layout.fragment_search);
        AttributeSet attributes = Xml.asAttributeSet(parser);

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch ((int) id) {
                case 0:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.st_image_urls);
                    break;
                case 1:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.jxl_image_urls);
                    break;
                case 2:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.cc_image_urls);
                    break;
                case 3:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.st_image_urls);
                    break;
                case 4:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.tyg_image_urls);
                    break;
                case 5:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.tyg_image_urls);
                    break;
                case 6:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.hkmj_image_urls);
                    break;
                case 7:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.zt_image_urls);
                    break;
                case 8:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.zt_image_urls);
                    break;
                case 9:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.sd_image_urls);
                    break;
                case 10:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.sd_image_urls);
                    break;
                case 11:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.kdd_image_urls);
                    break;
                case 12:
                    mImageSrollView = new ImageScrollView(mContext, attributes, Images.dyd_image_urls);
                    break;
                default:
                    break;
            }
        }
    }

}
