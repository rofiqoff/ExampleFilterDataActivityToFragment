package id.rofiqoff.examplefilterdataactivityfragment.java;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewpager.widget.ViewPager;

import id.rofiqoff.examplefilterdataactivityfragment.PagerAdapter;
import id.rofiqoff.examplefilterdataactivityfragment.R;

public class MainActivity extends AppCompatActivity {

    private SearchListener searchListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        AppCompatEditText editTextSearch = findViewById(R.id.edit_text_search);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new DataFragment(), "");

        viewPager.setAdapter(pagerAdapter);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (getDataSearch() != null) {
                    getDataSearch().onSearch(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private SearchListener getDataSearch() {
        return searchListener;
    }

    public void setDataSearch(SearchListener searchListener) {
        this.searchListener = searchListener;
    }

    interface SearchListener {
        void onSearch(String dataToString);
    }

}
