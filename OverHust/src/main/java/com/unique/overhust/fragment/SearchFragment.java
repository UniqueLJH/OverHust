package com.unique.overhust.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
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
public class SearchFragment extends Fragment implements TextWatcher {
    private View searchView;

    private EditText mEditText;
    private ListView mListView;
    private ImageView mImageView;
    private RelativeLayout mRelativeLayout;

    private Context mContext;
    private MainActivity mMainActivity;

    private ArrayAdapter<String> mAdapter;

    private final String[] mStrings = SearchCheeses.sCheeseStrings;

    private InputMethodManager mInputMethodManager;

    private ImageScrollView mImageSrollView;
    private Resources mResources;
    private XmlPullParser parser;
    private AttributeSet attributes;
    private String[] urls=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        searchView = inflater.inflate(R.layout.fragment_search, null);
        mMainActivity = (MainActivity) getActivity();
        mContext = mMainActivity;

        findViews();
        mInputMethodManager = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        mAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_expandable_list_item_1, mStrings);
        mListView.setAdapter(mAdapter);
        mListView.setTextFilterEnabled(true);
        mListView.setOnItemClickListener(new ListViewListener());


        mResources = mContext.getResources();
        parser = mResources.getXml(R.layout.fragment_search);
        attributes = Xml.asAttributeSet(parser);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().contains("食堂")) {
                    urls = Images.st_image_urls;
                    mImageSrollView = new ImageScrollView(mContext, attributes);
                    mImageSrollView.imageUrls=urls;
                    mImageSrollView.loadMoreImages();
                    Log.e("search",String.valueOf(urls));
                }
                mRelativeLayout.setVisibility(View.INVISIBLE);
            }
        });

        mEditText.addTextChangedListener(this);

        return searchView;
    }

    public void findViews() {
        mEditText = (EditText) searchView.findViewById(R.id.search_edit);
        mListView = (ListView) searchView.findViewById(R.id.search_list);
        mImageView = (ImageView) searchView.findViewById(R.id.search_into);
        mRelativeLayout = (RelativeLayout) searchView.findViewById(R.id.search_start);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before,
                              int count) {
        // TODO Auto-generated method stub
        String newText = s.toString();

        if (TextUtils.isEmpty(newText)) {
            dismissList();
            mAdapter.getFilter().filter(s);
        } else {
            showList();
            mAdapter.getFilter().filter(s);
        }


    }

    private void dismissList() {
        // TODO Auto-generated method stub
        mInputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        mListView.setVisibility(View.GONE);
        mImageView.setVisibility(View.VISIBLE);
    }

    private void showList() {
        // TODO Auto-generated method stub
        mListView.setVisibility(View.VISIBLE);
        mImageView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    @Override
    public void afterTextChanged(Editable s) {

    }

    class ListViewListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String search_results = mAdapter.getItem(position);
            mEditText.setText(search_results);
            dismissList();
        }
    }

}
