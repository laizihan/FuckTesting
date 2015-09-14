package com.hp.fucktesting;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class DesignActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CoordinatorLayout mCoordinatorLayout;
    private boolean flag = false;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new DesignRecyclerViewAdapter());
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_content);

/*        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(mCoordinatorLayout, "弹出来", Snackbar.LENGTH_SHORT).show();
                flag = true;
            }
        }, 5000);*/


      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    index++;
                    if (flag)
                        break;


                }

                Log.e("value of index", index + "");
            }
        }).start();*/

//        EventBus.getDefault().register(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_design, menu);
        return true;
    }

/*    public void onEventMainThread(DesignEvent.BackgroundEvent backgroundEvent) {

        Log.e("intent", "backgroundEvent" + backgroundEvent);

    }*/


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
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
