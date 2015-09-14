package com.hp.fucktesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class TestMateralDesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_materal_design);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DesignRecyclerViewAdapter());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_materal_design, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class DesignRecyclerViewAdapter extends RecyclerView.Adapter<DesignRecyclerViewAdapter.DesignRecyclerViewVH> {


        @Override
        public DesignRecyclerViewVH onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_selected, parent, false);
            return new DesignRecyclerViewVH(inflate);

        }

        @Override
        public void onBindViewHolder(DesignRecyclerViewVH holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 20;
        }

        public class DesignRecyclerViewVH extends RecyclerView.ViewHolder {

            public DesignRecyclerViewVH(View itemView) {
                super(itemView);
            }
        }

    }
}
